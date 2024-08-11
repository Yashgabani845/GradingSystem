package com.JT_project.GradingSystem.Repos;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.JT_project.GradingSystem.Models.Classroom;

public interface ClassroomRepo extends JpaRepository<Classroom,Long> {
           
	    
}
