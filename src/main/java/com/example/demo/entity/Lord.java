package com.example.demo.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "lord")
public class Lord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "age")
    private int age;

    @Column(name = "name")
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lord")
    private List<Planet> planets;


    public Lord() {
    }

    public Lord(String name,int age) {
        this.name = name;
        this.age = age;

    }

    public Lord(int age, String name, List<Planet> planets) {
        this.age = age;
        this.name = name;
        this.planets = planets;
    }

    public Lord(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public Lord(int id, int age, String name, List<Planet> planets) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.planets = planets;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
