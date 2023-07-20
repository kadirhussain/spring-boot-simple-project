package com.springboot.simplespringboot.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Repository;

import com.springboot.simplespringboot.dto.Product;
import com.springboot.simplespringboot.repository.ProductRepository;

@Repository
public class ProductDao {
	
	@Autowired
	ProductRepository productRepository;
	
	/*
	 * insertProduct Method
	 */
	public Product insertProduct (Product product) {
		
		return productRepository.save(product);
	}
	/*
	 * insertMultipleProduct Method
	 */
	public List<Product> insertMultipleProduct (List<Product> products){
		return productRepository.saveAll(products);
	}
	 
	/*
	 * deleteProduct
	 */
	
	public void deleteProductByIdProduct(int productId) {
		Optional<Product> optional =productRepository.findById(productId);
		if(optional.isPresent()) {
			productRepository.delete(optional.get());
		}
	}
	
	/*
	 *getProductById 
	 */
	
	public Product getProductById (int productId) {
		
		Optional<Product> optional =productRepository.findById(productId);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
		
	}
	/*
	 * getAllProduct
	 */
    
	 public List<Product> getAllProduct(){
		 return productRepository.findAll();
	 }
	 
	 /*
	  * updateById
	  */
	 
	 public Product updateProductById(Product product) {
		 Product product2=getProductById(product.getProductId());
		 if(product2!=null) {
			 product2.setProductName(product.getProductName());
			 product2.setProductColor(product.getProductColor());
			 product2.setProductPrice(product.getProductPrice());
			 
			return  productRepository.save(product2);
		 }
		 return null;
	 }
}
