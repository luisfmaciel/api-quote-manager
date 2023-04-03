package edu.infnet.al.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import edu.infnet.al.model.domain.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {}
