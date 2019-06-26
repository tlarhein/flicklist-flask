package org.launchcode.researchease.models.forms;

import org.launchcode.researchease.models.Instrument;
import org.launchcode.researchease.models.Response;

import javax.validation.constraints.NotNull;

/**
 * Created by Tracey Cannon Liftoff 0519
 */
public class AddResponseForm {

    private Response response;

    private Iterable<Instrument> instruments;

    @NotNull
    private int responseId;

    @NotNull
    private int instrumentId;

    public AddResponseForm(Response response, Iterable<Instrument> instruments) {
        this.response = response;
        this.instruments = instruments;
    }

    public AddResponseForm() {
    }

    public Response getResponse() {
        return response;
    }

    public Iterable<Instrument> getInstruments() {
        return instruments;
    }

    public int getResponseId() {
        return responseId;
    }

    public int getInstrumentId() {
        return instrumentId;
    }

    public void setResponseId(int responseId) {
        this.responseId = responseId;
    }

    public void setInstrumentId(int instrumentId) {
        this.instrumentId = instrumentId;
    }
}
