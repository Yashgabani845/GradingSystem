package com.JT_project.GradingSystem.Repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.JT_project.GradingSystem.Models.Course;

public interface CourseRepo extends JpaRepository <Course,Long> {

}
