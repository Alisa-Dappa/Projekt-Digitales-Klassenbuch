package com.example.mavenKlassenbuch.Main.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

//Erstellung der Tabelle "Module"
    @Entity
    @NoArgsConstructor
    @AllArgsConstructor
    public class Module {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String name;

        //Hier wird implementiert, dass ein Modul, mehrere Themen haben kann. => One to Many
        @OneToMany(mappedBy = "module", cascade = CascadeType.ALL, orphanRemoval = true)
        private List<Thema> themen;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Thema> getThemen() {
        return themen;
    }

    public void setThemen(List<Thema> themen) {
        this.themen = themen;
    }
}

