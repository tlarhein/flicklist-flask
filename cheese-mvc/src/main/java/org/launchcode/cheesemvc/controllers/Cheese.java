package org.launchcode.cheesemvc.models;

public class Cheese {

    private int id;
    private String cheeseName;
    private String cheeseSize;
    private static int nextId = 0;


    public Cheese(String cheeseName, String cheeseSize) {
        this.id = nextId;
        this.cheeseName = cheeseName;
        this.cheeseSize = cheeseSize;
        nextId++;

    }

    public int getId() {
        return id;
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