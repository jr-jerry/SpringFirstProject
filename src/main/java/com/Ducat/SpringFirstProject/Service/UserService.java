package com.Ducat.SpringFirstProject.Service;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

import com.Ducat.SpringFirstProject.Entity.UserEntity;
import com.Ducat.SpringFirstProject.Repository.UserRepository;
/**
 * @Service--> Bean + Business Layer Class 
 */
@Service
public class UserService {
    private UserRepository userRepository;
    
    public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
    }
    public List<Map<String,String>> getUsers()throws Exception{
        
        return userRepository.getAll();
    }
    public void saveUser(Map<String,String> userData){
        System.out.println("Data receive int service layer "+userData );
        //respository ko data send krna tha 
        userRepository.save(userData);

    }
}
