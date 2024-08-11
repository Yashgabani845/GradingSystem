package com.JT_project.GradingSystem.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JT_project.GradingSystem.Models.Course;
import com.JT_project.GradingSystem.Repos.CourseRepo;
@Service
public class CourseService {

	 @Autowired 
	 CourseRepo courseRepo;
	 public Course getCourseById(Long course_id)
	 {
		 return courseRepo.getReferenceById(course_id);
	 }
}
