package ejercicio6a.data;

//orig
import ejercicio6a.entities.*;

import java.sql.*;
import java.util.LinkedList;

public class DataProduct {

  public LinkedList<Product> getAll() {
    Statement stmt = null;
    ResultSet rs = null;
    LinkedList<Product> prod = new LinkedList<>();

    try {
      stmt = DbConnector.getInstancia().getConn().createStatement();
      rs = stmt.executeQuery("select id, name, description, price, stock, shippingIncluded from product");

      if (rs != null) {
        while (rs.next()) {
          Product p = new Product();

          p.setId(rs.getInt("id"));
          p.setName(rs.getString("name"));
          p.setDescription(rs.getString("description"));
          p.setPrice(rs.getDouble("price"));
          p.setStock(rs.getInt("stock"));
          p.setShippingIncluded(rs.getBoolean("shippingIncluded"));
          prod.add(p);
        }
      }

    } catch (SQLException e) {
      e.printStackTrace();

    } finally {
      try {
        if (rs != null) {
          rs.close();
        }
        if (stmt != null) {
          stmt.close();
        }
        DbConnector.getInstancia().releaseConn();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }

    return prod;
  }
}
