package com.example.maventest.Controller;

import com.example.maventest.Model.*;
import com.example.maventest.Model.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    @RequestMapping("/api")
    public class MyController {

        @GetMapping("/dashboard")
        public String dashboard(@RequestParam(name = "Klassenbuch", required = false) String name, Model model) {
            model.addAttribute("Klassenbuch", name);
            return "dashboard";
        }

        @Autowired
        private ModuleRepository moduleRepository;

        @Autowired
        private ThemaRepository themaRepository;

        @GetMapping("/")
        public List<Module> getAllModules() {
            return moduleRepository.findAll();
        }

        @GetMapping("/module/{id}")
        public Module getModuleById(@PathVariable(value = "id") Long module_id) {
            return moduleRepository.findById(module_id)
                    .orElseThrow(() -> new RuntimeException("Modul wurde nicht gefunden."));
        }

        @PostMapping("/module")
        public Module createModule(@Validated @RequestBody Module module) {
            return moduleRepository.save(module);
        }

        @PutMapping("/module/{module_id}")
        public Module updateModule(@PathVariable(value = "id") Long module_id, @Validated @RequestBody Module moduleDetails) {
            Module module = moduleRepository.findById(module_id)
                            .orElseThrow(() -> new RuntimeException("Modul wurde nicht gefunden."));

            module.setName(moduleDetails.getName());

            return moduleRepository.save(module);
        }

        @DeleteMapping("/module/{id}")
        public ResponseEntity<?> deleteModul(@PathVariable(value = "id") Long module_id) {
            Module module = moduleRepository.findById(module_id)
                    .orElseThrow(() -> new RuntimeException("Modul wurde nicht gefunden."));

            moduleRepository.delete(module);

            return ResponseEntity.ok().build();
        }

        @GetMapping("/module/{module_Id}/themen")
        public List<Thema> getAllThemenByModule_Id(@PathVariable(value = "module_id") Long module_id) {
            return themaRepository.findByModule_Id(module_id);
        }

        @GetMapping("/themen/{id}")
        public Thema getThemaById(@PathVariable(value = "id") Long thema_id) {
            return themaRepository.findById(thema_id)
                    .orElseThrow(() -> new RuntimeException("Thema wurde nicht gefunden."));
        }

        @PostMapping("/module/{module_id}/themen")
        public Thema createThema(@PathVariable(value = "module_id") Long module_id,
                                 @Validated @RequestBody Thema thema) {
            return moduleRepository.findById(module_id).map(module -> {
                thema.setModule(module);
                return themaRepository.save(thema);
            }).orElseThrow(() -> new RuntimeException("Thema wurde nicht gefunden."));
        }

        @PutMapping("/themen/{id}")
        public Thema updateThema(@PathVariable(value = "id") Long thema_id,
                                 @Validated @RequestBody Thema themaDetails) {

            Thema thema = themaRepository.findById(thema_id)
                    .orElseThrow(() -> new RuntimeException("Thema wurde nicht gefunden."));

            thema.setBezeichnung(themaDetails.getBezeichnung());

            return themaRepository.save(thema);
        }
    }

