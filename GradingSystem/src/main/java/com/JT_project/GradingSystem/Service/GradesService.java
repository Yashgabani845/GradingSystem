package com.JT_project.GradingSystem.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JT_project.GradingSystem.Models.Grade;
import com.JT_project.GradingSystem.Repos.GradeRepo;

@Service
public class GradesService {
         
	       @Autowired 
	       GradeRepo gradeRepo;
	       
	       public Grade add_grade(Grade g)
	       {
	    	   return gradeRepo.save(g);
	       }
	       public String update_grade(Long grade_id,Grade g)
	       {
	    	   Grade existingGrade = gradeRepo.getReferenceById(grade_id);
	    	   g.setBelong_to_student(existingGrade.getBelong_to_student());
	    	   g.setFor_course(existingGrade.getFor_course());
	    	   g.setGrade_id(grade_id);
	    	   
	    	  
	    		   gradeRepo.save(g);
	    		   return "grade updated";
	       }
	       public String delete(Long grade_id)
	       {
	    	   if(gradeRepo.getReferenceById(grade_id)!=null)
	    	   {
	    		   gradeRepo.deleteById(grade_id);
	    		   return "deleted succesfully";
	    	   }
	    	   return "something went wrong";
	       }
}
