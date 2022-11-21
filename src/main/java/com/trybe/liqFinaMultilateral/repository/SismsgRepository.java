package com.trybe.liqFinaMultilateral.repository;

import com.trybe.liqFinaMultilateral.model.Sismsg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SismsgRepository extends JpaRepository<Sismsg, Integer> {
}
