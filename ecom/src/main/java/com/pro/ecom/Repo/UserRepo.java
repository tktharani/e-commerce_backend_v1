package com.pro.ecom.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pro.ecom.Model.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
