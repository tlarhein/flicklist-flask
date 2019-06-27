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
public class Instrument {

    @Id //serves as the primary key
    @GeneratedValue  //tells hibernate to generate the value for me
    private int id;

    @NotNull
    @Size(min=10, max=30, message = "Instrument name must not be empty, but should be at least 10 characters")
    private String instrumentName;

    @NotNull
    @Size (min=4, message = "Description field must not be empty, but should be at least 4 characters")
    private String description;

    @ManyToOne
    private Project project;

    @ManyToMany(mappedBy = "instruments")
    private List<Response> responses = new ArrayList<>();

    public Instrument(String name, String description) {
        this.instrumentName = name;
        this.description = description;

    }
    public Instrument() {}

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return instrumentName;
    }

    public void setName(String name) {
        this.instrumentName = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;


     }

    public String getInstrumentName() {
        return instrumentName;
    }

    public void setInstrumentName(String instrumentName) {
        this.instrumentName = instrumentName;
    }

    public List<Response> getResponses() {
        return responses;
    }

    public void setResponses(List<Response> responses) {
        this.responses = responses;
    }

    public void addItem(Project aProject) {
    }


    }

