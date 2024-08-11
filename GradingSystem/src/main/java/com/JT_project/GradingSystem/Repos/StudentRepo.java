package com.JT_project.GradingSystem.Repos;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.JT_project.GradingSystem.Models.Student;

public interface StudentRepo extends JpaRepository<Student,Long> {

	 @Query(value="select s.first_name,s.second_name from students s,grades g,classrooms c where s.student_id=g.belong_to_student and s.class_id = c.classroom_id and c.classroom_id=:class_id order by g.obtained_credit desc", nativeQuery = true)
	 List<String> topper_list(@Param("class_id")Long class_id);
	 
	 @Query(value="select s.first_name,s.second_name form students s,grades g,enroll e where s.student_id=g.belong_to_student and s.student_id=e.student_id and e.course_id=:course_id order by g.obtained_credit desc",nativeQuery = true)
	 List<String> topper_list_course(@Param("course_id")Long course_id);
}
