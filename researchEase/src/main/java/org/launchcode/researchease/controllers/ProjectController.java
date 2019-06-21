package org.launchcode.researchease.controllers;


import org.launchcode.researchease.models.Project;
import org.launchcode.researchease.models.data.InstrumentDao;
import org.launchcode.researchease.models.data.ProjectDao;
import org.launchcode.researchease.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;


/**
* Created by Tracey Cannon, Liftoff 0519
 */


//Controller at Root Path
@EnableAutoConfiguration
@Configuration
@ComponentScan
@Controller
@RequestMapping(value = "project")
public class ProjectController {

    @Autowired
    //will eliminate the need to create a class to pass this dao into, it will instead be a dependency injection, created by the framework with along with an instance
    private ProjectDao projectDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private InstrumentDao instrumentDao;

    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("title", "Research Projects");
        model.addAttribute("projects", projectDao.findAll()); //returns an iterable, that loops over all the projects

        return "project/index";
    }

    //Request Path project/add
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model) {

        model.addAttribute("title", "Add Research Project");
        model.addAttribute(new Project());
        return "project/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(Model model, @ModelAttribute @Valid Project
            project, Errors errors) {

        if (errors.hasErrors()) {
            //model.addAttribute("title", "Add Research Project");
            return "project/add";
        } else

            projectDao.save(project);
        return "redirect:/project/view/" + project.getId();

        //return "redirect:/project";

    }
}