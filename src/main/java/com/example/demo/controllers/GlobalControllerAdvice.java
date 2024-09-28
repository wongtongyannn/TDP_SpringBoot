package com.example.demo.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class GlobalControllerAdvice {

    @ModelAttribute("currentUser")
    public String getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            return null;
        }
        return authentication.getName();
    }

    @ModelAttribute("isAuthenticated")
    public boolean isAuthenticated() {
         // get the current authentication context (i.e, the current details of the logged in user)
         Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
         if (authentication.getName().equals("anonymousUser")) {
            return false;
         }
         return true;
 
     }
}


