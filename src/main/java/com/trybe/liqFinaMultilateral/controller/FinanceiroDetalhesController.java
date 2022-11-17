package com.trybe.liqFinaMultilateral.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.trybe.liqFinaMultilateral.model.FinanceiroDetalhes;
import com.trybe.liqFinaMultilateral.service.FinanceiroDetalhesService;

@RestController
@RequestMapping("v1/operacoes")
public class FinanceiroDetalhesController {

  private FinanceiroDetalhesService financeiroDetalhesService;

  public FinanceiroDetalhesController(FinanceiroDetalhesService financeiroDetalhesService) {
    super();
    this.financeiroDetalhesService = financeiroDetalhesService;
  }

  @GetMapping(produces = {"application/json"})
  public ResponseEntity<List<FinanceiroDetalhes>> listarPedidos() {
    List<FinanceiroDetalhes> lista = financeiroDetalhesService.listar();
    return ResponseEntity.ok(lista);
  }

}
