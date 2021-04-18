package com.springboot.forum.controller.dto;

import java.time.LocalDateTime;

import com.springboot.forum.model.Thread;
import org.springframework.data.domain.Page;

public class ThreadDTO {
	
	private Long id;
	private String title;
	private String message;
	private LocalDateTime creationDate;
	
	public ThreadDTO(Thread thread) {
		this.id = thread.getId();
		this.title = thread.getTitle();
		this.message = thread.getMessage();
		this.creationDate = thread.getDateCreation();
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getMessage() {
		return message;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public static Page<ThreadDTO> transform(Page<Thread> threads){
		return threads.map(ThreadDTO::new);
	}
	
}