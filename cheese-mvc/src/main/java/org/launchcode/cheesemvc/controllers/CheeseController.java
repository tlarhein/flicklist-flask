package org.launchcode.cheesemvc.controllers;

//**CREATED BY LAUNCH CODE -- Assignment revised by Tracey Cannon//

import org.launchcode.cheesemvc.models.Category;
import org.launchcode.cheesemvc.models.Cheese;
import org.launchcode.cheesemvc.models.data.CategoryDao;
import org.launchcode.cheesemvc.models.data.CheeseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("cheese")
public class CheeseController {

    @Autowired
    private CheeseDao cheeseDao;

    @Autowired
    private CategoryDao categoryDao;


    //Request path /cheese
    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("cheeses", cheeseDao.findAll());
        model.addAttribute("title", "My Cheeses");

        return "cheese/index";
    }
    // Request Path Cheese/add
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddCheeseForm(Model model) {
        model.addAttribute("title", "Add Cheese");
        model.addAttribute(new Cheese());
        model.addAttribute("categories", categoryDao.findAll());
        return "cheese/add";
    }
    //Request path cheese/add
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddCheeseForm(@ModelAttribute @Valid Cheese newCheese,
                                       Errors errors, @RequestParam int categoryId, Model model) {

        if (errors.hasErrors()){
            model.addAttribute("title", "Add Cheese");
            //model.addAttribute("categories", categoryDao.findAll());
            return "cheese/add";
        }
        Category cat = categoryDao.findOne(categoryId);
        newCheese.setCategory(cat);
        cheeseDao.save(newCheese);
        return "redirect:";
    }
        // Request path cheese/remove
        @RequestMapping(value = "remove", method = RequestMethod.GET)
        public String displayRemoveCheeseForm(Model model) {
            model.addAttribute("cheeses", cheeseDao.findAll());
            model.addAttribute("title", "Remove Cheese");
            return "cheese/remove";
        }

        // Request path: cheese/remove
        @RequestMapping(value = "remove", method = RequestMethod.POST)
        public String processRemoveCheeseForm(@RequestParam int[] cheeseIds) {

            for (int cheeseId : cheeseIds) {
                cheeseDao.delete(cheeseId);

            }
            // Redirect to cheese/
            return "redirect:";
        }

    @RequestMapping(value = "category/{categoryId}", method = RequestMethod.GET)
    public String category(Model model, @RequestParam int categoryId) {
        model.addAttribute("cheeses", categoryDao.findOne(categoryId).getCheeses());
        model.addAttribute("title", "My Cheeses");
        return "cheese/index";

    }


    }


