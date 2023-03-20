package com.site.comercial.controller;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

import com.site.comercial.controller.dto.ProdutoDto;
import com.site.comercial.controller.form.ProdutoForm;
import com.site.comercial.models.Imagem;
import com.site.comercial.models.Produto;
import com.site.comercial.repository.CategoriaRepository;
import com.site.comercial.repository.ProdutoRepository;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoRepository;

	@PostMapping
	@CacheEvict(value = "produtoRepository", allEntries = true)
	@Transactional
	public ResponseEntity<Produto> salvarProduto( ProdutoForm form, BindingResult result,
			CategoriaRepository categoriaRepository, UriComponentsBuilder uriBuilder) {

		// Verifica se houve erros de validação no formulário
		if (result.hasErrors()) {
			return ResponseEntity.badRequest().build();
		}
		Produto produto = new Produto();
        produto.setNome(form.getNome());
        produto.setDescricao(form.getDescricao());
        
        List<Imagem> imagens = new ArrayList<>();
        for (MultipartFile imagem : form.getImagens()) {
            Imagem imagemProduto = new Imagem();
            imagemProduto.setProduto(produto);
            try {
                imagemProduto.setImagem(imagem.getBytes());
            } catch (IOException e) {
                 //tratar
            }
            imagens.add(imagemProduto);
        }
        produto.setImagens(imagens);
        
        Produto produtoSalvo = produtoRepository.save(produto);
        
        return ResponseEntity.created(URI.create("/produto/" + produtoSalvo.getId())).build();
	}

	@GetMapping("/{id}")
	@Cacheable(value = "produtoRepository")
	@Transactional
	public ResponseEntity<ProdutoDto> exibirProduto(@PathVariable Long id) {
		try {
			Produto produto = produtoRepository.findById(id)
					.orElseThrow(() -> new EntityNotFoundException("Produto não encontrado com o ID: " + id));
			ProdutoDto produtoDTO = new ProdutoDto(produto);
			return ResponseEntity.ok().body(produtoDTO);
		} catch (EntityNotFoundException e) {
			return ResponseEntity.notFound().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@GetMapping
	@Cacheable(value = "produtoRepository")
	@Transactional
	public Page<ProdutoDto> exibirTudo(Pageable paginacao) {
		return produtoRepository.findAll(paginacao).map(ProdutoDto::new);
	}

	@PutMapping("/{id}")
	@CacheEvict(value = "produtoRepository", allEntries = true)
	@Transactional
	public ResponseEntity<Produto> atualizarProduto(@PathVariable Long id, @RequestBody ProdutoForm form,
			CategoriaRepository categoriaRepository) {
		Optional<Produto> produto = produtoRepository.findById(id);
		if (produto.isPresent()) {

			Produto produtoAtualizado = form.atualizar(id, categoriaRepository, produtoRepository);
			return ResponseEntity.ok(produtoAtualizado);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	@CacheEvict(value = "produtoRepository", allEntries = true)
	@Transactional
	public ResponseEntity<Void> deletarProduto(@PathVariable Long id) {
		Optional<Produto> produto = produtoRepository.findById(id);
		if (produto.isPresent()) {
			produtoRepository.deleteById(id);
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
