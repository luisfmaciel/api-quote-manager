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

import edu.infnet.al.model.domain.Endereco;
import edu.infnet.al.model.domain.Fornecedor;
import edu.infnet.al.model.service.CotacaoService;
import edu.infnet.al.model.service.EnderecoService;
import edu.infnet.al.model.service.FornecedorService;

@RestController
@RequestMapping("/api/fornecedor")
public class FornecedorController {

	@Autowired
	private FornecedorService fornecedorService;
	@Autowired
	private EnderecoService enderecoService;
	@Autowired
	private CotacaoService cotacaoService;

	@GetMapping(value = "/listar")
	public List<Fornecedor> obterLista() {
		return fornecedorService.obterLista();
	}

	@PostMapping(value = "/incluir")
	public Fornecedor incluir(@RequestBody Fornecedor fornecedor, @RequestParam String cep) {
		fornecedor.setEndereco(enderecoService.buscaPorCep(cep));
		return fornecedorService.incluir(fornecedor);
	}

	@PutMapping(value = "/{id}/atualizar")
	public Fornecedor atualizar(@PathVariable Integer id, @RequestParam(required = false) Integer cotacaoId,
			@RequestParam(required = false) String cep, @RequestBody Map<String, String> fornecedor) {
		Fornecedor f = fornecedorService.obterFornecedorById(id);
		f.setRazaoSocial(fornecedor.get("razaoSocial"));
		f.setCnpj(fornecedor.get("cnpj"));
		f.setEmail(fornecedor.get("email"));
		f.setTelefone(fornecedor.get("telefone"));

		Endereco endereco = enderecoService.buscaPorCep(cep);
		f.setEndereco(endereco);

		if (cotacaoId != null)
			f.setCotacao(cotacaoService.obterCotacaoById(cotacaoId));

		return fornecedorService.incluir(f);
	}

	@DeleteMapping(value = "/{id}/excluir")
	public void excluir(@PathVariable Integer id) {
		fornecedorService.excluir(id);
	}

}
