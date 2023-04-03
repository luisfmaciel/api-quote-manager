package edu.infnet.al.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import edu.infnet.al.model.domain.Cotacao;

public interface CotacaoRepository extends JpaRepository<Cotacao, Integer> {}
