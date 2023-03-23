package com.example.mavenKlassenbuch.Main.Controller;

import com.example.mavenKlassenbuch.Main.Model.*;
import com.example.mavenKlassenbuch.Main.Model.Module;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @Controller
    @RequestMapping
    public class MyController {

        @Autowired
        private final ModuleRepository moduleRepository;

        @Autowired
        private final ThemaRepository themaRepository;

        public MyController(ModuleRepository moduleRepository, ThemaRepository themaRepository) {  //Konstruktor hat die Interfaces als Parameter
            this.moduleRepository = moduleRepository;
            this.themaRepository = themaRepository;
        }

        @GetMapping("/dashboard-home")
        public String getModule(Model model) {
            List<Module> moduleList = moduleRepository.findAll();
            model.addAttribute("moduleList", moduleList);
            return "dashboard-home.html";
        }

        @GetMapping("/dashboard-anwesenheitsliste")
        public String anwesenheitsliste(@RequestParam(name = "Klassenbuch", required = false) String name, Model model) {
            model.addAttribute("Klassenbuch", name);
            return "dashboard-anwesenheitsliste";
        }
        @GetMapping("/dashboard-klassentools")
        public String klassentools(@RequestParam(name = "Klassenbuch", required = false) String name, Model model) {
            model.addAttribute("Klassenbuch", name);
            return "dashboard-klassentools";
        }

        @GetMapping("/")
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

        @GetMapping("/module/{module_id}/thema")
        public List<Thema> getAllThemenByModule_Id(@PathVariable(value = "module_id") Long module_id) {
            return themaRepository.findByModule_Id(module_id);
        }

        @GetMapping("/thema/{id}")
        public Thema getThemaById(@PathVariable(value = "id") Long thema_id) {
            return themaRepository.findById(thema_id)
                    .orElseThrow(() -> new EntityNotFoundException("Thema wurde nicht gefunden."));
        }

        @PostMapping("/module/{module_id}/thema")
        public Thema createThema(@PathVariable(value = "module_id") Long module_id, @Validated @RequestBody Thema thema) {
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

            thema.setStartD(thema.getStartD());
            thema.setEndD(thema.getEndD());
            thema.setColor(thema.getColor());
            thema.setDescription(themaDetails.getDescription());
            thema.setJsID(thema.getJsID());
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

