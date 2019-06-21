package org.launchcode.researchease.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tracey Cannon Liftoff 0519
 */

@Entity
public class Project {

    @Id //serves as the primary key
    @GeneratedValue  //tells hibernate to generate the value
    private int id;

    @NotNull
    @Size(min=9, max=50)
    private String projectName;

    @OneToMany
    @JoinColumn(name = "project_id")
    private final List<Instrument> instruments = new ArrayList<>();

    public Project(){}

    public Project(String name) {
        this.projectName = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return projectName;
    }

    public void setName(String name) {
        this.projectName = name;
    }

    public List<Instrument> getInstruments() {
        return instruments;
    }


    public String getUsers(String users) {
        return users;
    }

    private Object getUsers() {
        return getUsers();

}}

