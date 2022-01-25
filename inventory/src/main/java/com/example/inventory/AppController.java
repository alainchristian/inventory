package com.example.inventory;

import com.example.inventory.entity.Product;
import com.example.inventory.entity.Role;
import com.example.inventory.entity.User;
import com.example.inventory.repository.CategoryRepository;
import com.example.inventory.repository.ProductRepository;
import com.example.inventory.repository.RoleRepository;
import org.hibernate.event.spi.PreInsertEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class AppController {
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    RoleRepository roleRepository;
    @GetMapping("/")
    public String showHome(Model model, Principal principal){
        model.addAttribute("product",new Product());
        model.addAttribute("categoryList",categoryRepository.findAll());
        model.addAttribute("role",new Role());
        model.addAttribute("roleList",roleRepository.findAll());
        model.addAttribute("user",new User());

        return "index";
    }
    @GetMapping("/login")
    public String openLogin(){
        return "login";
    }
}
