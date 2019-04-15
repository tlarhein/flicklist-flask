package org.launchcode.cheesemvc.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Cheese {

    @NotNull
    @Size(min=3, max=15, message = "Cheese Name must be between 3 and 15 characters")
    private String cheeseName;

    @NotNull
    @Size (min=1, message = "Description field must not be empty")
    private String cheeseSize;

    private CheeseType type;

    private int cheeseId;
    private static int nextId = 1;


    public Cheese(String cheeseName, String cheeseSize) {
        this();
        this.cheeseName = cheeseName;
        this.cheeseSize = cheeseSize;

    }
    public Cheese() { //no arg constructor
        cheeseId = nextId;
        nextId++;

    }

    public int getCheeseId() {
        return cheeseId;
    }

    public void setCheeseId(int cheeseId) {
        this.cheeseId = cheeseId;
    }

    public String getCheeseName() {
        return cheeseName;
    }

    public void setCheeseName(String cheeseName) {
        this.cheeseName = cheeseName;
    }

    public String getCheeseSize() {
        return cheeseSize;
    }

    public void setCheeseSize(String cheeseSize) {
        this.cheeseSize = cheeseSize;
    }

    public CheeseType getType() {
        return type;
    }

    public void setType(CheeseType type) {
        this.type = type;
    }
}