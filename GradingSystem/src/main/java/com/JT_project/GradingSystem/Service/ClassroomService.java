package com.JT_project.GradingSystem.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JT_project.GradingSystem.Models.Classroom;
import com.JT_project.GradingSystem.Models.Student;
import com.JT_project.GradingSystem.Repos.ClassroomRepo;
import com.JT_project.GradingSystem.utils.Result;
import java.util.List;
@Service
public class ClassroomService {
     @Autowired 
     ClassroomRepo classroomRepo;
     
     public Classroom getClassById(Long class_id)
     {
    	 return classroomRepo.getReferenceById(class_id);
     }
 
         
     }

