package com.Ducat.SpringFirstProject.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.Ducat.SpringFirstProject.Entity.UserEntity;

@Component
public class UserRepository {
    private List<Map<String,String>> tempDb;
    public UserRepository(){
        this.tempDb=new ArrayList<>();
    }

    public void save(Map<String,String> userData){
        System.out.println("data receive in persistent layer "+userData );
        tempDb.add(userData);
        System.out.println(tempDb);
    }
    public List<Map<String,String>> getAll(){
        System.out.println("List size "+this.tempDb);

        return this.tempDb;
    }
}
