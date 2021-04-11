package com.example.demo.controller;

import com.example.demo.entity.Lord;
import com.example.demo.entity.Planet;
import com.example.demo.dao.LordDAO;
import com.example.demo.repo.LordRepo;
import com.example.demo.repo.PlanetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRESTController {

    @Autowired
    PlanetRepo planetRepo;

    @Autowired
    LordRepo lordRepo;

    @Autowired
    LordDAO lordDAO;


    @GetMapping("/planets/{id}")
    public Planet getPlanet(@PathVariable int id) {
        Planet planet = planetRepo.findAllById(id);
        return planet;
    }

    @PostMapping("/planets")
    public Planet addPlanet(@RequestBody Planet planet) {
        planetRepo.save(planet);
        return planet;
    }

    @DeleteMapping("/planets/{id}")
    public String deletePlanet(@PathVariable int id) {
        Planet planet = planetRepo.findAllById(id);
        planetRepo.delete(planet);
        return "Planet with ID = " + id + " was deleted";
    }

    @PostMapping("/lord")
    public Lord addLord(@RequestBody Lord lord) {
        lordRepo.save(lord);
        return lord;
    }

    @GetMapping("/lords")
    public List<Lord> showTopYoungestLords() {
        List<Lord> lords = lordDAO.showTopYoungestLords();
        return lords;
    }

    @GetMapping("/lords-do-nothing")
    public List<Lord> showDoNothingLords() {
//        List<Lord> lords = lordDAO.showDoNothingLords();
        List<Lord> lords = lordRepo.findAllByPlanetsNull();
        return lords;
    }

}
