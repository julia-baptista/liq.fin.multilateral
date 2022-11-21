package com.trybe.liqFinaMultilateral.repository;

import com.trybe.liqFinaMultilateral.model.GrupoSlc0001LiquidProdt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrupoSlc0001LiquidProdtRepository
    extends JpaRepository<GrupoSlc0001LiquidProdt, String> {

}
