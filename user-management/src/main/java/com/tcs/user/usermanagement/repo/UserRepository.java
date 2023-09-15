package com.tcs.user.usermanagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.user.usermanagement.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long>{
	
}
