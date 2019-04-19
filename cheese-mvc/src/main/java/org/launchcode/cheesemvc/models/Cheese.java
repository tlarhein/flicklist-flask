package org.launchcode.cheesemvc.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Created by LaunchCode
 */

@Entity
public class Cheese {

    @Id //serves as the primary key
    @GeneratedValue  //tells hibernate to generate the value for us
    private int id;

    @NotNull
    @Size(min=3, max=15, message = "Cheese Name must be between 3 and 15 characters")
    private String cheeseName;

    @NotNull
    @Size (min=1, message = "Description field must not be empty")
    private String cheeseSize;

    @ManyToOne
    private Category category;

    @ManyToMany(mappedBy = "cheeses")
    private List<Menu> menus;

    public Cheese(String cheeseName, String cheeseSize) {
        this.cheeseName = cheeseName;
        this.cheeseSize = cheeseSize;

    }
    public Cheese() {}

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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
}}