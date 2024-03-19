package com.pro.ecom.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pro.ecom.Model.User;
import com.pro.ecom.Repo.UserRepo;
import com.pro.ecom.Service.UserService;

@Service

public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo userRepo;
	@Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }


}
