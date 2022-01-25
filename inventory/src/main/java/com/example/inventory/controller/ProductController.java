package com.example.inventory.controller;

import com.example.inventory.entity.Product;
import com.example.inventory.repository.CategoryRepository;
import com.example.inventory.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {
    @Autowired
    private ProductRepository repository;
    @Autowired
    CategoryRepository categoryRepository;
    @GetMapping("/products")
    public String showProduct(Model model){
        model.addAttribute("productList",repository.findAll());
        return "listproducts";
    }

    @PostMapping("/addproduct")
    public String addProduct(Product product){
        repository.save(product);
        return "redirect:/products";
    }
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") Integer id){
        repository.deleteById(id);
        return"redirect:/products";
    }
    @GetMapping("/edit/{id}")
    public String editProduct(@PathVariable("id") Integer id, Model model){
      model.addAttribute("product", repository.findById(id).get());
      model.addAttribute("categoryList",categoryRepository.findAll());
        return"editproduct";
    }
}
