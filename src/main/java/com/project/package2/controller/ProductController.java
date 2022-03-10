package com.project.package2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.package2.entity.Product;
import com.project.package2.model.ProductModel;
import com.project.package2.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping("/newproduct")
	public ResponseEntity<ProductModel> newProduct(@RequestBody ProductModel productModel) {

		ProductModel newProductModel = productService.addProduct(productModel);

		ResponseEntity<ProductModel> responseEntity = new ResponseEntity<>(newProductModel, HttpStatus.CREATED);
		return responseEntity;

	}

	@PostMapping("/updateproduct")
	public ResponseEntity<ProductModel> updatedProduct(@RequestBody ProductModel productModel) {

		ProductModel updatedProductModel = productService.addProduct(productModel);

		ResponseEntity<ProductModel> responseEntity = new ResponseEntity<ProductModel>(updatedProductModel,
				HttpStatus.CREATED);
		return responseEntity;
	}

	
	

	@GetMapping("/delete/{pid}")
	public ResponseEntity<?> deletedProduct(@PathVariable("pid") int productId) {

		productService.deleteProduct(productId);
		return new ResponseEntity<>("Customer Deleted with id: " + productId, HttpStatus.OK);

	}

	@GetMapping("/view/{pid}")
	public ResponseEntity<?> viewAllProduct(@PathVariable("pid") int productId) {
		ProductModel productModel = productService.viewProduct(productId);
		return new ResponseEntity<>(productModel, HttpStatus.OK);

	}
	@GetMapping("/viewAllProducts")
	public List<Product> viewAllProducts() {
		
		List<Product> products = productService.getAllProducts();
		
		return products;
	}

	

}
