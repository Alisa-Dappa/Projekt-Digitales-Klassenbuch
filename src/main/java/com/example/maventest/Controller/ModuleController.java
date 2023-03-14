package com.example.maventest.Controller;

import com.example.maventest.Model.Module;
import com.example.maventest.Model.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

    @Controller
    @RequestMapping("/module")
    public class ModuleController {

        @Autowired
        private ModuleRepository moduleRepository;

        @GetMapping("/{id}")
        public Optional<Module> getModuleById(@PathVariable Long id) {
            return moduleRepository.findById(id);
        }

        @PostMapping("/")
        @ResponseStatus(HttpStatus.CREATED)
        public Module createModule(@RequestBody Module module) {
            return moduleRepository.save(module);
        }

        @GetMapping("/")
        public List<Module> getAllModules() {
            return moduleRepository.findAll();
        }
    }
