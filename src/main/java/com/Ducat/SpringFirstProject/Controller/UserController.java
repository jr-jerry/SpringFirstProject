package com.Ducat.SpringFirstProject.Controller;
import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.Ducat.SpringFirstProject.DTO.ResponseDTO;
import com.Ducat.SpringFirstProject.DTO.SignUpDTO;
import com.Ducat.SpringFirstProject.Service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    public UserController(UserService userServiceBean){
        this.userService=userServiceBean;
    }
    public boolean softDeleteEndpoint(@RequestParam int Id){
        userService.softDelete(Id);
        return true;
    }
    //update user controller --->UserUpdateDTO-->userEntity update 

    @PatchMapping("/soft-delete")
    public boolean softDelete(@RequestParam int Id){
        return userService.softDelete(Id);
    }
    @DeleteMapping("/delete")
    public void deleteEndpoint(@RequestParam int Id) throws Exception{
        userService.deleteUserService(Id);
    }
    @GetMapping("/getAll")
    public List<ResponseDTO> dashBoardEndpoint() throws Exception{
          return userService.getUsers();
    }
    @PostMapping("/signUp")
    public void signUpEndpoing(@Valid @RequestBody SignUpDTO signUpDTO){
         userService.saveUser(signUpDTO);
    }
}
