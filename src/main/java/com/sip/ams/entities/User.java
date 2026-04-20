package com.sip.ams.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;

import java.util.Set;

import java.util.HashSet;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "users", uniqueConstraints = { @UniqueConstraint(columnNames = "username"),
        @UniqueConstraint(columnNames = "email") })
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 20)
    private String username;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;



    @NotBlank
    @Size(max = 120)
    private String password;


    @NotBlank
    @Size(max = 50)
    private String firstName;

    @NotBlank
    @Size(max = 50)
    private String lastName;

    @NotBlank
    @Size(max = 50)
    private String companyName;

    @NotBlank
    @Size(max = 50)
    private String phoneNumber;

    @NotBlank
    @Size(max = 50)
    private String country;



    public User(@NotBlank @Size(max = 20) String username, @NotBlank @Size(max = 50) @Email String email,
                @NotBlank @Size(max = 120) String password, @NotBlank @Size(max = 50) String firstName,
                @NotBlank @Size(max = 50) String lastName, @NotBlank @Size(max = 50) String companyName,
                @NotBlank @Size(max = 50) String phoneNumber, @NotBlank @Size(max = 50) String country) {
        super();
        this.username = username;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.companyName = companyName;
        this.phoneNumber = phoneNumber;
        this.country = country;
    }

    public User(@NotBlank @Size(max = 50) @Email String email,
                @NotBlank @Size(max = 20) String username,
                @NotBlank @Size(max = 120) String password,
                @NotBlank @Size(max = 50) String firstName,
                @NotBlank @Size(max = 50) String lastName) {

        this.username = username;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }



    @Override
    public String toString() {
        return "User [username=" + username + ", email=" + email + ", password=" + password
                + ", firstName=" + firstName + ", lastName=" + lastName + ", companyName=" + companyName
                + ", phoneNumber=" + phoneNumber + ", country=" + country + ", roles=" + roles + "]";
    }



    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public User() {
    }
}