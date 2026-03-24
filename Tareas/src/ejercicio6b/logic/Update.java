package ejercicio6b.logic;

import ejercicio6b.data.DataProduct;
import ejercicio6b.entities.Product;

public class Update {
	private DataProduct dataProduct;

	public Update() {
		dataProduct = new DataProduct();
	}

	public void update(Product product) {
		dataProduct.update(product);
	}

}
