package org.launchcode.researchease.controllers;

/*
 * Created by Tracey Cannon LiftOff 0519
 */

import org.launchcode.researchease.models.Project;
import org.launchcode.researchease.models.Instrument;
import org.launchcode.researchease.models.data.InstrumentDao;
import org.launchcode.researchease.models.data.ProjectDao;
import org.launchcode.researchease.models.forms.AddInstrumentForm;
import org.launchcode.researchease.models.forms.AddProjectForm;
import org.launchcode.researchease.models.forms.AddResponseForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "instrument")
public class InstrumentController {

    @Autowired //framework will create the class, the instance, and populate it
    private InstrumentDao instrumentDao;

    @Autowired
    private ProjectDao projectDao;


    //Request path /instrument
    @RequestMapping(value = "")
    public String index(Model model) {
    //findAll will be an iterable loop-over that will find and display all of the instruments (CrudRepository)
        model.addAttribute("title", "My Research Instruments");
        model.addAttribute("instruments", instrumentDao.findAll());
        return "instrument/index";
    }
    // Request Path Instrument/add
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("title", "Add Instrument");
        model.addAttribute(new Instrument());
        //model.addAttribute("projects", projectDao.findAll());
        return "instrument/add";
    }
    //Request path Instrument/add
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(Model model, @ModelAttribute @Valid Instrument instrument, Errors errors) {

        if (errors.hasErrors()) {
            //model.addAttribute("title", "Add Instrument");
            //model.addAttribute("projects", projectDao.findAll());
            return "instrument/add";
        }

        Instrument save = instrumentDao.save(instrument);
        return "redirect:/instrument/view/" + instrument.getId();
        }


    @RequestMapping(value = "view/{id}", method = RequestMethod.GET)
    public String viewInstrument(Model model, @PathVariable int id, AddResponseForm projects){
            //model.addAttribute("instrument", instrumentDao.findOne(id));
            Instrument instrument = instrumentDao.findOne(id);
            model.addAttribute("title", instrument.getName());
            model.addAttribute("instruments", projects.getInstruments());
            model.addAttribute("instrumentId", instrument.getId());
            //model.addAttribute("title", project.getName());
            //model.addAttribute("instrument", project.getInstrument());
            //model.addAttribute("id", project.getId());
            //code above replaced with code below
            //project project = projectDao.findOne(id);
            //model.addAttribute("project", project);

            //model.addAttribute("project", projectDao.findOne(id));
            return "instrument/view";

        }

    @RequestMapping(value = "add-item/{id}", method = RequestMethod.GET)
    public String addItem(Model model, @PathVariable int id){
        Instrument instrument = instrumentDao.findOne(id);
        AddInstrumentForm form = new AddInstrumentForm(instrument, projectDao.findAll());
        model.addAttribute("form", form);
        model.addAttribute("title", "Add a new instrument question: " + instrument.getName());
        return "instrument/add-item";

        }

    @RequestMapping(value = "add-item", method = RequestMethod.POST)
    //public String addItem(Model model, @ModelAttribute @Valid AddInstrumentItemForm form, Errors errors, @RequestParam int id){
    //public String addItem(Model model, @ModelAttribute @Valid AddInstrumentItemForm form, Errors errors){
    public String addItem(Model model, @ModelAttribute @Valid AddProjectForm form, Errors errors, @RequestParam int instrumentId, @RequestParam int projectId) {
        if (errors.hasErrors()){
                //model.addAttribute("form", form);
                //model.addAttribute("title", "Add item to menu: " + form.getMenuId());
        return "instrument/add-item";
            }

        Project aProject = projectDao.findOne(form.getProjectId());
        Instrument aInstrument = instrumentDao.findOne(form.getProjectId());
        aInstrument.addItem(aProject);
        instrumentDao.save(aInstrument);

        return "redirect:/instrument/view/" + aInstrument.getId();
        }
    }