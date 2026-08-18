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
    public List<UserEntity> getUsers()throws Exception{
        return userRepository.findAll();
    }
    public void deleteUserService(int userId) throws Exception{
        userRepository.deleteById(userId);
    }
    public void saveUser(UserEntity userData){
        userRepository.save(userData);
    }
 
}
