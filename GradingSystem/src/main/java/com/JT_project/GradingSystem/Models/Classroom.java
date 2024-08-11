package com.JT_project.GradingSystem.Models;
import java.sql.Date;
import java.util.List;

import jakarta.persistence.*;
@Entity
@Table(name="classrooms")
public class Classroom {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="classroom_id")
	private Long classroom_id;
	
	@Column(name="start_date")
	private Date start_date;
	
	@Column(name="end_date")
	private Date end_date;
	
	@OneToMany(mappedBy="classroom")
	private List<Student> students_in_class;
	
	public Long getClassroom_id() {
		return classroom_id;
	}

	public void setClassroom_id(Long classroom_id) {
		this.classroom_id = classroom_id;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public List<Student> getStudents_in_class() {
		return students_in_class;
	}

	public void setStudents_in_class(List<Student> students_in_class) {
		this.students_in_class = students_in_class;
	}

}
