package com.Ducat.SpringFirstProject.Entity;


public class UserEntity {
    private String username;

    public UserEntity(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "UserEntity [username=" + username + "]";
    }
    
}
