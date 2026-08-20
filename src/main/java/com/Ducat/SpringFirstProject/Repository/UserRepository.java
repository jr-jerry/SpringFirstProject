package com.Ducat.SpringFirstProject.Repository;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.Ducat.SpringFirstProject.Entity.UserEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Integer> {


    Optional<UserEntity> findByIdAndIsDeletedIsFalse(int id);

    List<UserEntity> findByIsDeletedIsFalse();

    boolean existsByUsername(String username);
}
