package com.springboot.forum.repository;

import com.springboot.forum.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {

	Course findByName(String courseName);

}