package org.launchcode.cheesemvc.models;

public class Cheese {


    private String cheeseName;
    private String cheeseSize;
    private int cheeseId;
    private static int nextId=1;


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
}