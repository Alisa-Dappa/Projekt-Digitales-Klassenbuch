package com.example.mavenKlassenbuch.Main.Controller;

import com.example.mavenKlassenbuch.Main.Model.Module;
import com.example.mavenKlassenbuch.Main.Model.ModuleRepository;
import com.example.mavenKlassenbuch.Main.Model.Thema;
import com.example.mavenKlassenbuch.Main.Model.ThemaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ModuleApiController {

    @Autowired
    private ModuleRepository moduleRepository;
    @Autowired
    private ThemaRepository themaRepository;

    @GetMapping("/module")
    public List<Module> getAllModules() {
        return moduleRepository.findAll();
    }

    @GetMapping("/dashboard-home")
    public String getModule(Model model) {
        List<Module> moduleList = moduleRepository.findAll();
        model.addAttribute("moduleList", moduleList);
        return "dashboard-home.html";
    }

    @GetMapping("/module/{id}")
    public Module getModuleById(@PathVariable(value = "id") Long module_id) {
        return moduleRepository.findById(module_id)
                .orElseThrow(() -> new EntityNotFoundException("Modul wurde nicht gefunden."));
    }

    @PostMapping("/module/{id}")
    public Module createModule(@Validated @RequestBody Module module) {
        return moduleRepository.save(module);
    }

    @PutMapping("/module/{module_id}")
    public Module updateModule(@PathVariable(value = "module_id") Long module_id, @Validated @RequestBody Module moduleDetails) {
        Module module = moduleRepository.findById(module_id)
                .orElseThrow(() -> new EntityNotFoundException("Modul wurde nicht gefunden."));

        module.setName(moduleDetails.getName());

        return moduleRepository.save(module);
    }

    @DeleteMapping("/module/{id}")
    public ResponseEntity<?> deleteModule(@PathVariable(value = "id") Long moduleId) {
        Module module = moduleRepository.findById(moduleId)
                .orElseThrow(() -> new EntityNotFoundException("Modul wurde nicht gefunden."));
        List<Thema> thema = themaRepository.findByModuleId(moduleId);
        themaRepository.deleteAll(thema);
        moduleRepository.delete(module);
        return ResponseEntity.ok().build();
    }
}
