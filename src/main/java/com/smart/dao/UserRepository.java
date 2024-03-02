package com.smart.dao;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.smart.entities.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	

}
