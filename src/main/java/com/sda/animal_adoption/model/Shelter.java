package com.sda.animal_adoption.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Shelter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   @Column
    private String name;

    @Column
    private String address;


    @OneToMany(mappedBy = "shelter", fetch = FetchType.LAZY)
    private List<User> users;

    @OneToMany(mappedBy = "shelter", fetch = FetchType.LAZY)
    private List<Animal> animals;


    public Shelter(Long id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public Shelter() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
