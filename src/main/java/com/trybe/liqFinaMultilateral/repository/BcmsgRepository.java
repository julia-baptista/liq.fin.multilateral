package com.trybe.liqFinaMultilateral.repository;

import com.trybe.liqFinaMultilateral.model.Bcmsg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BcmsgRepository extends JpaRepository<Bcmsg, Double> {
}
