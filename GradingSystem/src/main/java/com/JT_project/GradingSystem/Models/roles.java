package com.JT_project.GradingSystem.Models;


import jakarta.persistence.*;
@Entity
@Table(name="roles")
public class roles {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long role_id;
      

	@OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="user_id")
	private User user;
       
    @Column(name="role")
    private String role;
       
       
    public User getUser_id() {
		return user;
	}
	public void setUser_id(User user) {
		this.user=user;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
    public Long getRole_id() {
		return role_id;
	}
	public void setRole_id(Long role_id) {
		this.role_id = role_id;
	} 
       
}
