package com.trybe.liqFinaMultilateral.repository;

import com.trybe.liqFinaMultilateral.model.GrupoSlc0001Prodt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrupoSlc0001ProdtRepository extends JpaRepository<GrupoSlc0001Prodt, String> {
}
