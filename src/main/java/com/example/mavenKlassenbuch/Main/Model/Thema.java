package com.example.mavenKlassenbuch.Main.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

    //Tabelle Themen erstellt
    @Entity
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public class Thema {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String bezeichnung;
        private String startDatum;
        private String endDatum;
        private String farbe;
        private String beschreibung;
        private String jsID;
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "module_id")
        private Module module;

    }
