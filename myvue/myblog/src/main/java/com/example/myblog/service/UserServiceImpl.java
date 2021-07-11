package com.example.myblog.service;

import com.example.myblog.dao.UserRepository;
import com.example.myblog.po.User;
import com.example.myblog.utils.md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements  UserService{
    @Autowired
   private UserRepository userRepository;
    @Override
    public User checck(String username, String password) {
      User user = userRepository.findByUsernameAndPassword(username,md5Util.code(password));
        return user;
    }
}
