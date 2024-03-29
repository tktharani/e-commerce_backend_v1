package com.pro.ecom.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pro.ecom.Model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
	@Query(value =" SELECT * FROM USERS WHERE  username = :username AND password = :password",nativeQuery = true)
	User findBy(String username,String password);



}
