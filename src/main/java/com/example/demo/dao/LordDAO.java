package com.example.demo.dao;

import com.example.demo.entity.Lord;
import com.example.demo.entity.Planet;

import java.util.List;

public interface LordDAO {
    List<Lord> showTopYoungestLords();

    List<Lord> showDoNothingLords();

    void addLordUsePlanet(Planet planet, Lord lord);
}
