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
        return userRepository.getAll();
    }
    public void saveUser(UserEntity userData){
        System.out.println("Data receive int service layer "+userData );
        userRepository.save(userData);
    }
    public UserEntity updateUserService(UserEntity userEntity) throws Exception {
         if(userEntity.getId()<=0)
            throw new Exception("Invalid user id ");
        else if(userEntity.getPassword().trim().equals(""))
            throw new Exception("No password ");
        else if(userEntity.getUsername().trim().equals(""))
            throw new Exception("No username ");
        else{
            return userRepository.updateUserRepo(userEntity);
        }
    }
}
