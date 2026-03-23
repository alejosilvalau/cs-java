package ejercicio6a.logic;

import ejercicio6a.data.DataProduct;
import ejercicio6a.entities.Product;

public class Delete {
  private DataProduct dataProduct;

  public Delete() {
    dataProduct = new DataProduct();
  }

  public void delete(Product product) {
    dataProduct.delete(product);
  }
}
