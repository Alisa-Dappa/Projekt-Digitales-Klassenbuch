package com.example.maventest.Controller;

import com.example.maventest.Model.*;
import com.example.maventest.Model.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


    @RestController
    @RequestMapping("/api")
    public class MyController {

        @Autowired
        private ModuleRepository moduleRepository;

        @Autowired
        private ThemaRepository themaRepository;

        @GetMapping("/")
        public List<Module> getAllModules() {
            return moduleRepository.findAll();
        }

        @GetMapping("/module/{id}")
        public Module getModuleById(@PathVariable(value = "id") Long modulid) {
            return moduleRepository.findById(modulid)
                    .orElseThrow(() -> new RuntimeException("Modul wurde nicht gefunden."));
        }

        @PostMapping("/module")
        public Module createModule(@Validated @RequestBody Module module) {
            return moduleRepository.save(module);
        }

        @PutMapping("/module/{modulid}")
        public Module updateModule(@PathVariable(value = "id") Long modulid, @Validated @RequestBody Module moduleDetails) {
            Module module = moduleRepository.findById(modulid)
                    .orElseThrow(() -> new RuntimeException("Modul wurde nicht gefunden."));

            Module modul = moduleRepository.findById(modulid)
                            .orElseThrow(() -> new RuntimeException("Modul wurde nicht gefunden."));

            module.setName(moduleDetails.getName());

            return moduleRepository.save(module);
        }

        @DeleteMapping("/module/{id}")
        public ResponseEntity<?> deleteModul(@PathVariable(value = "id") Long modulid) {
            Module module = moduleRepository.findById(modulid)
                    .orElseThrow(() -> new RuntimeException("Modul wurde nicht gefunden."));

            moduleRepository.delete(module);

            return ResponseEntity.ok().build();
        }

        @GetMapping("/module/{modulId}/themen")
        public List<Thema> getAllThemenByModulId(@PathVariable(value = "modulId") Long modulId) {
            return themaRepository.findByModulId(modulId);
        }

        @GetMapping("/themen/{id}")
        public Thema getThemaById(@PathVariable(value = "id") Long themaId) {
            return themaRepository.findById(themaId)
                    .orElseThrow(() -> new RuntimeException("Thema wurde nicht gefunden."));
        }

        @PostMapping("/module/{modulId}/themen")
        public Thema createThema(@PathVariable(value = "modulId") Long modulId,
                                 @Validated @RequestBody Thema thema) {
            return moduleRepository.findById(modulId).map(module -> {
                thema.setModul_id(module);
                return themaRepository.save(thema);
            }).orElseThrow(() -> new RuntimeException("Thema wurde nicht gefunden."));
        }

        @PutMapping("/themen/{id}")
        public Thema updateThema(@PathVariable(value = "id") Long themaId,
                                 @Validated @RequestBody Thema themaDetails) {

            Thema thema = themaRepository.findById(themaId)
                    .orElseThrow(() -> new RuntimeException("Thema wurde nicht gefunden."));

            thema.setBezeichnung(themaDetails.getBezeichnung());

            return themaRepository.save(thema);
        }
    }

