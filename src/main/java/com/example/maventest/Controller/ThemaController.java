package com.example.maventest.Controller;

import com.example.maventest.Model.Thema;
import com.example.maventest.Model.ThemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/themen")
public class ThemaController {

    @Autowired
    private ThemaRepository themaRepository;

    @GetMapping("/")
    public List<Thema> getAllThemen() {
        return themaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Thema getThemaById(@PathVariable(value = "id") Long themaId) {
        return themaRepository.findById(themaId)
                .orElseThrow(() -> new RuntimeException("Thema wurde nicht gefunden."));
    }

    @PostMapping("/")
    public Thema createThema(@Validated @RequestBody Thema thema) {
        return themaRepository.save(thema);
    }

    @PutMapping("/{id}")
    public Thema updateThema(@PathVariable(value = "id") Long themaId, @Validated @RequestBody Thema themaDetails) {
        Thema thema = themaRepository.findById(themaId)
                .orElseThrow(() -> new RuntimeException("Thema wurde nicht gefunden."));

        thema.setModul_id(themaDetails.getModul_id());
        thema.setBezeichnung(themaDetails.getBezeichnung());

        Thema updatedThema = themaRepository.save(thema);
        return updatedThema;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteThema(@PathVariable(value = "id") Long themaId) {
        Thema thema = themaRepository.findById(themaId)
                .orElseThrow(() -> new RuntimeException("Thema wurde nicht gefunden."));

        themaRepository.delete(thema);

        return ResponseEntity.ok().build();
    }
}
