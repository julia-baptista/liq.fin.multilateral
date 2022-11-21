package com.trybe.liqFinaMultilateral.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.trybe.liqFinaMultilateral.dtos.DocDTO;
import com.trybe.liqFinaMultilateral.service.XmlService;

@RestController
@RequestMapping("v1/operacoes")
public class DocController {

  private XmlService service;

  public DocController(XmlService service) {
    this.service = service;
  }

  @GetMapping(produces = {"application/json"})
  public ResponseEntity<DocDTO> listar() {
    DocDTO docDTO = service.listar();
    return ResponseEntity.ok(docDTO);
  }

}
