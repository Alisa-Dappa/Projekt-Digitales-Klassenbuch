package com.example.mavenKlassenbuch.Main.Model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
    public interface ThemaRepository extends JpaRepository<Thema, Long> {

        List<Thema> findByModule_Id(Long module_id);
        Optional<Thema> findById(Long id);

}

