package ejercicio6a.logic;

import java.util.LinkedList;

import ejercicio6a.data.DataProduct;
import ejercicio6a.entities.Product;

public class List {
  private DataProduct dataProduct;

  public List() {
    dataProduct = new DataProduct();
  }

  public LinkedList<Product> getAll() {
    return dataProduct.getAll();
  }

}
