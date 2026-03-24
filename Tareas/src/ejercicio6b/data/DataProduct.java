package ejercicio6b.data;

import java.sql.*;
import java.time.ZonedDateTime;
import java.util.LinkedList;

import ejercicio6b.entities.Product;

public class DataProduct {

  public LinkedList<Product> getAll() {
    Statement stmt = null;
    ResultSet rs = null;
    LinkedList<Product> prod = new LinkedList<>();

    try {
      stmt = DbConnector.getInstancia().getConn().createStatement();
      rs = stmt.executeQuery("select id, name, description, price, stock, shippingIncluded, disabledOn from product");

      if (rs != null) {
        while (rs.next()) {
          Product p = new Product();

          p.setId(rs.getInt("id"));
          p.setName(rs.getString("name"));
          p.setDescription(rs.getString("description"));
          p.setPrice(rs.getDouble("price"));
          p.setStock(rs.getInt("stock"));
          p.setShippingIncluded(rs.getBoolean("shippingIncluded"));
          p.setDisabledOn(rs.getObject("disabledOn", ZonedDateTime.class));

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

  public void getById(Product product) {
    PreparedStatement stmt = null;
    ResultSet rs = null;

    try {
      stmt = DbConnector.getInstancia().getConn().prepareStatement(
          "select id, name, description, price, stock, shippingIncluded, disabledOn from product where id=?");
      stmt.setInt(1, product.getId());
      rs = stmt.executeQuery();

      if (rs != null && rs.next()) {
        product.setName(rs.getString("name"));
        product.setDescription(rs.getString("description"));
        product.setPrice(rs.getDouble("price"));
        product.setStock(rs.getInt("stock"));
        product.setShippingIncluded(rs.getBoolean("shippingIncluded"));
        product.setDisabledOn(rs.getObject("disabledOn", ZonedDateTime.class));
      } else {
        // If the product is not found, set its ID to -1 to indicate it doesn't exist
        product.setId(-1);
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
  }

  public void add(Product product) {
    PreparedStatement stmt = null;
    ResultSet rs = null;

    try {
      stmt = DbConnector.getInstancia().getConn().prepareStatement(
          "insert into product (name, description, price, stock, shippingIncluded, disabledOn) values (?, ?, ?, ?, ?, ?)",
          PreparedStatement.RETURN_GENERATED_KEYS);

      stmt.setString(1, product.getName());
      stmt.setString(2, product.getDescription());
      stmt.setDouble(3, product.getPrice());
      stmt.setInt(4, product.getStock());
      stmt.setBoolean(5, product.isShippingIncluded());
      stmt.setObject(6, product.getDisabledOn());
      stmt.executeUpdate();

      rs = stmt.getGeneratedKeys();
      if (rs != null && rs.next()) {
        product.setId(rs.getInt(1));
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
  }

  public void delete(Product product) {
    PreparedStatement stmt = null;

    try {
      this.getById(product);

      stmt = DbConnector.getInstancia().getConn().prepareStatement("delete from product where id=?");
      stmt.setInt(1, product.getId());
      stmt.executeUpdate();

    } catch (SQLException e) {
      e.printStackTrace();

    } finally {
      try {
        if (stmt != null) {
          stmt.close();
        }
        DbConnector.getInstancia().releaseConn();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }

  public void update(Product product) {
    PreparedStatement stmt = null;

    try {
      stmt = DbConnector.getInstancia().getConn().prepareStatement(
          "update product set name=?, description=?, price=?, stock=?, shippingIncluded=?, disabledOn=? where id=?");

      stmt.setString(1, product.getName());
      stmt.setString(2, product.getDescription());
      stmt.setDouble(3, product.getPrice());
      stmt.setInt(4, product.getStock());
      stmt.setBoolean(5, product.isShippingIncluded());
      stmt.setObject(6, product.getDisabledOn());
      stmt.setInt(7, product.getId());
      stmt.executeUpdate();

    } catch (SQLException e) {
      e.printStackTrace();

    } finally {
      try {
        if (stmt != null) {
          stmt.close();
        }
        DbConnector.getInstancia().releaseConn();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }
}
