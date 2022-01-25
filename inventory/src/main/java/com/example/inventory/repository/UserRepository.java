package com.example.inventory.repository;

import com.example.inventory.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("Select u from User u where u.uName= :username")
    public User getUserByUserName(@Param("username")String username);
}
