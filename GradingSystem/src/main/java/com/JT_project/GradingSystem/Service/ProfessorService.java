package com.JT_project.GradingSystem.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JT_project.GradingSystem.Models.Professor;
import com.JT_project.GradingSystem.Repos.ProfessorRepo;
@Service
public class ProfessorService {
       @Autowired 
       ProfessorRepo professorRepo;
      public Professor add_profDetails(Professor professor)
      {
    	  return professorRepo.save(professor);
      }
      public Professor update_profDetails(Long prof_id,Professor prof)
      {
    	  Professor existingProf=professorRepo.getReferenceById(prof_id);
    	  
    	  prof.setUser(existingProf.getUser());
    	  prof.setProf_id(prof_id);
    	  prof.setCourse(existingProf.getCourse());
    	  prof.setJoined_date(existingProf.getJoined_date());
    	  
    	  existingProf = prof;
    	  
    	  return professorRepo.save(existingProf);
    	  
      }
}
