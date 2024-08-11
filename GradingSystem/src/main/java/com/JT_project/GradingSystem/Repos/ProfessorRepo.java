package com.JT_project.GradingSystem.Repos;

import org.springframework.data.jpa.repository.JpaRepository;


import com.JT_project.GradingSystem.Models.Professor;

public interface ProfessorRepo extends JpaRepository<Professor,Long> {

}
