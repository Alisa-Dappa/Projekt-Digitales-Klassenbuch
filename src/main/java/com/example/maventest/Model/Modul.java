package com.example.maventest.Model;

import jakarta.persistence.*;
import lombok.*;

    //Erstellung der Tabelle "Modul"
    @Entity
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public class Modul {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String name;
    }

