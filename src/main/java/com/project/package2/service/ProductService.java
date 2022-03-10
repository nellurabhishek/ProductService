package com.project.package2.service;


import java.util.List;

import com.project.package2.entity.Product;
import com.project.package2.model.ProductModel;

public interface ProductService {

	public ProductModel addProduct(ProductModel productModel);

	public ProductModel updateProduct(ProductModel productModel);

	public String deleteProduct(int productId);

	public ProductModel viewProduct(int productId);

	public ProductModel getProductById(int productId);

	 List<Product> getAllProducts();

	

	

	



}
