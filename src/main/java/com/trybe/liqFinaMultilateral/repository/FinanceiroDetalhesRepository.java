package com.trybe.liqFinaMultilateral.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trybe.liqFinaMultilateral.model.FinanceiroDetalhes;

@Repository
public interface FinanceiroDetalhesRepository extends JpaRepository<FinanceiroDetalhes, String> {

}
