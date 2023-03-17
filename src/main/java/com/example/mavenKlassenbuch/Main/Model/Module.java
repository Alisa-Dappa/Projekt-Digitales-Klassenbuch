package com.example.mavenKlassenbuch.Main.Model;

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
        private String startDatum;
        private String endDatum;
        private String farbe;
        private String jsID;

        //Hier wird implementiert, dass ein Modul, mehrere Themen haben kann. => One to Many
        @OneToMany(mappedBy = "module", cascade = CascadeType.ALL, orphanRemoval = true)
        private List<Thema> themen;

    }

