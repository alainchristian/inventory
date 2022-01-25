package com.example.inventory.controller;

import com.example.inventory.entity.Role;
import com.example.inventory.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RoleController {
    @Autowired
    private RoleRepository roleRepository;
    @PostMapping("/addrole")
    public String addRole(Role role){
        roleRepository.save(role);
        return "redirect:/";
    }

}
