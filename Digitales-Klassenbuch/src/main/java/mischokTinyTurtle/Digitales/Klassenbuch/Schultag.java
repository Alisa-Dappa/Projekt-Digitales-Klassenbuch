package mischokTinyTurtle.Digitales.Klassenbuch;

import jakarta.persistence.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Entity
@Table(name = "Schultag")
public class Schultag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Datum")
    private String datum;

    @Column(name = "Wochentag")
    private String wochentag;

    @Repository
    public interface SchultagRepository extends JpaRepository<Schultag, Long> {}
}
