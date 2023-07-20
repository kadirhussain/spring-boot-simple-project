package com.springboot.simplespringboot.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.springboot.simplespringboot.dao.ProductDao;
import com.springboot.simplespringboot.dto.Product;
import com.springboot.simplespringboot.response.ResponseStructure;

@Service
public class ProductService {
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private ResponseStructure<Product> responseStructure;
	
	/*
	 * insertProduct Method
	 */
	public Product insertProduct (Product product) {
		
		if(product.getProductPrice() <= 40000) {
			return productDao.insertProduct(product);
		}else {
			return null;
		}
	}
	
	/*
	 * insertMultipleProduct Method
	 */
	public List<Product> insertMultipleProduct (List<Product> products){
		
		List<Product> products2= new ArrayList<>();
		
		for (Product product : products) {
			if(product.getProductPrice()<=40000) {
				products2.add(product);
			}
		}
		return productDao.insertMultipleProduct(products2);
	}
	
	/*
	 * deleteProduct
	 */
	
	public ResponseStructure<Product> deleteProductByIdProduct(int productId) {
		Product product=productDao.getProductById(productId);
		
		if(product!=null) {
		    productDao.deleteProductByIdProduct(productId);
		    responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
			responseStructure.setDateTime(LocalDateTime.now());
			responseStructure.setStatusMessage("data deleted success");
			responseStructure.setDescription("com.springboot.simplespringboot.dto.Product");
			responseStructure.setData(product);  
		}else {
			responseStructure.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
			responseStructure.setDateTime(LocalDateTime.now());
			responseStructure.setStatusMessage("given id is not persent");
			responseStructure.setDescription("com.springboot.simplespringboot.dto.Product");
			responseStructure.setData(product);
		}
		return responseStructure;
		
	}
	/*
	 * getProductById
	 */
	public ResponseStructure<Product> getProductById (int productId) {
		Product product= productDao.getProductById(productId);
		
		if(product!=null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setDateTime(LocalDateTime.now());
			responseStructure.setStatusMessage("success");
			responseStructure.setDescription("com.springboot.simplespringboot.dto.Product");
			responseStructure.setData(product);
		}else {
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setDateTime(LocalDateTime.now());
			responseStructure.setStatusMessage("given id is not persent");
			responseStructure.setDescription("com.springboot.simplespringboot.dto.Product");
			responseStructure.setData(product);
		}
		return responseStructure;
	}
	
	/*
	 * getAllProduct
	 */
	
	public List<Product> getAllProduct(){
		return productDao.getAllProduct();
	}
	
	 /*
	  * updateProductById
	  */
	 
	 public Product updateProductById(Product product) {
		 return productDao.updateProductById(product);
		 
	 }
	 
	 
}
