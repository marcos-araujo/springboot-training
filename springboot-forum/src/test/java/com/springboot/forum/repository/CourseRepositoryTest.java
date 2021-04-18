package com.springboot.forum.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.springboot.forum.model.Course;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class CourseRepositoryTest {
	
	@Autowired
	private CourseRepository repository;
	
	@Autowired
	private TestEntityManager em;

	@Test
	public void deveriaCarregarUmCursoAoBuscarPeloSeuNome() {
		String courseName = "HTML 5";
		
		Course html5 = new Course();
		html5.setName("HTML 5");
		html5.setCategory("FrontEnd");
		em.persist(html5);
		
		Course course = repository.findByName(courseName);
		Assert.assertNotNull(course);
		Assert.assertEquals(courseName, course.getName());
	}
	
	@Test
	public void naoDeveriaCarregarUmCursoSemNomeCadastrado() {
		String courseName = "JPA";
		Course course = repository.findByName(courseName);
		Assert.assertNull(course);
	}
}
