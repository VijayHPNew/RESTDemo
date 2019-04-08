package com.loyaltyone.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loyaltyone.demo.model.User;

public interface UserRepository extends JpaRepository<User, String>{

}
