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
    @Size(min=10, max=75, message = "Instrument name must be between 10 and 75 characters")
    private String instrumentName;

    @NotNull
    @Size (min=10, message = "Description field must not be empty, but should be at least 10 characters")
    private String description;

    @OneToMany
    private Project project;

    @ManyToMany(mappedBy = "instruments")
    private List<Response> responses = new ArrayList<>();

    public Instrument(Project project, String instrumentName, String description) {
        this.project = project;
        this.instrumentName = instrumentName;
        this.description = description;

    }
    public Instrument() {
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return instrumentName;
    }

    public void setName(String instrumentName) {
        this.instrumentName = instrumentName;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;

}

    public void addItem(Project aProject) {
    }
}

