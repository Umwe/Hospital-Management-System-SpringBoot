package com.Umwe.hospitalmanagementsystem.Model;


import jakarta.persistence.*;

@Entity
@Table(name = "Department")
public class Department {

    @Id
    @Column(name = "Department_id")
    private String id;

    @Column(name = "Department_name")
    private String name;

    @Column(name = "Department_description")
    private String description;

    public Department() {
    }

    public Department(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
