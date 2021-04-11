package com.example.demo.controller;

import com.example.demo.dao.LordDAO;
import com.example.demo.entity.Lord;
import com.example.demo.entity.Planet;
import com.example.demo.repo.LordRepo;
import com.example.demo.repo.PlanetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/web")
public class WebRESTController {

    @Autowired
    PlanetRepo planetRepo;

    @Autowired
    LordRepo lordRepo;

    @Autowired
    LordDAO lordDAO;

    @GetMapping("/")
    public String main() {
        return "main";
    }

    @GetMapping("/planets")
    public String showAllPlanets(Model model) {
        List<Planet> list = planetRepo.findAll();
        model.addAttribute("list_planet", list);
        return "planets";
    }

    @GetMapping("/planet/add")
    public String addPlanetPage() {
        return "addplanet";
    }

    @PostMapping("/planet/add")
    public String addPlanet(@RequestParam("name") String name) {
        Planet planet = new Planet();
        planet.setName(name);
        planetRepo.save(planet);
        return "redirect:/web/";
    }

    @PostMapping("/planets/{id}")
    public String deletePlanet(@PathVariable int id) {
        Planet planet = planetRepo.findAllById(id);
        planetRepo.delete(planet);
        return "redirect:/web/";
    }

    @GetMapping("/lord/add")
    public String addLordPage() {
        return "add-lord";
    }

    @PostMapping("/lord/add")
    public String addLord(@RequestParam("name") String name,
                          @RequestParam("age") int age) {
        Lord lord = new Lord(name, age);
        lordRepo.save(lord);
        return "redirect:/web/";
    }

    @GetMapping("/lords")
    public String showLords(Model model) {
        List<Lord> lords = lordDAO.showTopYoungestLords();
        model.addAttribute("list_lords", lords);
        return "alllords";
    }

    @GetMapping("/lords-young")
    public String showTopYoungestLords(Model model) {
        List<Lord> lords = lordDAO.showTopYoungestLords();
        model.addAttribute("list_lords", lords);
        return "younglords";
    }

    @GetMapping("/lords-do-nothing")
    public String showDoNothingLords(Model model) {
        List<Lord> lords = lordRepo.findAllByPlanetsNull();
        model.addAttribute("list_lords", lords);
        return "lords-do-nothing";
    }


    // page for add lord for planet
    @GetMapping("/lord-for-planet")
    public String lordForPlanet() {
        return "lord-to-planet";
    }

    // lord for planet
    @PostMapping("/lord-for-planet")
    public String orderRulerToPlanetPost(@RequestParam("lord_id") int lord_id,
                                         @RequestParam("planet_id") int planet_id) {

        Lord lord = lordRepo.findById(lord_id);
        Planet planet = planetRepo.findById(planet_id);
        planet.setLord(lord);
        planetRepo.save(planet);
        return "redirect:/web/";
    }
}
