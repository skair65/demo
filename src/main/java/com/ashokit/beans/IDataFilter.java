package com.ashokit.beans;

import java.util.List;

import com.ashokit.model.Product;

public interface IDataFilter {
	
	
	public List<Product> filterProducts(List<Product> productsList);

}
