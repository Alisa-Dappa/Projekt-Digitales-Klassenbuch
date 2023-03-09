package mischokTinyTurtle.Digitales.Klassenbuch;

import jakarta.persistence.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Module")
public class Module {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "Datum")
    private String datum;

    @Column(name = "Name")
    private String name;

    @Column(name = "Stundenzahl")
    private int stundenzahl;

    @Repository
    public interface ModuleRepository extends JpaRepository<Module, Long> {}
}
