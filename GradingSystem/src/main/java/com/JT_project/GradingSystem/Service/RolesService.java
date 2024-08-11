package com.JT_project.GradingSystem.Service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JT_project.GradingSystem.Repos.*;
import com.JT_project.GradingSystem.Models.*;
@Service
public class RolesService {
	@Autowired
	rolesRepo roleRepo;
	
	public roles add_role(roles role)
	{
		return roleRepo.save(role);
	}
}
