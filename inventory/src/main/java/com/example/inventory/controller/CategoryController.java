package com.example.inventory.controller;

import com.example.inventory.entity.Category;
import com.example.inventory.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.awt.*;

@Controller
public class CategoryController {
    @Autowired
    private CategoryRepository repository;
    @GetMapping("/catlist")
    public String viewCategories(Model model){
        model.addAttribute("categoryList",repository.findAll());
       return "catlist";
    }
    @PostMapping("/catadd")
    public String addCat(Category category, Model model){
        model.addAttribute("category",new Category());
        repository.save(category);
        return "redirect:/catlist";

    }
}
