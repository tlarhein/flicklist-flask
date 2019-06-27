package org.launchcode.researchease.models.forms;

import org.launchcode.researchease.models.Instrument;
import org.launchcode.researchease.models.Project;

import javax.validation.constraints.NotNull;

/**
 * Created by Tracey Cannon Liftoff 0519
 */
public class AddInstrumentForm {

    private Instrument instrument;

    private Iterable<Project> projects;

    @NotNull
    private int instrumentId;

    @NotNull
    private int projectId;

    //@NotNull
   // private int responseId;

    public AddInstrumentForm(Instrument instrument, Iterable<Project> projects) {
        this.instrument = instrument;
        this.projects = projects;

    }

    public AddInstrumentForm() {
    }

    public Instrument getInstrument() {
        return instrument;
    }

    public Iterable<Project> getProjects() {
        return projects;
    }

    public int getInstrumentId() {
        return instrumentId;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setInstrumentId(int instrumentId) {
        this.instrumentId = instrumentId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }


   // public Integer getResponseId() {
        //return responseId;
    //}

    //public void setResponseId(Integer responseId) {
        //this.responseId = responseId;
    }


