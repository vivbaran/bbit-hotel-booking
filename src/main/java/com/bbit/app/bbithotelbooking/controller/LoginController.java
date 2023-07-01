/*
 * package com.bbit.app.bbithotelbooking.controller;
 * 
 * import javax.security.sasl.AuthenticationException;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.http.ResponseEntity; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.RequestBody; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * import com.bbit.app.bbithotelbooking.dto.User; import
 * com.bbit.app.bbithotelbooking.service.LoginService;
 * 
 * @RestController("/user") public class LoginController {
 * 
 * @Autowired LoginService loginService;
 * 
 * @PostMapping("/register") public ResponseEntity<String>
 * registerNewUser(@RequestBody User user) {
 * 
 * loginService.registerNewUser(user); return
 * ResponseEntity.ok("User registered Successfully -\n" + user.getFirstName() +
 * " " + user.getLastName());
 * 
 * }
 * 
 * @PostMapping("/login") public ResponseEntity<String> loginUser(@RequestBody
 * User user) throws AuthenticationException {
 * 
 * loginService.login(user); return
 * ResponseEntity.ok("User Logged In Successfully -\n" + user.getFirstName() +
 * " " + user.getLastName()); }
 * 
 * }
 */