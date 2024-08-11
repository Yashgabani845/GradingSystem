package com.JT_project.GradingSystem.Service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JT_project.GradingSystem.Repos.UserRepo;
import com.JT_project.GradingSystem.Models.User;
@Service
public class UserService {
	 @Autowired
	 UserRepo userRepo;
	 
	 //create the user
	 public User add_user(User user)
	 {
		 return userRepo.save(user);
	 }
	 
	 public User getUserById(Long user_id)
	 {
	      User u=userRepo.getReferenceById(user_id);
          return u;
	 }
}
	 

