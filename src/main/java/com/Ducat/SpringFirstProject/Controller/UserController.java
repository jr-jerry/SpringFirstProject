package com.Ducat.SpringFirstProject.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
    @GetMapping("/getAll")
    public List<UserEntity> dashBoardEndpoint() throws Exception{
        System.out.println("inside getAll "+userService.getUsers());
        return  userService.getUsers();
    }
    @PostMapping("/update")
    public UserEntity updateEndpoing(@RequestBody UserEntity userEntity) throws Exception{
        return userService.updateUserService(userEntity);
    }
    /**
     * http://localhost:8080/user/get
     * 
     */
    @GetMapping("/get")
    public String getEndpoint(){
        return "userController working";
    }
    /**
     * http://localhost:8080/user/signUp
     * 
     */
    @PostMapping("/signUp")
    public void signUpEndpoing(@RequestBody UserEntity userDataSent){
         ;
        System.out.println("data receive in controller layer "+userDataSent);
         userService.saveUser(userDataSent);
    }
}
