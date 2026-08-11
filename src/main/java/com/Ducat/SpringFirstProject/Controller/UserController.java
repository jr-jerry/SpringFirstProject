package com.Ducat.SpringFirstProject.Controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Ducat.SpringFirstProject.Service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    public UserController(UserService userServiceBean){
        this.userService=userServiceBean;
    }
    /**
     * http://localhost:8080/user/get
     * @return
     */
    @GetMapping("/get")
    public String getEndpoint(){
        return "userController working";
    }
    /**
     * http://localhost:8080/user/signUp
     * @return
     */
    @PostMapping("/signUp")
    public Map<String,Object> signUpEndpoing(@RequestBody Map<String,String> userDataSent){
        return userService.saveUser(userDataSent);
    }
}
