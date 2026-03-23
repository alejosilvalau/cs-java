package ejercicio6a.logic;

import ejercicio6a.data.DataProduct;
import ejercicio6a.entities.Product;

public class Search {
  private DataProduct dataProduct;

  public Search() {
    dataProduct = new DataProduct();
  }

  public Product getById(Product product) {
    return dataProduct.getById(product);
  }

}
