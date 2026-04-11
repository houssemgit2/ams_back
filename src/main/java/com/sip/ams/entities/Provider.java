package com.sip.ams.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Provider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String address;

    // constructeur vide (obligatoire JPA)
    public Provider() {
    }

    // constructeur avec paramètres
    public Provider(String name, String email, String address) {
        this.name = name;
        this.email = email;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Provider [id=" + id + ", name=" + name + ", email=" + email + ", address=" + address + "]";
    }

    // GETTERS
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    // SETTERS
    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}