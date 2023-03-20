package com.site.comercial.controller;

import java.net.URI;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.site.comercial.controller.dto.CategoriaDto;
import com.site.comercial.controller.form.CategoriaForm;
import com.site.comercial.models.Categoria;
import com.site.comercial.repository.CategoriaRepository;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@GetMapping
	@Transactional
	public Page<CategoriaDto>listar(Pageable paginação) {

		return categoriaRepository.findAll(paginação).map(CategoriaDto::new);

	}

	@PostMapping
	@Transactional
	@CacheEvict(value = "categoriaRepository", allEntries = true)
	public ResponseEntity<Categoria> salvar(@RequestBody CategoriaForm form, UriComponentsBuilder uriBuilder) {

		Categoria categoria = form.salvar();
		categoriaRepository.save(categoria);

		URI uri = uriBuilder.path("/categoria/{id}").buildAndExpand(categoria.getId()).toUri();
		return ResponseEntity.created(uri).body(categoria);

	}

	@PutMapping
	@Transactional
	@CacheEvict(value = "categoriaRepository", allEntries = true)
	public ResponseEntity<Categoria> atualizar(@PathVariable Long id, @RequestBody CategoriaForm form) {
		Optional<Categoria> categoria = categoriaRepository.findById(id);

		if (categoria.isPresent()) {
			Categoria categoriaAtualizada = form.atualizar();
			return ResponseEntity.ok(categoriaAtualizada);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping
	@Transactional
	@CacheEvict(value = "categoriaRepository", allEntries = true)
	public ResponseEntity<Categoria> deletar(@PathVariable Long id) {

		Optional<Categoria> categoria = categoriaRepository.findById(id);

		if (categoria.isPresent()) {
			categoriaRepository.delete(categoria.get());
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}

	}

}
