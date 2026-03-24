package ejercicio6b.logic;

import ejercicio6b.data.DataProduct;
import ejercicio6b.entities.Product;

public class Add {
	private DataProduct dataProduct;

	public Add() {
		dataProduct = new DataProduct();
	}

	public void add(Product product) {
		dataProduct.add(product);
	}

}
