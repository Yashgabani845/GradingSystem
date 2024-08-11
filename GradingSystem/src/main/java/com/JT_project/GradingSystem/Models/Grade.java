package com.JT_project.GradingSystem.Models;
import jakarta.persistence.*;
@Entity
@Table(name="grades")
public class Grade {
	  @Id
	  @GeneratedValue(strategy=GenerationType.IDENTITY)
      private Long grade_id;
	  
	  @Column(name="internal_marks")
      private Double internal_marks;
	  
	  @Column(name="external_marks")
      private Double external_marks;
	  
	  @Column(name="practical_marks")
      private Double practical_marks;
	  
	  @Column(name="grade_letter")
      private String Grade_letter;
	  
	  @Column(name="obtained_credit")
      private Double obtained_credit;
	  
	  @ManyToOne
	  @JoinColumn(name="belong_to_student")
      private Student belong_to_student;
	  @ManyToOne
	  @JoinColumn(name="for_course")
      private Course for_course;
	  
	  
	public Long getGrade_id() {
		return grade_id;
	}
	public void setGrade_id(Long grade_id) {
		this.grade_id = grade_id;
	}
	public Double getInternal_marks() {
		return internal_marks;
	}
	public void setInternal_marks(Double internal_marks) {
		this.internal_marks = internal_marks;
	}
	public Double getExternal_marks() {
		return external_marks;
	}
	public void setExternal_marks(Double external_marks) {
		this.external_marks = external_marks;
	}
	public Double getPractical_marks() {
		return practical_marks;
	}
	public void setPractical_marks(Double practical_marks) {
		this.practical_marks = practical_marks;
	}
	public String getGrade_letter() {
		return Grade_letter;
	}
	public void setGrade_letter(String Grade_letter) {
		this.Grade_letter = Grade_letter;
	}
	public Double getObtained_credit() {
		return obtained_credit;
	}
	public void setObtained_credit(Double obtained_credit) {
		this.obtained_credit = obtained_credit;
	}
	public Student getBelong_to_student() {
		return belong_to_student;
	}
	public void setBelong_to_student(Student belong_to_student) {
		this.belong_to_student = belong_to_student;
	}
	public Course getFor_course() {
		return for_course;
	}
	public void setFor_course(Course for_course) {
		this.for_course = for_course;
	}
      
      
}
