package com.example.mavenKlassenbuch.Main.Model;

import com.example.mavenKlassenbuch.Main.Model.Thema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

    @Repository
    public interface ThemaRepository extends JpaRepository<Thema, Long> {

        List<Thema> findByModule_Id(Long module_id);
    }

