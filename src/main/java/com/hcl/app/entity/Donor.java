package com.hcl.app.entity;

import java.beans.JavaBean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@JavaBean
@Entity
@Table(name = "donor")
public class Donor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long donorID;

    @Column(nullable = false)
    @NotBlank(message = "Name is required")
    private String Name;


    @Column(nullable = false)
    private String bloodGroup;

    @Column(unique = true, nullable = false)
    private String phone;

    @Column(nullable = false)
    private String city;

    public Long getUserID() {
        return donorID;
    }
    
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Override
    public String toString() {
        return "User [userID=" + donorID + ", Name=" + Name + ", bloodGroup=" + bloodGroup + ", city=" + city + "]";
    }

    public String getBloodGroup() {
        return bloodGroup;
    }
    
    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }
    
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Donor(String Name, String bloodGroup, String city) {
        super();
        this.Name = Name;
        this.bloodGroup = bloodGroup;
        this.city = city;
    }

    public Donor() {
        super();
    }    
}
