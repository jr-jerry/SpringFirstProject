package com.Ducat.SpringFirstProject.Service;
import java.util.Map;
import org.springframework.stereotype.Service;
/**
 * @Service--> Bean + Business Layer Class 
 */
@Service
public class UserService {

    public Map<String,Object> saveUser(Map<String,String> userData){
        //respository ko data send krna tha 
        return Map.of("data",Map.of("controllerData",userData));
    }
}
