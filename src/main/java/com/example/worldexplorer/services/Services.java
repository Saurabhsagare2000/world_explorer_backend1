package com.example.worldexplorer.services;

import java.util.List;

import com.example.worldexplorer.entity.User;



public interface Services {

public String registerUser(User user);

public List<User> getUsers();

public String loginUser(User user);

public User getUser(long parseLong);

}
