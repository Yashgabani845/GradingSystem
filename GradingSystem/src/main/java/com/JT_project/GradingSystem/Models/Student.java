package com.JT_project.GradingSystem.Models;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name="students")
public class Student {
     @Id
     @GeneratedValue(strategy=GenerationType.IDENTITY)
     private Long student_id;
     
     @OneToOne(cascade=CascadeType.ALL)
     @JoinColumn(name="user_id")
	 private User user;
     
     @Column(name="first_name")
	 private String first_name;
     
     @Column(name="second_name")
	 private String last_name;
     
     @Column(name="email")
	 private String email;
     
     @Column(name="dob")
	 private Date date_of_birth;
     
     @ManyToMany(cascade=CascadeType.ALL)
     @JoinTable(name = "enroll",
     joinColumns = @JoinColumn(name =
     "student_id",referencedColumnName = "student_id"),
     inverseJoinColumns = @JoinColumn(name =
     "course_id", referencedColumnName =
     "course_id"))
	 private List<Course> enrolled_courses;
     
     
     @OneToMany(mappedBy="belong_to_student",cascade=CascadeType.ALL)
	 private List<Grade> grades;
     
     
     @ManyToOne
     @JoinColumn(name="class_id")
	 private Classroom classroom;
	 
	 public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDate_of_birth() {
		return date_of_birth;
	}
	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}
	public List<Course> getEnrolled_courses() {
		return enrolled_courses;
	}
	public void setEnrolled_courses(List<Course> enrolled_courses) {
		this.enrolled_courses = enrolled_courses;
	}
	public List<Grade> getGrades() {
		return grades;
	}
	public void setGrades(List<Grade> grades) {
		this.grades = grades;
	}
	public Classroom getClassroom() {
		return classroom;
	}
	public void setClassroom(Classroom classroom) {
		this.classroom = classroom;
	}
	public void setStudent_id(Long student_id)
	{
		this.student_id=student_id;
	}
	public Long getStudent_id()
	{
		return student_id;
	}
	 
}
