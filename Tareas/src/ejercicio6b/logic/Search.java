package ejercicio6b.logic;

import ejercicio6b.data.DataProduct;
import ejercicio6b.entities.Product;

public class Search {
	private DataProduct dataProduct;

	public Search() {
		dataProduct = new DataProduct();
	}

	public void getById(Product product) {
		dataProduct.getById(product);
	}

}
