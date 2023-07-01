package com.bbit.app.bbithotelbooking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bbit.app.bbithotelbooking.config.CustomUserDetails;
import com.bbit.app.bbithotelbooking.dto.User;
import com.bbit.app.bbithotelbooking.entity.UserEntity;
import com.bbit.app.bbithotelbooking.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String email) {

		UserEntity userEntity = userRepo.findByEmail(email);

		if (userEntity != null) {
			return new CustomUserDetails(new User(userEntity.getId(), userEntity.getEmail(), userEntity.getPassword(), userEntity.getFirstName(),
					userEntity.getLastName(), userEntity.getMobileNo(), userEntity.getRole()));
		}

		throw new UsernameNotFoundException("user not available");
	}

}
