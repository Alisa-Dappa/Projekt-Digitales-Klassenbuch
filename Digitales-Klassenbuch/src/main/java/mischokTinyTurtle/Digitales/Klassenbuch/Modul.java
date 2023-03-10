package mischokTinyTurtle.Digitales.Klassenbuch;

import jakarta.persistence.*;
import lombok.*;

    //Erstellung der Tabelle "Modul"
    @Entity
    @Table(name = "Modul")
    public class Modul {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "Name")
        private String name;

        //Getter und Setter für die erstellten Spalten
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
    }

