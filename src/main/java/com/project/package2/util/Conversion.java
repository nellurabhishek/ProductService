package com.project.package2.util;

import com.project.package2.entity.Product;
import com.project.package2.model.ProductModel;

public class Conversion {
	
	public static ProductModel entityToModel(Product product) {
		
		ProductModel productModel =new ProductModel();
		
		productModel.setProductId(product.getProductId());
		productModel.setProductName(product.getProductName());
		productModel.setProductPrice(product.getProductPrice());
		productModel.setCreatedOn(product.getCreatedOn());
		productModel.setDescription(product.getDescription());
		productModel.setDuration(product.getDuration());
		productModel.setInterestRate(product.getInterestRate());
		productModel.setMaturityAmount(product.getMaturityAmount());
		productModel.setPremiumType(product.getPremiumType());
		
		return productModel;
	
	}
public static Product modelToEntity(ProductModel productModel) {
		
		Product product =new Product();
		
		product.setProductId(productModel.getProductId());
		product.setProductName(productModel.getProductName());
		product.setProductPrice(productModel.getProductPrice());
		product.setCreatedOn(productModel.getCreatedOn());
		product.setDescription(productModel.getDescription());
		product.setDuration(productModel.getDuration());
		product.setInterestRate(productModel.getInterestRate());
		product.setMaturityAmount(productModel.getMaturityAmount());
		product.setPremiumType(productModel.getPremiumType());
		
		
		return product;
}

}
