package com.example.mavenKlassenbuch.Main.Controller;

import com.example.mavenKlassenbuch.Main.Model.Module;
import com.example.mavenKlassenbuch.Main.Model.ModuleRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ModuleApiController {

    @Autowired
    private ModuleRepository moduleRepository;

    @GetMapping("/module")
    public List<Module> getAllModules() {
        return moduleRepository.findAll();
    }

    @GetMapping("/module/{id}")
    public Module getModuleById(@PathVariable(value = "id") Long module_id) {
        return moduleRepository.findById(module_id)
                .orElseThrow(() -> new EntityNotFoundException("Modul wurde nicht gefunden."));
    }

    @PostMapping("/module")
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
    public ResponseEntity<?> deleteModul(@PathVariable(value = "id") Long module_id) {
        Module module = moduleRepository.findById(module_id)
                .orElseThrow(() -> new EntityNotFoundException("Modul wurde nicht gefunden."));

        moduleRepository.delete(module);

        return ResponseEntity.ok().build();
    }
}
