package com.example.demo.dao;

import com.example.demo.entity.Lord;

import java.util.List;

public interface LordDAO {
    List<Lord> showTopYoungestLords();

    List<Lord> showDoNothingLords();
}
