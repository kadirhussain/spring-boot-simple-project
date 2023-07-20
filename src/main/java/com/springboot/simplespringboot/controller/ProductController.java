package com.springboot.simplespringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.simplespringboot.dto.Product;
import com.springboot.simplespringboot.response.ResponseStructure;
import com.springboot.simplespringboot.service.ProductService;

@RestController
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "/getMyData")
	public String getData() {
		
		return "Good morning India";
	}

	/*
	 * insertProduct Method
	 */
	@PostMapping(value = "/insertProduct")
	public Product insertProduct (@RequestBody Product product) {
		
		return productService.insertProduct(product);
	}
	
	/*
	 * insertMultipleProduct Method
	 */
	@PostMapping(value = "/insertMultipaleProduct")
	public List<Product> insertMultipleProduct (@RequestBody List<Product> products){
		return productService.insertMultipleProduct(products);
	}
	
	/*
	 * deleteProduct
	 */
	@DeleteMapping(value = "/deleteProduct/{productId}")
	public ResponseStructure<Product> deleteProductByIdProduct(@PathVariable int productId) {
		return productService.deleteProductByIdProduct(productId);
		
	}
	/*
	 *getProductById 
	 */
	@GetMapping(value = "/getProductById/{productId}")
	public ResponseStructure<Product> getProductById (@PathVariable int productId) {
		return productService.getProductById(productId);
	}
	@GetMapping(value = "/getAllProduct")
	public List<Product> getAllProduct(){
		return productService.getAllProduct();
	}
	
	 /*
	  * updateById
	  */
	@PutMapping(value = "updateProductById")
	 public Product updateProductById(@RequestBody Product product) {
		 return productService.updateProductById(product);
	 }
}
