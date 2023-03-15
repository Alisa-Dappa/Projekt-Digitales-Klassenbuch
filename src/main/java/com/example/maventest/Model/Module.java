package com.example.maventest.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

//Erstellung der Tabelle "Module"
    @Entity
    @Getter
    @Setter
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

    }

