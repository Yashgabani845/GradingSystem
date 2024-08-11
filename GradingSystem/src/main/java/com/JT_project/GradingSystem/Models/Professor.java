package com.JT_project.GradingSystem.Models;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
@Entity
@Table(name="professors")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Professor {
          

		  @Id
	      @GeneratedValue(strategy=GenerationType.IDENTITY)
	      private Long prof_id;
	      
	      @OneToOne
          @JoinColumn(name="user_id")
		  private User user;
          
          @Column(name="first_name")
          private String first_name;
          
          @Column(name="second_name")
          private String second_name;
          
          @Column(name="email")
          private String email;
          
          @Column(name="joined_date")
          private Date joined_date;
          
          @OneToOne(mappedBy="professor",cascade=CascadeType.ALL)
          private Course course;
          
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
	public String getSecond_name() {
		return second_name;
	}
	public void setSecond_name(String second_name) {
		this.second_name = second_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getJoined_date() {
		return joined_date;
	}
	public void setJoined_date(Date joined_date) {
		this.joined_date = joined_date;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public Long getProf_id() {
			return prof_id;
	}
	public void setProf_id(Long prof_id) {
			this.prof_id = prof_id;
	}
	
}
