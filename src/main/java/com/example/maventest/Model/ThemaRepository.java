package com.example.maventest.Model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

    @Repository
    public interface ThemaRepository extends JpaRepository<Thema, Long> {
    }

