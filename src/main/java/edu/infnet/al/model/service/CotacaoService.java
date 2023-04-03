package edu.infnet.al.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.infnet.al.model.domain.Cotacao;
import edu.infnet.al.model.repository.CotacaoRepository;

@Service
public class CotacaoService {
	@Autowired
	private CotacaoRepository cotacaoRepository;
	
	public Cotacao incluir(Cotacao cotacao) {
		return cotacaoRepository.save(cotacao);
	}
	
	public void excluir(Integer key) {
		cotacaoRepository.deleteById(key);
	}
	
	public Cotacao obterCotacaoById(Integer key) {
		return cotacaoRepository.findById(key).get();
	}
	
	public List<Cotacao> obterLista() {
		return cotacaoRepository.findAll();
	}
}
