package example.service;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import example.repository.Produto;
import example.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repository;

	public Produto getById(int id) {
		return repository.findOne(id);
	}

	public List<Produto> buscarTodos() {
		return repository.findAll();
	}

	public ProdutoRepository getRepository() {
		return repository;
	}

	@Transactional
	public void salvarProduto(@NotNull Produto produto) {
		boolean encontrado = repository.exists(produto.getId());
		if (encontrado == true) {
			System.out.println("Produto já foi Cadastrado");

		} else {
			repository.save(produto);
		}

	}
	@Transactional
	public void atualizarProduto(@NotNull Produto produto) {
		boolean encontrado = repository.exists(produto.getId());
		if (encontrado == true) {
			repository.save(produto);

		} else {
			System.out.println("Produto não Encontrado");
		}

	}


	public void removerProduto(int id) {
		repository.delete(id);
	}

}
