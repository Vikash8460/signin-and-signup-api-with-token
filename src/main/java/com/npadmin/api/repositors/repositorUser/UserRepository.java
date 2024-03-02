package com.npadmin.api.repositors.repositorUser;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.npadmin.api.models.modelUser.User;



public interface UserRepository extends JpaRepository<User,Integer>{
	Optional<User> findByUserId(String userId);


}
