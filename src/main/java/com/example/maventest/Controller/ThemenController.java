package com.example.maventest.Controller;

import com.example.maventest.Model.Themen;
import com.example.maventest.Model.ThemenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

    @Controller
    @RequestMapping("/themen")
    public class ThemenController {

        @Autowired
        private ThemenRepository themenRepository;

        @GetMapping("/{id}")
        public Optional<Themen> getThemenById(@PathVariable Long id) {
            return themenRepository.findById(id);
        }

        @PostMapping("/")
        @ResponseStatus(HttpStatus.CREATED)
        public Themen createThemen(@RequestBody Themen themen) {
            return themenRepository.save(themen);
        }

        @GetMapping("/")
        public List<Themen> getAllThemen() {
            return themenRepository.findAll();
        }
    }
