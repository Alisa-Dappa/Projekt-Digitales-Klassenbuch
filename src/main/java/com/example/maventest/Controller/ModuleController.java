package com.example.maventest.Controller;

import com.example.maventest.Model.Module;
import com.example.maventest.Model.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @Controller
    @RequestMapping("/module")
    public class ModuleController {

        @Autowired
        private ModuleRepository moduleRepository;

        @GetMapping("/")
        public List<Module> getAllModules() {
            return moduleRepository.findAll();
        }

        @GetMapping("/{id}")
        public Module getModuleById(@PathVariable Long id) {
            return moduleRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Modul wurde nicht gefunden."));
        }

        @PostMapping("/")
        @ResponseStatus(HttpStatus.CREATED)
        public Module createModule(@RequestBody Module module) {
            return moduleRepository.save(module);
        }

        @PutMapping("/{id}")
        public Module updateModule(@PathVariable Long id, @Validated @RequestBody Module moduleDetails) {
            Module module = moduleRepository.findById(id)
                            .orElseThrow(() -> new RuntimeException("Modul wurde nicht gefunden."));

            module.setName(moduleDetails.getName());

            Module updatedModul = moduleRepository.save(module);
            return updatedModul;
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<?> deleteModul(@PathVariable Long id) {
            Module module = moduleRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Modul wurde nicht gefunden."));

            moduleRepository.delete(module);

            return ResponseEntity.ok().build();
        }
    }
