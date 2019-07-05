package org.launchcode.researchease.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;

/**
 * Created by Tracey Cannon Liftoff 0519
 */

@Entity
public class Project {

    private long id;
    private String projectName;
    private ArrayList instruments;
    private ArrayList user;


    public Project() {}

    public Project(String projectName) {
        this.projectName = projectName;
        //user = new ArrayList<>();
    }

    @Column
    @Id //serves as the primary key
    @GeneratedValue(strategy = GenerationType.AUTO)  //tells hibernate to generate the value
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column
    @NotNull
    @Size(min = 9, max = 50)
    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    @OneToMany
    @JoinColumn(name = "project_id")
    //private User user;



    //return project;
    // }
    //// public void setProject(Project project){
    //  this.project = project;


    public void setUser(ArrayList user) {
        this.user = user;
    }


    public ArrayList getInstruments() {
        return instruments;
    }

    public void setInstruments(ArrayList instruments) {
        this.instruments = instruments;
    }

    public ArrayList getUser() {
       return user;
    }}

    //public String getUser() {
        //return user;




//private Object getUsers() {
        //return getUsers();



