package com.example.worldexplorer.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.worldexplorer.dao.UserDao;
import com.example.worldexplorer.entity.User;

@Service
public class ServicesImplementation implements Services {

@Autowired
private UserDao userDao;
@Override
public String registerUser(User user) {

userDao.save(user);
return "Registration Successful and verification mail send ";
}
@Override
public List<User> getUsers() {

return userDao.findAll();
}
@Override
public String loginUser(User user) {

User u=userDao.findByEmailId(user.getEmailId());
if(u==null)
{
return "Unsuccessful";
}
else if(u.getEmailId().equals(user.getEmailId()) && u.getPassword().equals(user.getPassword()))
{
Long l1= u.getUserId();
String s=l1.toString();
return s;
}
return "Unsuccessful";
}
@Override
public User getUser(long parseLong) {
// TODO Auto-generated method stub
return userDao.findById(parseLong).get();
}





}

