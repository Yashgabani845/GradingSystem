package com.JT_project.GradingSystem.Repos;

import com.JT_project.GradingSystem.Models.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepo extends JpaRepository<User,Long> {

}
