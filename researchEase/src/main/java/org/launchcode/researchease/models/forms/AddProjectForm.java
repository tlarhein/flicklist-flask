package org.launchcode.researchease.models.forms;

import org.launchcode.researchease.models.Instrument;
import org.launchcode.researchease.models.Project;

import javax.validation.constraints.NotNull;

public class AddProjectForm {

    private Project project;

    private Iterable<Instrument> instruments;

    @NotNull
    private int projectId;

    @NotNull
    private int instrumentId;

    public AddProjectForm(Project project, Iterable<Instrument> instruments) {
        this.project = project;
        this.instruments = instruments;
    }

    public AddProjectForm() {
    }

    public  Project getProject() {
        return project;
    }

    public Iterable<Instrument> getInstruments() {
        return instruments;
    }

    public int getProjectId() {
        return projectId;
    }

    public int getInstrumentId() {
        return instrumentId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public void setInstrumentId(int instrumentId) {
        this.instrumentId = instrumentId;
    }
}

