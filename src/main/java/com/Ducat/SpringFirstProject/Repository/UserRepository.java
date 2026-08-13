package com.Ducat.SpringFirstProject.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.Ducat.SpringFirstProject.Entity.UserEntity;

@Component
public class UserRepository {
    private List<UserEntity> tempDb;
    public UserRepository(){
        this.tempDb=new ArrayList<>();
    }
    public void save(UserEntity userData){
        if(tempDb.indexOf(userData)==-1){
             tempDb.add(userData);
        }
        else{
            int indexOfsavedData=tempDb.indexOf(userData);
            tempDb.set(indexOfsavedData,userData);
        }
    }
    public List<UserEntity> getAll(){
        System.out.println("List size "+this.tempDb);
        return this.tempDb;
    }
    public UserEntity updateUserRepo(UserEntity userEntity) throws Exception {
       for(UserEntity savedUser:tempDb){
        if(savedUser.getId()==userEntity.getId()){
            savedUser.setPassword(userEntity.getPassword());
            savedUser.setUsername(userEntity.getUsername());
            save(savedUser);

            return savedUser;
        }
       }
       throw new Exception("Usern not found ");
    }
}
