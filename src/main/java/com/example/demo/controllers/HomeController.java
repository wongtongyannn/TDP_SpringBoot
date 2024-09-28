package com.example.demo.controllers; 

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


// the @Controller annotation tells spring boot that this is a controller tht contains route
// spring boot will automatically go through all the methods marked as routes and register them 
@Controller
public class HomeController {

    // when the user goes to the / URL on the server, call this method 
    @GetMapping("/")
    // tells spring boot this method returns a HTTP response
    @ResponseBody
    public String helloworld() {
        return "<h1>Hello world</h1>";
    }

    @GetMapping("/about-us")
    // if the route is not marked with @ResponseBody then by default we are using templates

    // the 'Model model' parameter is automatically passed to aboutUs when it is called by spring
    // this is known as the 'view model' and it also allows us to inject variables into our template

    // @ResponseBody
    public String aboutUs(Model model) {

        // get the current date and time 
        LocalDateTime currentDateTime = LocalDateTime.now();

        // the view model is automatically passed into the template 
        // and any attributes in it will be available 
        model.addAttribute("currentDateTime", currentDateTime);

        // we need to return the file path (without extension) to the template
        // relative to resources/templates
        return "about-us";

        // commented below after removing @ResponseBody
        // return "<h1>About Us</h1>";
    }

    @GetMapping("/contact-us")
    public String contactUs(){
        return "contact-us";
    }

}