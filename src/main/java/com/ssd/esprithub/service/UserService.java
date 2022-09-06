//package com.ssd.esprithub.service;
//
//import com.ssd.esprithub.entity.User;
//import com.ssd.esprithub.registration.token.ConfirmationToken;
//import com.ssd.esprithub.registration.token.ConfirmationTokenService;
//import com.ssd.esprithub.repository.UserRepository;
//import lombok.AllArgsConstructor;
////import org.springframework.security.core.userdetails.UserDetails;
////import org.springframework.security.core.userdetails.UserDetailsService;
////import org.springframework.security.core.userdetails.UsernameNotFoundException;
////import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDateTime;
//import java.util.UUID;
//
//@Service
//@AllArgsConstructor
//public class UserService implements UserDetailsService {
//
//    private  final UserRepository userRepository;
////    private final BCryptPasswordEncoder bCryptPasswordEncoder;
////    private final ConfirmationTokenService confirmationTokenService;
////    @Override
////    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
////        return userRepository.findByEmail(email)
////                .orElseThrow(()-> new UsernameNotFoundException("User not found "));
////    }
//
//    
//    
//    // sign up
//    public String signUpUser (User user ){
//        boolean userExists =userRepository.findByEmail(user.getEmail())
//                .isPresent();
//         if  (userExists)
//         {
//             throw new IllegalStateException( " email already taken") ;
//         }
//         String encodedPassword=   bCryptPasswordEncoder.encode( user.getPassword());
//         user.setPassword(encodedPassword);
//         userRepository.save(user);
//         String token = UUID.randomUUID().toString();
//        // send confiramation token ;
//        ConfirmationToken confirmationToken = new ConfirmationToken(
//                token,
//                LocalDateTime.now(),
//                LocalDateTime.now().plusMinutes(60),
//                user
//
//        );
//        confirmationTokenService.saveConfirmationToken(confirmationToken);
//        return  token;
//    }
//    public int enableAppUser(String email) {
//        return userRepository.enableAppUser(email);
//    }
//}
package com.ssd.esprithub.service;

import javax.transaction.Transactional;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ssd.esprithub.repository.UserRepository;
import com.ssd.esprithub.entity.User;



@Service
public class UserService {
	@Autowired
	private UserRepository repository;
	public User findByUserName(String username) {
		return repository.findByUsername(username);
	}
	
	
	public User addUser(User user) {
		PasswordEncoder encoder=new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		
		return repository.save(user);
	}
	public boolean verrifymail(String email) {
		User user=repository.findByEmail(email);
		return user != null;
		
	}
	
	public boolean verrifyUsername(String username) {
		User user=repository.findByUsername(username);
		return user != null;
	}

}