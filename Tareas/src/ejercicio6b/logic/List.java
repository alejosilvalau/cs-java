package ejercicio6b.logic;

import java.util.LinkedList;

import ejercicio6b.data.DataProduct;
import ejercicio6b.entities.Product;

public class List {
  private DataProduct dataProduct;

  public List() {
    dataProduct = new DataProduct();
  }

  public LinkedList<Product> getAll() {
    return dataProduct.getAll();
  }

}
