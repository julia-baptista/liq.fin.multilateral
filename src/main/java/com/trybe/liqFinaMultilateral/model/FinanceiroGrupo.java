package com.trybe.liqFinaMultilateral.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class FinanceiroGrupo {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String CodProdt;

  // @OneToMany(mappedBy = "grupo", cascade = CascadeType.ALL, orphanRemoval = true,
  // fetch = FetchType.LAZY)
  @OneToMany(mappedBy = "grupo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JsonIgnore
  private List<FinanceiroDetalhes> finDetalhes = new ArrayList<>();

}
