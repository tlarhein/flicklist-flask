package org.launchcode.cheesemvc.controllers;

//**CREATED BY LAUNCH CODE -- Assignment revised by Tracey Cannon//


import org.launchcode.cheesemvc.models.Cheese;
import org.launchcode.cheesemvc.models.CheeseData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
@RequestMapping("cheese")
public class CheeseController {


    //HashMap<String, String>cheeses = new HashMap<>();

    //Request path /cheese
    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("cheeses", CheeseData.getAll());
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
    public String processAddCheeseForm(@ModelAttribute Cheese newCheese) {
        //cheeses.add(cheeseName); cheeses.add(cheeseSize);
        CheeseData.add(newCheese);
        //cheeses.put("Cheddar", Small);
        // cheeses.put("Munster", Small);
        //cheeses.put("Gouda", Large);
        //cheeses.put("Goat", Medium;
        return "redirect:";
    }
        // Request path cheese/remove
        @RequestMapping(value = "remove", method = RequestMethod.GET)
        public String displayRemoveCheeseForm(Model model) {
            model.addAttribute("cheeses", CheeseData.getAll());
            model.addAttribute("title", "Remove Cheese");
            return "cheese/remove";
        }

        // Request path: cheese/remove
        @RequestMapping(value = "remove", method = RequestMethod.POST)
        public String processRemoveCheeseForm(@RequestParam int[] cheeseIds) {

            for (int cheeseId : cheeseIds) {
                CheeseData.remove(cheeseId);

                    }


            // Redirect to cheese/
            return "redirect:";
        }
    }