package com.trybe.liqFinaMultilateral.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


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
