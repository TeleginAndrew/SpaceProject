package com.example.demo.repo;

import com.example.demo.entity.Lord;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LordRepo extends JpaRepository<Lord,Long> {


}
