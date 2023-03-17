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

    public String getStartDatum() {
        return startDatum;
    }

    public void setStartDatum(String startDatum) {
        this.startDatum = startDatum;
    }

    public String getEndDatum() {
        return endDatum;
    }

    public void setEndDatum(String endDatum) {
        this.endDatum = endDatum;
    }

    public String getFarbe() {
        return farbe;
    }

    public void setFarbe(String farbe) {
        this.farbe = farbe;
    }

    public String getJsID() {
        return jsID;
    }

    public void setJsID(String jsID) {
        this.jsID = jsID;
    }

    public List<Thema> getThemen() {
        return themen;
    }

    public void setThemen(List<Thema> themen) {
        this.themen = themen;
    }
}

