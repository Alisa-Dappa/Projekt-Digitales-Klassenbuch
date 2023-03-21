package com.example.mavenKlassenbuch.Main.Controller;

import com.example.mavenKlassenbuch.Main.Model.Module;
import com.example.mavenKlassenbuch.Main.Model.ModuleRepository;
import com.example.mavenKlassenbuch.Main.Model.Thema;
import com.example.mavenKlassenbuch.Main.Model.ThemaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ThemaApiController {

    @Autowired
    private ThemaRepository themaRepository;
    private ModuleRepository moduleRepository;

    @GetMapping("/module/{module_Id}/thema")
    public List<Thema> getAllThemenByModule_Id(@PathVariable(value = "module_id") Long module_id) {
        return themaRepository.findByModule_Id(module_id);
    }
    @GetMapping("/thema/{id}")
    public Thema getThemaById(@PathVariable(value = "id") Long thema_id) {
        return themaRepository.findById(thema_id)
                .orElseThrow(() -> new EntityNotFoundException("Thema wurde nicht gefunden."));
    }

    @PostMapping("/module/{module_Id}/thema")
    public Thema createThema(@PathVariable(value = "module_Id") Long module_id, @Validated @RequestBody Thema thema) {
        Module module = moduleRepository.findById(module_id)
                .orElseThrow(() -> new EntityNotFoundException("Modul wurde nicht gefunden."));
        thema.setModule(module);
        return themaRepository.save(thema);
    }

    @PutMapping("/thema/{id}")
    public Thema updateThema(@PathVariable(value = "id") Long thema_id,
                             @Validated @RequestBody Thema themaDetails) {

        Thema thema = themaRepository.findById(thema_id)
                .orElseThrow(() -> new EntityNotFoundException("Thema wurde nicht gefunden."));

        thema.setDescription(themaDetails.getDescription());

        return themaRepository.save(thema);
    }

}
