package mischokTinyTurtle.Digitales.Klassenbuch;

import jakarta.persistence.*;

@Entity
@Table(name = "Themen")
public class Themen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Modul_id")
    private Long modul_id;

    @Column(name = "Bezeichnung")
    private String bezeichnung;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getModul_id() {
        return modul_id;
    }

    public void setModul_id(Long modul_id) {
        this.modul_id = modul_id;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }
}
