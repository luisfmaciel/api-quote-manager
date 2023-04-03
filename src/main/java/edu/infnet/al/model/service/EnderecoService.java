package edu.infnet.al.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.infnet.al.clients.IEnderecoClient;
import edu.infnet.al.model.domain.Endereco;

@Service
public class EnderecoService {
	
	@Autowired
	private IEnderecoClient enderecoClient;
	
	public Endereco buscaPorCep(String cep) {
		return enderecoClient.buscaPorCep(cep);
	}
}
