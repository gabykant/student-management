package com.ksoft.sms.api.models;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class Student extends Person {


    @Column(nullable = false)

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Date dob;

    @Column(nullable = false)
    private String address;

    @OneToOne
    private Parent father;
    @OneToOne
    private Parent mother;

    public Student() {
    }

    public int getId() {
        return id;
    }

    public Date getDob() {
        return dob;
    }

    public String getAddress() {
        return address;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Parent getFather() {
        return father;
    }

    public void setFather(Parent father) {
        this.father = father;
    }

    public Parent getMother() {
        return mother;
    }

    public void setMother(Parent mother) {
        this.mother = mother;
    }
}
