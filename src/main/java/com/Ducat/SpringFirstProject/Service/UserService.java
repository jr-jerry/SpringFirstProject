package com.Ducat.SpringFirstProject.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.management.modelmbean.ModelMBean;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.Ducat.SpringFirstProject.DTO.ResponseDTO;
import com.Ducat.SpringFirstProject.DTO.SignUpDTO;
import com.Ducat.SpringFirstProject.Entity.UserEntity;
import com.Ducat.SpringFirstProject.Exception.DuplicateUserException;
import com.Ducat.SpringFirstProject.Repository.UserRepository;
/**
 * @Service--> Bean + Business Layer Class 
 */
@Service
public class UserService {
    private UserRepository userRepository;
    private ModelMapper modelMapper;
 
    public UserService(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }
    public List<ResponseDTO> getUsers()throws Exception{
        List<UserEntity> userList= userRepository.findByIsDeletedIsFalse();
        List<ResponseDTO> responseList=new ArrayList<>();

        responseList=userList.stream().map(user->modelMapper.map(user,ResponseDTO.class)).toList();
       return responseList.stream().map(response->{response.setSaved(true);return response;}).toList();
    }
    public void deleteUserService(int userId) throws Exception{
        userRepository.deleteById(userId);
    }
    public void saveUser(SignUpDTO signUpDTO){
        UserEntity userData=new UserEntity();

        userData=this.modelMapper.map(signUpDTO,UserEntity.class);
        userData.setDeleted(false);
        
        if(userRepository.existsByUsername(userData.getUsername())){
            throw new DuplicateUserException("User already exist with this username "+userData.getUsername());
        }
        userRepository.save(userData);
    }
    public boolean softDelete(int id) {
       Optional<UserEntity> optional= userRepository.findByIdAndIsDeletedIsFalse(id);
       if(optional.isEmpty()){
           return false;
       }
       UserEntity userEntity=optional.get();
       userEntity.setDeleted(true);
       userRepository.save(userEntity);
       return true;
    }
 
}
