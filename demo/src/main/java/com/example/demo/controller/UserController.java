package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.request.UserRequestDTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import static org.springframework.web.bind.annotation.RequestMethod.POST;




@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping(value = "/")
    //@RequestMapping(method = POST,path = "/",headers = "apiKey=v1.0")
    public String addUser(@Valid @RequestBody UserRequestDTO userDTO){
       return "User added"; 
    }
    @PutMapping("/{userId}")
    public String updateUser(@PathVariable @Min(1) int userId,@Valid @RequestBody UserRequestDTO userDTO){
        System.out.println("Request update userId" + userId);
        return "User apdated";
    }
    @PatchMapping("/{userId}")
    public String changStatus(@PathVariable @Min(1) int userId,@RequestParam(required = false) boolean status){
        System.out.println("Request chang user status, userId" +userId);
        return "User status changed";
    }
    @DeleteMapping("/{userId}")
    public String deleteUser(@Min(1)@PathVariable int userId){
        System.out.println("Request delete UserId: " +userId);
        return "User deleted";
    }
    @GetMapping("/{userId}")
    public UserRequestDTO gerUser(@PathVariable @Min(1) int userId)
    {
        return new UserRequestDTO("Tan", "Dat", "phone", "email");
    }
    @GetMapping("/list")
    public List<UserRequestDTO> getAllUsers(
        @RequestParam(defaultValue = "0") int pageNo,
        @RequestParam(defaultValue = "10")int pageSize){

        System.out.println("Request get all user");
        return List.of(new UserRequestDTO(null, null, null, null),
        new UserRequestDTO(null, null, null, null));
    }
    
    
    
}
