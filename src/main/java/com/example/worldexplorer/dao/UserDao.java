package com.example.worldexplorer.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.worldexplorer.entity.User;

public interface UserDao extends JpaRepository<User, Long>{
User findByEmailId(String email);
}