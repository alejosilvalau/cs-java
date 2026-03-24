package ejercicio6b.logic;

import ejercicio6b.data.DataProduct;
import ejercicio6b.entities.Product;

public class Delete {
	private DataProduct dataProduct;

	public Delete() {
		dataProduct = new DataProduct();
	}

	public void delete(Product product) {
		dataProduct.delete(product);
	}
}
