package com.picpaydesafio.controllers;

import com.picpaydesafio.domain.user.User;
import com.picpaydesafio.dtos.UserDTO;
import com.picpaydesafio.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
   @Autowired
   private UserService userService;

   @PostMapping
   public final ResponseEntity<User> createUser(@RequestBody UserDTO user) {
      User newUser = this.userService.createUser(user);
      return new ResponseEntity<>(newUser, HttpStatus.CREATED);
   }

   @GetMapping
   public final ResponseEntity<List<User>> getAllUsers() {
      List<User> users = this.userService.getAllUsers();
      return new ResponseEntity<>(users, HttpStatus.OK);
   }

}
