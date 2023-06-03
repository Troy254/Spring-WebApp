package com.springframework.spring6webapp.controllers;

import com.springframework.spring6webapp.services.AuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class AuthorController {
    private AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    public String getAuthors(Model model){
        model.addAttribute("authors",authorService.findAll());
        return "authors";
    }
}
