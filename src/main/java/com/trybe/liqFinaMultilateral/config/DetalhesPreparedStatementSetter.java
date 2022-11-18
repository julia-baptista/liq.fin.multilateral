package com.trybe.liqFinaMultilateral.config;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.batch.item.database.ItemPreparedStatementSetter;
import com.trybe.liqFinaMultilateral.initialload.Grupo_SLC0001_LiquidProdt;

public class DetalhesPreparedStatementSetter
    implements ItemPreparedStatementSetter<Grupo_SLC0001_LiquidProdt> {
  @Override
  public void setValues(Grupo_SLC0001_LiquidProdt grupo_SLC0001_LiquidProdt, PreparedStatement ps)
      throws SQLException {
    ps.setString(1, grupo_SLC0001_LiquidProdt.getIdentdLinhaBilat());
    ps.setString(2, grupo_SLC0001_LiquidProdt.getTpDeb_Cred());
    ps.setLong(3, grupo_SLC0001_LiquidProdt.getISPBIFCredtd());
    ps.setLong(4, grupo_SLC0001_LiquidProdt.getISPBIFDebtd());
    ps.setDouble(5, grupo_SLC0001_LiquidProdt.getVlrLanc());
    ps.setLong(6, grupo_SLC0001_LiquidProdt.getCNPJNLiqdantDebtd());
    ps.setString(7, grupo_SLC0001_LiquidProdt.getNomCliDebtd());
    ps.setString(8, grupo_SLC0001_LiquidProdt.getCNPJNLiqdantCredtd());
    ps.setString(9, grupo_SLC0001_LiquidProdt.getNomCliCredtd());
    ps.setString(10, grupo_SLC0001_LiquidProdt.getTpTranscSLC());
  }
}
