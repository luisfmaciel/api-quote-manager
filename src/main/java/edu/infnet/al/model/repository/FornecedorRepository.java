package edu.infnet.al.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import edu.infnet.al.model.domain.Fornecedor;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Integer> {}
