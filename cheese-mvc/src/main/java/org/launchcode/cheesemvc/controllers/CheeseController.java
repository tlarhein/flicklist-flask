package org.launchcode.cheesemvc.controllers;

//**Assignment revised by Tracey Cannon//



import org.launchcode.cheesemvc.models.Cheese;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "cheese")
public class CheeseController {

    static ArrayList<Cheese> cheeses = new ArrayList<>();
    //HashMap<String, String>cheeses = new HashMap<>();

    //Request path /cheese
    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("cheeses", cheeses);
        model.addAttribute("title", "My Cheeses");

        return "cheese/index";
    }
    // Request Path Cheese/add
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddCheeseForm(Model model) {

        model.addAttribute("title", "Add Cheese");
        return "cheese/add";
    }
    //Request path cheese/add
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddCheeseForm(@RequestParam String cheeseName, @RequestParam String cheeseSize) {
        //cheeses.add(cheeseName); cheeses.add(cheeseSize);

        Cheese cheese = new Cheese(cheeseName, cheeseSize);
        cheeses.add(cheese);
        //cheeses.put("Cheddar", Small);
        // cheeses.put("Munster", Small);
        //cheeses.put("Gouda", Large);
        //cheeses.put("Goat", Medium;

        return "redirect:";
    }
        // Request path cheese/remove
        @RequestMapping(value = "remove", method = RequestMethod.GET)
        public String displayRemoveCheeseForm(Model model) {
            model.addAttribute("cheeses", cheeses);
            model.addAttribute("title", "Remove Cheese");
            return "cheese/remove";
        }

        // Request path: cheese/remove
        @RequestMapping(value = "remove", method = RequestMethod.POST)
        public String processRemoveCheeseForm(@RequestParam ArrayList<Integer> cheeseIds) {

            for (Integer cheeseId : cheeseIds) {
                for (Cheese cheese: cheeses){
                    if (cheese.getId() == cheeseId){
                        cheeses.remove(cheese);
                        break;
                    }
                }
            }

            // Redirect to cheese/
            return "redirect:";
        }
    }