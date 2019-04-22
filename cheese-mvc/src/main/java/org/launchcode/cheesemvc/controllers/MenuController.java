package org.launchcode.cheesemvc.controllers;

import org.launchcode.cheesemvc.models.Cheese;
import org.launchcode.cheesemvc.models.Menu;
import org.launchcode.cheesemvc.models.data.CheeseDao;
import org.launchcode.cheesemvc.models.data.MenuDao;
import org.launchcode.cheesemvc.models.forms.AddMenuItemForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;


/**
 * Created by LaunchCode, assignment revised by Tracey Cannon 0419
 */
@Controller
@RequestMapping(value = "menu")
public class MenuController {

    @Autowired
    private MenuDao menuDao;

    @Autowired
    private CheeseDao cheeseDao;

    @RequestMapping(value = "")
    public String index(Model model){
        model.addAttribute("title", "Menus");
        model.addAttribute("menus", menuDao.findAll());
        return "menu/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("title", "Add Menu");
        model.addAttribute(new Menu());
        //model.addAttribute("menus", menuDao.findAll());
        return "menu/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(Model model, @ModelAttribute @Valid Menu
            newMenu, Errors errors) {

        if (errors.hasErrors()){
            //model.addAttribute("title", "Add Menu");
            //model.addAttribute(new Error());
            //model.addAttribute("menus", menuDao.findAll());
            return "menu/add";
        }

        menuDao.save(newMenu);
        return "redirect:/menu/view/" + newMenu.getId();
    }

    @RequestMapping(value = "view/{id}", method = RequestMethod.GET)
    public String viewMenu(Model model, @PathVariable int id){
        //model.addAttribute("menu", menuDao.findOne(id));
        Menu menu = menuDao.findOne(id);
        model.addAttribute("menu", menu);
        //model.addAttribute("title", menu.getName());
        //model.addAttribute("cheeses", menu.getCheeses());
        //model.addAttribute("id", menu.getId());
        //code above replaced with code below
        //Menu menu = menuDao.findOne(id);
        //model.addAttribute("menu", menu);
        model.addAttribute("title", menu.getName());
        //model.addAttribute("menu", menuDao.findOne(id));
        return "menu/view";

    }

    @RequestMapping(value = "add-item/{id}", method = RequestMethod.GET)
    public String addItem(Model model, @PathVariable int id){
        Menu menu = menuDao.findOne(id);
        AddMenuItemForm addMenuItemForm = new AddMenuItemForm(menu, cheeseDao.findAll());
       ;
        //model.addAttribute("form", addMenuItemForm);
        //AddMenuItemForm newForm = new AddMenuItemForm(menuDao.findOne(id), cheeseDao.findAll());
        //model.addAttribute("title", "Add item to menu: " + menuDao.findOne(id).getName());
        model.addAttribute("form", addMenuItemForm);
        model.addAttribute("title", "Add item to menu: " + menu.getName());
        return "menu/add-item";

    }

    @RequestMapping(value = "add-item", method = RequestMethod.POST)
    //public String addItem(Model model, @ModelAttribute @Valid AddMenuItemForm form, Errors errors, @RequestParam int id){
    //public String addItem(Model model, @ModelAttribute @Valid AddMenuItemForm form, Errors errors){
    public String addItem(Model model, @ModelAttribute @Valid AddMenuItemForm addMenuItemForm, Errors errors, @RequestParam int menuId, @RequestParam int cheeseId) {
        if (errors.hasErrors()){
            //model.addAttribute("form", form);
            //model.addAttribute("title", "Add item to menu: " + form.getMenuId());
            return "menu/add-item";
        }

        Menu aMenu = menuDao.findOne(menuId);
        Cheese aCheese = cheeseDao.findOne(cheeseId);
        aMenu.addItem(aCheese);
        menuDao.save(aMenu);

        return "redirect:/menu/view/" + aMenu.getId();
    }
}
