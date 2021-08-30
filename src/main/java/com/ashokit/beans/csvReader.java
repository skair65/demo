package com.ashokit.beans;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ashokit.model.Product;

@Service
public class csvReader {
	
	private IDataFilter dataFilter;
	
	public csvReader(IDataFilter dataFilter) {
		this.dataFilter = dataFilter;
	}
	
	public List<Product> redAndFilterProductsData() throws Exception{
		
		
		  List<Product> plist = new ArrayList<Product>();
		  
		  FileReader fr = new FileReader(new File("products.txt"));
		  
		  BufferedReader br = new BufferedReader(fr);
		  
		  String lineData = br.readLine();
		 
		
		while (lineData != null) {
			String[] split = lineData.split(",");
			String pid = split[0];
			String name = split[1];
			String price = split[2];
			
			Product p = new Product();
			p.setProductId(Integer.parseInt(pid));
			p.setProductName(name);
			p.setProductPrice(Double.parseDouble(price));
			
			plist.add(p);
			
			lineData = br.readLine();	
		}
		
		br.close();
		
		return dataFilter.filterProducts(plist);
				
	}

}
