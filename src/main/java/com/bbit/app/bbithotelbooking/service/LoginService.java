/*
 * package com.bbit.app.bbithotelbooking.service;
 * 
 * import javax.security.sasl.AuthenticationException;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Service;
 * 
 * import com.bbit.app.bbithotelbooking.dto.User; import
 * com.bbit.app.bbithotelbooking.repository.LoginRepository;
 * 
 * @Service public class LoginService {
 * 
 * @Autowired LoginRepository loginRepository;
 * 
 * public void registerNewUser(User user) { loginRepository.register(user); }
 * 
 * public void login(User user) throws AuthenticationException {
 * 
 * String userPassword =
 * loginRepository.checkUserLoginPassword(user.getEmail()); if
 * (!userPassword.equals(user.getPassword())) { throw new
 * AuthenticationException("Invalid Username or Password"); }
 * 
 * }
 * 
 * }
 */