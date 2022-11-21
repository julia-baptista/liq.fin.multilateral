package com.trybe.liqFinaMultilateral.repository;

import com.trybe.liqFinaMultilateral.model.GrupoSeq;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrupoSeqRepository extends JpaRepository<GrupoSeq, Integer> {
}
