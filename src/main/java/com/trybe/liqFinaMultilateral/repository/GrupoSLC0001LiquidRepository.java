package com.trybe.liqFinaMultilateral.repository;

import com.trybe.liqFinaMultilateral.model.GrupoSLC0001Liquid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrupoSLC0001LiquidRepository extends JpaRepository<GrupoSLC0001Liquid, Integer> {
}
