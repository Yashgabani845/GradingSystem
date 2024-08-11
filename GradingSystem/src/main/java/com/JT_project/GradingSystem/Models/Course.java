package com.JT_project.GradingSystem.Models;
import java.util.List;

import jakarta.persistence.*;
@Entity
@Table(name="Course")
public class Course {
		@Id
	    @GeneratedValue(strategy=GenerationType.IDENTITY)
        private Long course_id;
	    
	    @Column(name="name")
        private String name;
	    
	    @Column(name="description")
        private String description;
	    
	    @ManyToMany(mappedBy="enrolled_courses")
        private List<Student> enrolled_students;
	    
	    @OneToMany(mappedBy="for_course")
        private List<Grade> grades_of_students;
	    
	    @OneToOne
	    @JoinColumn(name="taught_by")
        private Professor professor;
	    
	    public Long getCourse_id() {
			return course_id;
		}

		public void setCourse_id(Long course_id) {
			this.course_id = course_id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public List<Student> getEnrolled_students() {
			return enrolled_students;
		}

		public void setEnrolled_students(List<Student> enrolled_students) {
			this.enrolled_students = enrolled_students;
		}

		public List<Grade> getGrades_of_students() {
			return grades_of_students;
		}

		public void setGrades_of_students(List<Grade> grades_of_students) {
			this.grades_of_students = grades_of_students;
		}

		public Professor getProfessor() {
			return professor;
		}

		public void setProfessor(Professor professor) {
			this.professor = professor;
		}
}
