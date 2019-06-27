package org.launchcode.researchease.controllers;


import org.apache.tomcat.jni.User;
import org.launchcode.researchease.models.data.ProjectDao;
import org.launchcode.researchease.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/")
public class UserController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private ProjectDao projectDao;


    //public UserController(UserDao userDao) {
    //this.userDao = userDao;

    //Request path /user
    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("title", "User");
        model.addAttribute("users", userDao.findAll());
        return "user/index";
    }
    // Request Path user/add
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("title", "Add User");
        model.addAttribute(new User());
        //model.addAttribute("projects", projectDao.findAll());
        return "user/add";
    }
    //Request path user/add
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(Model model, @ModelAttribute @Valid User user,
                      Errors errors){//@RequestParam int projectId-->) {

        if (errors.hasErrors()){
            model.addAttribute("title", "Add User");
            return "user/add";
        }
        //Project project = projectDao.findOne(projectId);
        //newUser.setProject(project);
        userDao.save(user);
        return "redirect:/user/view/" + user.toString();
    }

    @RequestMapping(value = "view/{id}", method = RequestMethod.GET)
    public String viewUser(Model model, @PathVariable int id){
        User user = (User) userDao.findOne(id);
        model.addAttribute("user", user);
        //model.addAttribute("userId", ((org.launchcode.researchease.models.user) user).getId());
        //model.addAttribute("projects", user.getProjects());
        return "user/view";
    }}


    // Request path user/remove
    //@RequestMapping(value = "remove", method = RequestMethod.GET)
    //public String displayRemoveUserForm(Model model) {
        //model.addAttribute("users", userDao.findAll());
        //model.addAttribute("title", "Remove User Account");
        //return "user/remove";
    //}

    // Request path: user/remove
   // @RequestMapping(value = "remove", method = RequestMethod.POST)
    //public String processRemoveUserForm(@RequestParam int[] userIds) {
        //for (int userId : userIds) {
           // userDao.delete(userId);
        //}
        //// Redirect to user/
        //return "redirect:";




