package com.JT_project.GradingSystem.Repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.JT_project.GradingSystem.Models.Grade;

public interface GradeRepo extends JpaRepository<Grade,Long> {

}
