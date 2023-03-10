package mischokTinyTurtle.Digitales.Klassenbuch;

import jakarta.persistence.*;

@Entity
@Table(name = "Schultage")
public class Schultage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String datum;

    @Column(name = "Wochentag")
    private String wochentag;

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public String getWochentag() {
        return wochentag;
    }

    public void setWochentag(String wochentag) {
        this.wochentag = wochentag;
    }
}
