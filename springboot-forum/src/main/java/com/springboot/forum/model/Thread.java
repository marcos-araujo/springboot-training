package com.springboot.forum.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Thread {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String message;
	private LocalDateTime creationDate = LocalDateTime.now();
	@Enumerated(EnumType.STRING)
	private ThreadStatus status = ThreadStatus.NOT_ANSWERED;
	@ManyToOne
	private User author;
	@ManyToOne
	private Course course;
	@OneToMany(mappedBy = "thread")
	private List<Answer> answers = new ArrayList<>();

	public Thread() {}

	public Thread(String title, String message, Course course) {
		super();
		this.title = title;
		this.message = message;
		this.course = course;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Thread other = (Thread) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

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

	public LocalDateTime getDateCreation() {
		return creationDate;
	}
	public void setDateCreation(LocalDateTime dateCreation) {
		this.creationDate = dateCreation;
	}

	public ThreadStatus getStatus() {
		return status;
	}
	public void setStatus(ThreadStatus status) {
		this.status = status;
	}

	public User getAuthor() {
		return author;
	}
	public void setAuthor(User author) {
		this.author = author;
	}

	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}

	public List<Answer> getAnswers() {
		return answers;
	}
	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

}