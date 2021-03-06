package com.example.demo.repo;

import com.example.demo.entity.Lord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface LordRepo extends JpaRepository<Lord, Long> {

    Lord findById(int id);
List<Lord> findAllByPlanetsNull();


}
