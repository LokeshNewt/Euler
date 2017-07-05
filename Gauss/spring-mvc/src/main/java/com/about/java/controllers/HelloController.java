package com.about.java.controllers;

import com.about.java.emp.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by neerbans on 10/30/2015.
 */

@Controller
public class HelloController {

    @Autowired
    EmployeeRepositary employeeRepositary;

    @Autowired
    UserRepositary userRepositary;

    @RequestMapping(value = "/")
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView("index/index");

        String msg = "congrats neeraj";

        mav.addObject("msg", msg);
        return mav;
    }

    @RequestMapping("/empform")
    public ModelAndView showform() {
        return new ModelAndView("index/empform", "command", new Employee());
    }

    @RequestMapping("/signup")
    public ModelAndView showSignUpPage() {
        return new ModelAndView("index/signup", "command", new User());
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("emp") Employee employee) {
        employeeRepositary.save(employee);
        return new ModelAndView("index/empform", "command", new Employee());
    }

    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public ModelAndView saveUser(HttpServletRequest request) {
        User user = new User();
        user.setEmailId(request.getParameter("email"));
        user.setPassword(request.getParameter("psw"));
        userRepositary.save(user);
        return new ModelAndView("index/login", "command", new User());
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null) {
            model.addAttribute("error", "Your username and password is invalid");
        }
        if (logout != null) {
            model.addAttribute("message", "You have been logged out successfully");
        }
        return "login";
    }

}
