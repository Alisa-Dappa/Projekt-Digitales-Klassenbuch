package com.example.mavenKlassenbuch.Main.Model;

import com.example.mavenKlassenbuch.Main.Model.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ModuleRepository extends JpaRepository<Module, Long> {
    }
