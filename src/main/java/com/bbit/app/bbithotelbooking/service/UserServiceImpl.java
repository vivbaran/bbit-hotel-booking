package com.bbit.app.bbithotelbooking.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.bbit.app.bbithotelbooking.dto.User;
import com.bbit.app.bbithotelbooking.entity.UserEntity;
import com.bbit.app.bbithotelbooking.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public List<User> getAllUsers() {
		List<UserEntity> userEntities = userRepository.findAll();
		List<User> users = new ArrayList<>();
		for (UserEntity userEntity : userEntities) {
			User userDto = new User(userEntity.getId(), userEntity.getEmail(), userEntity.getPassword(),userEntity.getFirstName(),
					userEntity.getLastName(), userEntity.getMobileNo(), userEntity.getRole());
			users.add(userDto);
		}
		return users;
	}

	@Override
	public User getUserByEmail(String email) throws Exception {
		UserEntity userEntity = userRepository.findByEmail(email);
		if (userEntity != null) {
			return new User(userEntity.getId(), userEntity.getEmail(), userEntity.getPassword(), userEntity.getFirstName(),
					userEntity.getLastName(), userEntity.getMobileNo(), userEntity.getRole());
		} else {
			throw new Exception("User Not Found !!!");
		}
	}

	@Override
	public User createUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		UserEntity userEntity = new UserEntity(user.getEmail(), user.getPassword(), user.getFirstName(),
				user.getLastName(), user.getMobileNo(), user.getRole());

		userEntity = userRepository.saveAndFlush(userEntity);
		user.setId(userEntity.getId());
		return user;
	}

	@Override
	public boolean checkEmail(String email) {
		return userRepository.existsByEmail(email);
	}

	@Transactional
	@Modifying
	@Override
	public void updateUser(String email, User user) {
		UserEntity existingUser = userRepository.findByEmail(email);
		existingUser.setFirstName(user.getFirstName());
		existingUser.setLastName(user.getLastName());
		existingUser.setMobileNo(user.getMobileNo());
		existingUser.setRole(user.getRole());

		// save updated user object
		userRepository.saveAndFlush(existingUser);
	}

	@Transactional
	@Modifying
	@Override
	public void deleteUser(String email) {
		userRepository.deleteByEmail(email);
		
	}

}
