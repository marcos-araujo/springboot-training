package com.springboot.forum.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.springboot.forum.model.Thread;
import com.springboot.forum.repository.ThreadRepository;
import org.hibernate.validator.constraints.Length;

public class UpdateThreadForm {

	@NotNull
	@NotEmpty
	@Length(min = 5)
	private String title;

	@NotNull
	@NotEmpty
	@Length(min = 10)
	private String message;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Thread update(Long id, ThreadRepository threadRepository) {
		Thread thread = threadRepository.getOne(id);
		thread.setTitle(title);
		thread.setMessage(message);
		return thread;
	}

}