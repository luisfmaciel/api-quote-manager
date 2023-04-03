package edu.infnet.al.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.infnet.al.model.domain.Cotacao;
import edu.infnet.al.model.service.CotacaoService;
import edu.infnet.al.model.service.FornecedorService;
import edu.infnet.al.model.service.ProdutoService;

@RestController
@RequestMapping("/api/cotacao")
public class CotacaoController {

	@Autowired
	private CotacaoService cotacaoService;
	@Autowired
	private ProdutoService produtoService;
	@Autowired
	private FornecedorService fornecedorService;

	@GetMapping(value = "/listar")
	public List<Cotacao> obterLista() {
		return cotacaoService.obterLista();
	}

	@PostMapping(value = "/incluir")
	public Cotacao incluir(@RequestBody Cotacao cotacao,
			@RequestParam(required = false) Integer fornecedorId, @RequestParam(required = false) Integer produtoId) {
		if(fornecedorId != null) cotacao.setFornecedor(fornecedorService.obterFornecedorById(fornecedorId));
		if(produtoId != null) cotacao.setProduto(produtoService.obterProdutoById(produtoId));
		return cotacaoService.incluir(cotacao);
	}

	@PutMapping(value = "/{id}/atualizar")
	public Cotacao atualizar(@PathVariable Integer id, @RequestParam(required = false) Integer fornecedorId,
			@RequestParam(required = false) Integer produtoId, @RequestBody Map<String, String> cotacao) {
		Cotacao c = cotacaoService.obterCotacaoById(id);

		c.setCanal(cotacao.get("canal"));
		c.setPreco(Float.parseFloat(cotacao.get("preco")));

		if (fornecedorId != null)
			c.setFornecedor(fornecedorService.obterFornecedorById(fornecedorId));

		if (produtoId != null)
			c.setProduto(produtoService.obterProdutoById(produtoId));

		return cotacaoService.incluir(c);
	}

	@DeleteMapping(value = "/{id}/excluir")
	public void excluir(@PathVariable Integer id) {
		cotacaoService.excluir(id);
	}

}
