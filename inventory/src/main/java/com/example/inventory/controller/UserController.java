package com.example.inventory.controller;

import com.example.inventory.entity.Role;
import com.example.inventory.entity.User;
import com.example.inventory.repository.RoleRepository;
import com.example.inventory.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @PostMapping("/adduser")
    public String addUser(User user){
        Role role = roleRepository.findRoleByName("User");
        BCryptPasswordEncoder encodedPass=new BCryptPasswordEncoder();
        user.addRole(role);
        user.setUPass(encodedPass.encode(user.getUPass()));
        userRepository.save(user);
        return "redirect:/showusers";
    }
    @PostMapping("/selfregistration")
    public String addUser1(User user1){
        Role role = roleRepository.findRoleByName("User");
        BCryptPasswordEncoder encodedPass=new BCryptPasswordEncoder();
        user1.addRole(role);
        user1.setUPass(encodedPass.encode(user1.getUPass()));
        userRepository.save(user1);
        return "redirect:/";
    }
    @GetMapping("/showusers")
    public String showUser(Model model){
        model.addAttribute("userList",userRepository.findAll());
        return "listusers";
    }
}
