package com.example.mavenKlassenbuch.Main.Controller;

import com.example.mavenKlassenbuch.Main.Model.Module;
import com.example.mavenKlassenbuch.Main.Model.ModuleRepository;
import com.example.mavenKlassenbuch.Main.Model.Thema;
import com.example.mavenKlassenbuch.Main.Model.ThemaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.hibernate.tool.schema.internal.exec.ScriptTargetOutputToFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class ThemaApiController {

    @Autowired
    private final ThemaRepository themaRepository;

    @Autowired
    private final ModuleRepository moduleRepository;

    public ThemaApiController(ThemaRepository themaRepository, ModuleRepository moduleRepository) {
        this.themaRepository = themaRepository;
        this.moduleRepository = moduleRepository;
    }

    @GetMapping("/api/thema")
    public List<Thema> getallThemen() {
        return themaRepository.findAll();
    }

    @GetMapping("/api/module/{module_id}/thema")
    public List<Thema> getAllThemenByModule_Id(@PathVariable(value = "module_id") Long module_id) {
        return themaRepository.findByModule_Id(module_id);
    }
    @GetMapping("/api/thema/{id}")
    public Thema getThemaById(@PathVariable(value = "id") Long thema_id) {
        return themaRepository.findById(thema_id)
                .orElseThrow(() -> new EntityNotFoundException("Thema wurde nicht gefunden."));
    }

    @PostMapping("/api/module/{module_id}/thema")
    public Thema createThema(@PathVariable(value = "module_id") Long module_id, @Validated @RequestBody Thema thema) {
        Module module = moduleRepository.findById(module_id)
                .orElseThrow(() -> new EntityNotFoundException("Modul wurde nicht gefunden."));
        thema.setModule(module);
        return themaRepository.save(thema);
    }


    @PutMapping("/api/thema/{id}")
    public Thema updateThema(@PathVariable(value = "id") Long thema_id,
                             @Validated @RequestBody Thema themaDetails) {

        Thema thema = themaRepository.findById(thema_id)
                .orElseThrow(() -> new EntityNotFoundException("Thema wurde nicht gefunden."));
        thema.setTitle(themaDetails.getTitle());
        thema.setStartD(themaDetails.getStartD());
        thema.setEndD(themaDetails.getEndD());
        thema.setColor(themaDetails.getColor());
        thema.setDescription(themaDetails.getDescription());
        thema.setJsID(themaDetails.getJsID());
        thema.setModule(thema.getModule());

        return themaRepository.save(thema);
    }


    @DeleteMapping("/api/thema/{id}")
    public ResponseEntity<?> deleteThema(@PathVariable(value = "id") Long thema_id) {
        Thema thema = themaRepository.findById(thema_id)
                .orElseThrow(() -> new EntityNotFoundException("Thema wurde nicht gefunden."));
        themaRepository.delete(thema);
        return ResponseEntity.ok().build();
    }
}

