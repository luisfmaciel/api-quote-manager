package edu.infnet.al.controller;

import java.util.ArrayList;
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
import edu.infnet.al.model.domain.Produto;
import edu.infnet.al.model.service.CotacaoService;
import edu.infnet.al.model.service.ProdutoService;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;
	@Autowired
	private CotacaoService cotacaoService;

	@GetMapping(value = "/listar")
	public List<Produto> obterLista() {
		return produtoService.obterLista();
	}

	@GetMapping(value = "/{id}/listar")
	public Produto obterProduto(@PathVariable Integer id) {
		return produtoService.obterProdutoById(id);
	}

	@PostMapping(value = "/incluir")
	public Produto incluir(@RequestBody Produto produto) {
		return produtoService.incluir(produto);
	}

	@PutMapping(value = "/{id}/atualizar")
	public Produto atualizar(@PathVariable Integer id, @RequestParam(required = false) String cotacaoId,
			@RequestBody Map<String, String> produto) {
		Produto p = produtoService.obterProdutoById(id);
		p.setNome(produto.get("nome"));
		p.setDescricao(produto.get("descricao"));
		p.setDepartamento(produto.get("departamento"));
		p.setQuantidade(Integer.parseInt(produto.get("quantidade")));

		List<Cotacao> cotacoes = new ArrayList<Cotacao>();
		if(cotacaoId != null) {
			for (String quote : cotacaoId.split(",")) {
				cotacoes.add(cotacaoService.obterCotacaoById(Integer.parseInt(quote)));
			}
			p.setCotacoes(cotacoes);
		}
		return produtoService.incluir(p);
	}

	@DeleteMapping(value = "/{id}/excluir")
	public void excluir(@PathVariable Integer id) {
		produtoService.excluir(id);
	}

}
