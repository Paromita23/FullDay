package com.hexaware.MLP178.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.hexaware.MLP178.model.Freegift;
//mport com.hexaware.MLP178.model.WalletType;

import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.skife.jdbi.v2.StatementContext;
/**
 * MenuMapper class used to fetch menu data from database.
 * @author hexware
 */
public class FreegiftMapper implements ResultSetMapper<Freegift> {
    /**
     * @param idx the index
     * @param rs the resultset
     * @param ctx the context
     * @return the mapped customer object
     * @throws SQLException in case there is an error in fetching data from the resultset
     */
  public final Freegift map(final int idx, final ResultSet rs, final StatementContext ctx) throws SQLException {
      /**
       * @return Menu
       */
    //String type = rs.getString("WAL_TYPE");
    //WalletType wtype = WalletType.valueOf(type);
    //String status = rs.getString("ORD_STATUS");
    //OrderStatus ostat = OrderStatus.valueOf(status);
    return new Freegift(rs.getInt("CUS_ID"), rs.getInt("VEN_ID"), rs.getInt("GIFTSTAT"));
  }
}
