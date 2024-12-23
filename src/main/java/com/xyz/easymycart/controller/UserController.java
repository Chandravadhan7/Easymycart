package com.xyz.easymycart.controller;

import com.xyz.easymycart.model.User;
import com.xyz.easymycart.service.ProductService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("user")
@CrossOrigin(origins = "http://localhost:3000",allowCredentials = "true")
public class UserController {
    private ProductService productService;

    @Autowired
    public UserController(ProductService productService){
        this.productService = productService;
    }

    @PostMapping("/signup")
    public User addUser(@RequestBody User user){
        User user1 = productService.addUser(user);
        return user;
    }

    @PostMapping("/login")
    public User login(@RequestBody User user, HttpSession session ){
        User user1 = productService.getUserByUserName(user);

        if (user1 != null) {
            session.setAttribute("user_id", user1.getId());
            System.out.println("User ID set in session: " + user1.getId());
            return user1;
        } else {
            throw new RuntimeException("Invalid user credentials");
        }
    }
}
