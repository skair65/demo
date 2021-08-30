package com.ashokit.beans;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.ashokit.model.Product;

@Component
public class DataFilterImpl implements IDataFilter {

	@Override
	public List<Product> filterProducts(List<Product> productsList) {
		
		return productsList.stream().filter(p -> p.getProductPrice() >= 5000.00).collect(Collectors.toList());
	}

}
