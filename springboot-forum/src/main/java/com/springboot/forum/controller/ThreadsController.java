package com.springboot.forum.controller;

import java.net.URI;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import com.springboot.forum.controller.dto.ThreadDTO;
import com.springboot.forum.controller.dto.ThreadDetailsDTO;
import com.springboot.forum.controller.form.ThreadForm;
import com.springboot.forum.controller.form.UpdateThreadForm;
import com.springboot.forum.model.Thread;
import com.springboot.forum.repository.CourseRepository;
import com.springboot.forum.repository.ThreadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/threads")
public class ThreadsController {

	@Autowired
	private ThreadRepository threadRepository;

	@Autowired
	private CourseRepository courseRepository;

	@GetMapping
	@Cacheable(value = "list")
	public Page<ThreadDTO> list(@RequestParam(required = false) String courseName, @PageableDefault(sort = "id", direction = Direction.DESC) Pageable pagination) {
		Page<Thread> threads = courseName == null ? threadRepository.findAll(pagination) : threadRepository.findByCourseName(courseName, pagination);
		return ThreadDTO.transform(threads);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ThreadDetailsDTO> get(@PathVariable Long id) {
		Optional<Thread> thread = threadRepository.findById(id);
		if (thread.isPresent())
			return ResponseEntity.ok(new ThreadDetailsDTO(thread.get()));
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	@Transactional
	@CacheEvict(value = "list", allEntries = true)
	public ResponseEntity<ThreadDTO> create(@RequestBody @Valid ThreadForm threadForm, UriComponentsBuilder uriBuilder) {
		Thread thread = threadForm.transform(courseRepository);
		threadRepository.save(thread);
		URI uri = uriBuilder.path("/threads/{id}").buildAndExpand(thread.getId()).toUri();
		return ResponseEntity.created(uri).body(new ThreadDTO(thread));
	}

	@PutMapping("/{id}")
	@Transactional
	@CacheEvict(value = "list", allEntries = true)
	public ResponseEntity<ThreadDTO> update(@PathVariable Long id, @RequestBody @Valid UpdateThreadForm updateThreadForm,
			UriComponentsBuilder uriBuilder) {
		Optional<Thread> optional = threadRepository.findById(id);
		if (optional.isPresent()) {
			Thread thread = updateThreadForm.update(id, threadRepository);
			return ResponseEntity.ok(new ThreadDTO(thread));
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	@Transactional
	@CacheEvict(value = "list", allEntries = true)
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Optional<Thread> optional = threadRepository.findById(id);
		if (optional.isPresent()) {
			threadRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}

}