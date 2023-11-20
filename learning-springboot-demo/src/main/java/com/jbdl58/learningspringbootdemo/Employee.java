package com.jbdl58.learningspringbootdemo;

public class Employee {

    private int id;

    private String name;

    private String emailId;

    private String designation;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        System.out.println("I am coming to setId code");
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }


}
