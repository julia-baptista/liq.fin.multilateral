package com.trybe.liqFinaMultilateral.service;

// import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.trybe.liqFinaMultilateral.exception.ErroInesperadoException;
import com.trybe.liqFinaMultilateral.model.FinanceiroDetalhes;
import com.trybe.liqFinaMultilateral.repository.FinanceiroDetalhesRepository;


@Service
public class FinanceiroDetalhesService {

  final FinanceiroDetalhesRepository detalhesRep;

  public FinanceiroDetalhesService(FinanceiroDetalhesRepository detalhesRep) {
    super();
    this.detalhesRep = detalhesRep;
  }

  /**
   * Listar.
   */
  public List<FinanceiroDetalhes> listar() {
    try {
      // List<FinanceiroDetalhesDtoSaida> pedidosDto = new ArrayList<PedidoDtoSaida>();
      List<FinanceiroDetalhes> operacoes = detalhesRep.findAll();
      // pedidos.stream().forEach(pedido -> {
      // pedidosDto.add(converterPedidoParaPedidoDtoSaida(pedido));
      // });
      return operacoes;
    } catch (Exception e) {
      throw new ErroInesperadoException();
    }
  }

}
