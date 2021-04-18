package com.springboot.forum.controller.dto;

import java.time.LocalDateTime;

import com.springboot.forum.model.Answer;

public class AnswerDTO {

	private Long id;
	private String message;
	private LocalDateTime creationDate;
	private String authorsName;

	public AnswerDTO(Answer answer) {
		this.id = answer.getId();
		this.message = answer.getMessage();
		this.creationDate = answer.getCreationDate();
		this.authorsName = answer.getAuthor().getName();
	}

	public Long getId() {
		return id;
	}

	public String getMessage() {
		return message;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public String getNomeAuthor() {
		return authorsName;
	}
	
}