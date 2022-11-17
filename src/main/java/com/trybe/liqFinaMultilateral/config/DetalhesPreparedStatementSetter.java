package com.trybe.liqFinaMultilateral.config;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.batch.item.database.ItemPreparedStatementSetter;
import com.trybe.liqFinaMultilateral.model.FinanceiroDetalhes;

public class DetalhesPreparedStatementSetter
    implements ItemPreparedStatementSetter<FinanceiroDetalhes> {
  @Override
  public void setValues(FinanceiroDetalhes financeiroDetalhes, PreparedStatement ps)
      throws SQLException {
    ps.setString(1, financeiroDetalhes.getIdentdLinhaBilat());
    ps.setString(2, financeiroDetalhes.getTpDeb_Cred());
    ps.setLong(3, financeiroDetalhes.getISPBIFCredtd());
    ps.setLong(4, financeiroDetalhes.getISPBIFDebtd());
    ps.setDouble(5, financeiroDetalhes.getVlrLanc());
    ps.setLong(6, financeiroDetalhes.getCNPJNLiqdantDebtd());
    ps.setString(7, financeiroDetalhes.getNomCliDebtd());
    ps.setLong(8, financeiroDetalhes.getCNPJNLiqdantCredtd());
    ps.setString(9, financeiroDetalhes.getNomCliCredtd());
    ps.setString(10, financeiroDetalhes.getTpTranscSLC());
  }
}
