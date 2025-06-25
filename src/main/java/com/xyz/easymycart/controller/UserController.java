package com.xyz.easymycart.controller;

import com.xyz.easymycart.model.Session;
import com.xyz.easymycart.model.User;
import com.xyz.easymycart.request.LoginRequestDto;
import com.xyz.easymycart.response.LoginResponseDto;
import com.xyz.easymycart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
  private ProductService productService;

  @Autowired
  public UserController(ProductService productService) {
    this.productService = productService;
  }

  @PostMapping("api/signup")
  public User addUser(@RequestBody User user) {
    User user1 = productService.addUser(user);
    return user;
  }

  //    @PostMapping("/login")
  //    public User login(@RequestBody User user, HttpSession session ){
  //        User user1 = productService.getUserByUserName(user);
  //
  //        if (user1 != null) {
  //            session.setAttribute("user_id", user1.getId());
  //            System.out.println("User ID set in session: " + user1.getId());
  //            return user1;
  //        } else {
  //            throw new RuntimeException("Invalid user credentials");
  //        }
  //    }

  @PostMapping("/api/login")
  public LoginResponseDto login(@RequestBody LoginRequestDto loginRequestDto) throws Exception {
    return productService.login(loginRequestDto);
  }

  @PostMapping("/api/logout")
  public ResponseEntity<Void> logout(@RequestHeader("sessionId") String sessionId) {
    productService.logout(sessionId);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @PostMapping("/api/validate")
  public ResponseEntity<?> validate(@RequestHeader("sessionId") String sessionId) {
    try {
      Session session = productService.getValidSession(sessionId);
      return ResponseEntity.ok().build();
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid or expired session");
    }
  }

}
