package example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import example.repository.Produto;
import example.service.ProdutoService;

@RestController
@RequestMapping(value = "/produto")
public class ProdutoController {

	@Autowired
	private ProdutoService service;

	public ProdutoService getService() {
		return service;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<String> criarProduto(@RequestBody Produto produto) {
		try {

			service.salvarProduto(produto);

			return new ResponseEntity<String>(HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Produto>> listarProdutos() {

		List<Produto> produtos = new ArrayList<Produto>();
		produtos = service.buscarTodos();
		return new ResponseEntity<List<Produto>>(produtos, HttpStatus.OK);

	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<Produto> buscarProduto(@PathVariable int id) {

		Produto produto = service.getById(id);
		return produto == null ? new ResponseEntity<Produto>(HttpStatus.NOT_FOUND)
				: new ResponseEntity<Produto>(produto, HttpStatus.OK);

	}

	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<String> atualizarProduto(@RequestBody Produto produto) {
		try {
			service.atualizarProduto(produto);
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}

	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> removerProduto(@PathVariable int id) {
		try {
			service.removerProduto(id);
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}

	}

}
