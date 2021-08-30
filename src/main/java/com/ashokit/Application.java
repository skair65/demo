package com.ashokit;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.ashokit.beans.csvReader;
import com.ashokit.model.Product;

@SpringBootApplication
public class Application {

	public static void main(String[] args) throws Exception {
		ConfigurableApplicationContext ctxt = SpringApplication.run(Application.class, args);
		csvReader csvReader = ctxt.getBean(csvReader.class);
		List<Product> filterProducts = csvReader.redAndFilterProductsData();
		
		/*
		 * for(product p : filterProducts) 
		 * { System.out.println();
		 * }
		 */
		
		filterProducts.forEach(System.out::println);
		
	}

}
