package com.springboot.forum.repository;

import com.springboot.forum.model.Thread;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ThreadRepository extends JpaRepository<Thread, Long>{

	Page<Thread> findByCourseName(String courseName, Pageable pageable);

}