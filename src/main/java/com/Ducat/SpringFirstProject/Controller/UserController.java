package com.Ducat.SpringFirstProject.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Ducat.SpringFirstProject.Entity.UserEntity;
import com.Ducat.SpringFirstProject.Service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    public UserController(UserService userServiceBean){
        this.userService=userServiceBean;
    }
    @DeleteMapping("/delete")
    public void deleteEndpoint(@RequestParam int Id) throws Exception{
        userService.deleteUserService(Id);
    }
    @GetMapping("/getAll")
    public List<UserEntity> dashBoardEndpoint() throws Exception{
        return  userService.getUsers();
    }
    @PostMapping("/signUp")
    public void signUpEndpoing(@RequestBody UserEntity userDataSent){
 
         userService.saveUser(userDataSent);
    }
}
