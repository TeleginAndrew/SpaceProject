package com.example.demo.repo;

import com.example.demo.entity.Planet;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PlanetRepo extends JpaRepository<Planet,Long> {
    Planet findAllById(int id);



}
