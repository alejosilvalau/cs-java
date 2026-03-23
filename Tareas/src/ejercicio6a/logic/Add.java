package ejercicio6a.logic;

import ejercicio6a.data.DataProduct;
import ejercicio6a.entities.Product;

public class Add {
  private DataProduct dataProduct;

  public Add() {
    dataProduct = new DataProduct();
  }

  public void add(Product product) {
    dataProduct.add(product);
  }

}
