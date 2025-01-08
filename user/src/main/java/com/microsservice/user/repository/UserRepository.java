package com.microsservice.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microsservice.user.entity.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	User findByEmail(String email);
}
