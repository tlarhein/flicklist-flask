package org.launchcode.cheesemvc.models;

import java.util.ArrayList;

/**
 *Created by LaunchCode
 */

public class CheeseData {
    static ArrayList<org.launchcode.cheesemvc.models.Cheese> cheeses = new ArrayList<>();
    //get all
    public static ArrayList<org.launchcode.cheesemvc.models.Cheese> getAll() {
        return cheeses;
    }
    //add
    public static void add(org.launchcode.cheesemvc.models.Cheese newCheese) {
        cheeses.add(newCheese);

    }
    //remove
    public static void remove(int id) {
        org.launchcode.cheesemvc.models.Cheese cheeseToRemove = getById(id);
        cheeses.remove(cheeseToRemove);
    }


    //getById
    public static org.launchcode.cheesemvc.models.Cheese getById(int id) {

        org.launchcode.cheesemvc.models.Cheese theCheese = null;
        for (org.launchcode.cheesemvc.models.Cheese candidateCheese : cheeses) {
            if (candidateCheese.getCheeseId() == id) {
                theCheese = candidateCheese;
            }
        }

        return theCheese;
    }

}
