package com.trybe.liqFinaMultilateral.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.trybe.liqFinaMultilateral.exception.DataError;
import com.trybe.liqFinaMultilateral.exception.ErroInesperadoException;


public class GerenciadorAdvice {

  @ExceptionHandler({ErroInesperadoException.class})
  public ResponseEntity<DataError> handleInternalServer(RuntimeException e) {

    DataError payload = new DataError(e.getMessage());

    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(payload);

  }

}
