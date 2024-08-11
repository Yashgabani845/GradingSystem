package com.JT_project.GradingSystem.SecurityConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {

    // add support for JDBC ... no more hardcoded users :-)

	@Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {

        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
       // define query to retrieve a user by username
       jdbcUserDetailsManager.setUsersByUsernameQuery(
                "select username,password,active from users where username=?");
      
       // define query to retrieve the authorities/roles by username
       jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
               "select u.username,r.role from users u,roles r where u.user_id=r.user_id and username=?");
        return jdbcUserDetailsManager;
   }
	
@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

    http.authorizeHttpRequests(configurer ->
    configurer
//            .requestMatchers(HttpMethod.GET, "/api/prof").hasRole("PROF")
//            .requestMatchers(HttpMethod.GET, "/api/student").hasRole("STUDENT")
            .requestMatchers(HttpMethod.POST,"/api/add_studentUser").permitAll()
            .requestMatchers(HttpMethod.POST,"/api/add_professorUser").permitAll()
            .requestMatchers(HttpMethod.POST,"/api/add_profDetails/{user_id}").hasRole("PROF")
            .requestMatchers(HttpMethod.POST,"/api/add_studentDetails/{user_id}").hasRole("STUDENT")
            .requestMatchers(HttpMethod.GET,"/api/show_grades/{student_id}").hasRole("STUDENT")
            .requestMatchers(HttpMethod.GET,"/api/show_grade/{course_name}/{student_id}").hasRole("STUDENT")
            .requestMatchers(HttpMethod.PUT,"/api/update_studentDetails/{student_id}").hasRole("STUDENT")
            .requestMatchers(HttpMethod.PUT,"/api/update_profDetails/{prof_id}").hasRole("PROF")
            .requestMatchers(HttpMethod.DELETE,"/api/delete_student/{student_id}").hasRole("PROF")
            .requestMatchers(HttpMethod.GET,"/api/classroom_students/{class_id}").hasRole("PROF")
            .requestMatchers(HttpMethod.GET,"/api/course_studets/{course_id}").hasRole("PROF")
            .requestMatchers(HttpMethod.POST,"/api/add_studentGrade/{belong_to_id}/{course_id}").hasRole("PROF")
            .requestMatchers(HttpMethod.PUT,"/api/update_studentGrade/{grade_id}").hasRole("PROF")
            .requestMatchers(HttpMethod.DELETE,"/api/delete_studentGrade/{grade_id}").hasRole("PROF")
            .requestMatchers(HttpMethod.GET,"/api/analysis_classroom/{class_id}").hasRole("PROF")
            .requestMatchers(HttpMethod.GET,"/api/analysis_course/{course_id}").hasRole("PROF")
);

        // use HTTP Basic authentication
        http.httpBasic(Customizer.withDefaults());

        // disable Cross Site Request Forgery (CSRF)
        // in general, not required for stateless REST APIs that use POST, PUT, DELETE and/or PATCH
        http.csrf(csrf -> csrf.disable());

        return http.build();
    }
}
