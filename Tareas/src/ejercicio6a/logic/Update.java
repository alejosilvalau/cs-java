package ejercicio6a.logic;

import ejercicio6a.data.DataProduct;
import ejercicio6a.entities.Product;

public class Update {
  private DataProduct dataProduct;

  public Update() {
    dataProduct = new DataProduct();
  }

  public void update(Product product) {
    dataProduct.update(product);
  }

}
