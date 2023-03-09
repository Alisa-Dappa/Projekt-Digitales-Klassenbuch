package mischokTinyTurtle.Digitales.Klassenbuch;

import jakarta.persistence.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Thema")
public class Thema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "Modul_id")
    private int modul_id;

    @Column(name = "Bezeichnung")
    private String bezeichnung;

    @Repository
    public interface ThemaRepository extends JpaRepository<Thema, Long> {}
}
