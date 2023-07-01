package com.bbit.app.bbithotelbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bbit.app.bbithotelbooking.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

	public boolean existsByEmail(String email);

	public UserEntity findByEmail(String email);
	
	public void deleteByEmail(String email);

}
