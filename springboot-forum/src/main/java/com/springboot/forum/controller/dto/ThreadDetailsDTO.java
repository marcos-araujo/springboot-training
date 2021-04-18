package com.springboot.forum.controller.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.springboot.forum.model.ThreadStatus;
import com.springboot.forum.model.Thread;

public class ThreadDetailsDTO {
	
	private Long id;
	private String title;
	private String message;
	private LocalDateTime creation;
	private String authorName;
	private ThreadStatus status;
	private List<AnswerDTO> answers;

	public ThreadDetailsDTO(Thread thread) {
		this.id = thread.getId();
		this.title = thread.getTitle();
		this.message = thread.getMessage();
		this.creation = thread.getDateCreation();
		this.authorName = thread.getAuthor().getName();
		this.status = thread.getStatus();
		this.answers = new ArrayList<>();
		this.answers.addAll(thread.getAnswers().stream().map(AnswerDTO::new).collect(Collectors.toList()));
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

	public LocalDateTime getCreation() {
		return creation;
	}

	public String getAuthorName() {
		return authorName;
	}

	public ThreadStatus getStatus() {
		return status;
	}

	public List<AnswerDTO> getAnswers() {
		return answers;
	}

}