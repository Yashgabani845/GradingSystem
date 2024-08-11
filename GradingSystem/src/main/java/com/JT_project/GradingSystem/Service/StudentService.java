package com.JT_project.GradingSystem.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JT_project.GradingSystem.Models.Student;
import com.JT_project.GradingSystem.Repos.StudentRepo;

@Service
public class StudentService {
       @Autowired 
       StudentRepo studentRepo;
       
       public Student  add_studentDetails(Student s)
       {
    	   return studentRepo.save(s);
       }
       public Student update_studentDetails(Long student_id,Student s)
       {
    	   Student existingStudent= studentRepo.getReferenceById(student_id);
    	   s.setUser(existingStudent.getUser());
    	   s.setClassroom(existingStudent.getClassroom());
    	   s.setEnrolled_courses(existingStudent.getEnrolled_courses());
    	   s.setGrades(existingStudent.getGrades());
    	   s.setStudent_id(student_id);
    	   existingStudent = s;
    	   System.out.println("existing student "+existingStudent.getStudent_id());
    	  
    	   return studentRepo.save(existingStudent);
       }
       public Student getStudentById(Long student_id)
       {
    	   return studentRepo.getReferenceById(student_id);
       }
       public String Delete(Long student_id)
       {
    	   Student existingStudent= studentRepo.getReferenceById(student_id);
    	   if(existingStudent!=null)
    	   {
    		   studentRepo.deleteById(student_id);
    		   return "deleted student with id + " + student_id;
    	   }
    	    return "no student Found with this id";
    	    
       }
       public List<String> analysis(Long class_id)
       {
    	   return studentRepo.topper_list(class_id);
       }
       public List<String> analysis_course(Long course_id)
       {
    	   return studentRepo.topper_list_course(course_id);
       }
}
