package com.JT_project.GradingSystem.Controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import com.JT_project.GradingSystem.Models.*;
import com.JT_project.GradingSystem.Service.ClassroomService;
import com.JT_project.GradingSystem.Service.CourseService;
import com.JT_project.GradingSystem.Service.GradesService;
import com.JT_project.GradingSystem.Service.ProfessorService;
import com.JT_project.GradingSystem.Service.RolesService;
import com.JT_project.GradingSystem.Service.StudentService;
import com.JT_project.GradingSystem.Service.UserService;
import com.JT_project.GradingSystem.utils.Result;
@RestController
@RequestMapping("/api")
public class GradeSystemControl {
	
	@Autowired
	UserService userService;
	
	@Autowired
	RolesService rolesService;
	
	@Autowired
	ProfessorService professorService;
	
	@Autowired 
	StudentService studentService;
	
	@Autowired
	ClassroomService classroomService;
	
	@Autowired
	CourseService courseService;
	
	@Autowired 
	GradesService gradeService;
// endpoint acceseable by only prof
	
	
    @PostMapping("/add_profDetails/{user_id}")
	public Professor add_profDetails(@PathVariable Long user_id,@RequestBody Professor prof)
	{
    	Professor p=prof;
    	User u = userService.getUserById(user_id);
    	p.setUser(u);
        p.setJoined_date(new java.sql.Date(System.currentTimeMillis()));
    	return professorService.add_profDetails(p);
	}
	@PutMapping("/update_profDetails/{prof_id}")
	public Professor update_profDetails(@PathVariable Long prof_id,@RequestBody Professor prof)
	{
		return professorService.update_profDetails(prof_id,prof);
	}

	//student related 
	@DeleteMapping("/delete_student/{student_id}")
	public String delete_student(@PathVariable Long student_id)
	{
	    return studentService.Delete(student_id);
	}
	
	@GetMapping("/classroom_students/{class_id}")
	public List<String> classroom_students(@PathVariable Long class_id)
	{
		Classroom c = classroomService.getClassById(class_id);
	     List<String> result =  new ArrayList<>();
	     String row=" ";
	     for (Student s : c.getStudents_in_class())
	        {
	    	    row = s.getFirst_name()+ " "+ s.getLast_name();
	        	result.add(row);
	        }
	     return result;
	}
	
	@GetMapping("/course_studets/{course_id}")
	public List<String> course_students(@PathVariable Long course_id)
	{
		Course c = courseService.getCourseById(course_id);
		List<String> result =  new ArrayList<>();
	     String row=" ";
	     for (Student s : c.getEnrolled_students())
	        {
	    	    row = s.getFirst_name()+ " "+ s.getLast_name();
	        	result.add(row);
	        }
	     return result;
	}
	
	//Grade related
	@PostMapping("/add_studentGrade/{belong_to_id}/{course_id}")
	public String add_studentGrade(@PathVariable Long belong_to_id,@PathVariable Long course_id,@RequestBody Grade grade)
	{
		Student s = studentService.getStudentById(belong_to_id);
		Course c= courseService.getCourseById(course_id);
		grade.setBelong_to_student(s);
		grade.setFor_course(c);
		gradeService.add_grade(grade);
		if(s!=null && c!=null)
		{
			return "grade successfully added";
		}
		return "something went wrong";
		
	}
	
	@PutMapping("/update_studentGrade/{grade_id}")
	public String update_studentGrade(@PathVariable Long grade_id,@RequestBody Grade grade)
	{
		return gradeService.update_grade(grade_id,grade);
	}
//	
	@DeleteMapping("/delete_studentGrade/{grade_id}")
	public String delete_studentGrade(@PathVariable Long grade_id)
	{
        return gradeService.delete(grade_id);
	}
	
	//analysis by classroom and course 
	@GetMapping("/analysis_classroom/{class_id}")
	public List<String> analysis_classroom(@PathVariable Long class_id)
	{
		return studentService.analysis(class_id);
	}
	
	@GetMapping("/analysis_course/{course_id}")
	public List<String> analysis_course(@PathVariable Long course_id)
	{
		return studentService.analysis_course(course_id);
	}
	
    
    
    
    
    

//	//endpoints for student 
	@GetMapping("/show_grades/{student_id}")
	public List<String> show_grades(@PathVariable Long student_id)
	{
		System.out.println("getting grades of the student who has student id "+ student_id);
		Student s =studentService.getStudentById(student_id);
		System.out.println("got the student with id : " + s.getFirst_name() + " " + s.getLast_name());
        List<String> result =  new ArrayList<>();
        for (Grade grade : s.getGrades())
        {
        	result.add(grade.getFor_course().getName()+":"+grade.getGrade_letter());
        }
        return result;
		
	}
	
	@GetMapping("/show_grade/{course_name}/{student_id}")
	public String show_courseGrade(@PathVariable String course_name,@PathVariable Long student_id)
	{
		System.out.println("getting grades of the student who has student id "+ student_id);
		Student s =studentService.getStudentById(student_id);
		System.out.println("got the student with id : " + s.getFirst_name() + " " + s.getLast_name());
        String result="not found course in enrolled list";
        for (Grade grade : s.getGrades())
        {
        	System.out.println(grade.getFor_course().getName());
        	if(grade.getFor_course().getName().equals(course_name))
        	{
        	     System.out.println(grade.getFor_course().getName());
        	     result=grade.getGrade_letter();
        	     
        	}
        }
        return result;
	}
	
	@PostMapping("/add_studentDetails/{user_id}")
	public Student add_studentDetails(@PathVariable Long user_id,@RequestBody Student student)
	{
    	Student s=student;
    	User u = userService.getUserById(user_id);
    	s.setUser(u);
        s.setDate_of_birth(new java.sql.Date(System.currentTimeMillis()));
    	return studentService.add_studentDetails(s);
	}
	
	@PutMapping("/update_studentDetails/{student_id}")
    public Student update_studentDetails(@PathVariable Long student_id,@RequestBody Student s)
    {
		return studentService.update_studentDetails(student_id, s);
    }
	
	
	//for every user 
	@PostMapping("/add_studentUser")
	public User add_studentUser(@RequestBody User user)
	{
		User u = userService.add_user(user);
		roles userRole = new roles();
		userRole.setUser_id(u);
		userRole.setRole("ROLE_STUDENT");
		rolesService.add_role(userRole);
		return u;
	}
	@PostMapping("/add_professorUser")
	public User add_professorUser(@RequestBody User user)
	{
		User u = userService.add_user(user);
		roles userRole = new roles();
		userRole.setUser_id(u);
		userRole.setRole("ROLE_PROF");
		rolesService.add_role(userRole);
		return u;
	}
	
	
}
