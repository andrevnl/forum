package br.com.alura.forum;

import br.com.alura.forum.model.Curso;
import br.com.alura.forum.repository.CursoRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class CursoRepositoryTests {

	@Autowired
	private CursoRepository repository;

	@Test
	public void deveriaCarregarUmCursoAoBuscarPeloSeuNome() {
		String nomeCurso = "HTML 5";

		Curso curso = repository.findByNome(nomeCurso);

		Assert.assertNotNull(curso);
		Assert.assertEquals(nomeCurso, curso.getNome());
	}

	@Test
	public void naoDeveriaCarregarUmCursoCujoNomeNaoEstejaCadastrado() {
		String nomeCurso = "JPA";

		Curso curso = repository.findByNome(nomeCurso);

		Assert.assertNull(curso);
	}

}
