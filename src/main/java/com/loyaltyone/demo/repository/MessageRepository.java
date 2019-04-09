package com.loyaltyone.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loyaltyone.demo.model.Message;


public interface MessageRepository extends JpaRepository<Message, String>{
	
	List<Message> findAllByUserName(String userName);

}
