package com.trybe.liqFinaMultilateral.repository;

import com.trybe.liqFinaMultilateral.model.Doc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocRepository extends JpaRepository<Doc, Integer> {

}
