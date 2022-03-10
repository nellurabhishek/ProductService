package com.project.package2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.package2.entity.Product;
import com.project.package2.exception.ProductNotFoundException;
import com.project.package2.model.ProductModel;
import com.project.package2.repository.ProductRepository;
import com.project.package2.util.Conversion;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	
	/******************************************
	 - Method Name      : addProduct
	 - Input Parameters : ProductModel productModel
	 - Return type      : newProduct
	 - Author           : Nellur Abhishek Hanamantrao
	 - Creation Date    : 06-03-2022
	 - Description      : Inserting the product entered by admin  into  the database.
	  ******************************************/
	
	
	

	@Override
	public ProductModel addProduct(ProductModel productModel) {

		if (productModel.getDuration() < 5) {

			double a = (productModel.getProductPrice() * 5.5 / 100);
			productModel.setMaturityAmount(a + productModel.getProductPrice());
			productModel.setInterestRate(5.5);

		} else if (productModel.getDuration() > 5 && productModel.getDuration() <= 10) {
			double a = (productModel.getProductPrice() * 6.5/ 100);
			productModel.setMaturityAmount(a + productModel.getProductPrice());
			productModel.setInterestRate(6.5);

		} else if (productModel.getProductPrice() > 10 && productModel.getDuration() < 20) {
			double a = (productModel.getProductPrice() * 9/ 100);
			productModel.setMaturityAmount(a + productModel.getProductPrice());
			productModel.setInterestRate(9);

		}

		Product newProduct = productRepository.save(Conversion.modelToEntity(productModel));
		return Conversion.entityToModel(newProduct);
	}
	
	
	/******************************************
	 - Method Name      : updateProduct
	 - Input Parameters : ProductModel productModel
	 - Return type      : updateProduct
	 - Author           : Nellur Abhishek Hanamantrao
	 - Creation Date    : 06-03-2022
	 - Description      : Inserting the product entered by admin  into  the database.
	  ******************************************/

	@Override
	public ProductModel updateProduct(ProductModel productModel) {
		Optional<Product> updatedProduct = productRepository.findById(productModel.getProductId());
		if (updatedProduct.isEmpty()) {
			throw new ProductNotFoundException(
					"The Product Is Not Available,Add The Product With Id: " + productModel.getProductId());
		}
		Product updateProduct = productRepository.save(Conversion.modelToEntity(productModel));
		return Conversion.entityToModel(updateProduct);
	}
	
	

	@Override
	public String deleteProduct(int productId) {
		Optional<Product> updatedProduct = productRepository.findById(productId);
		if (updatedProduct.isEmpty()) {
			throw new ProductNotFoundException("The Product Is Not Available With Id: " + productId);
		}
		productRepository.deleteById(productId);
		return "Product Deleted Successfully";
	}

	@Override
	public ProductModel viewProduct(int productId) {
		Optional<Product> optionalProduct = productRepository.findById(productId);
		if (!optionalProduct.isPresent()) {
			throw new ProductNotFoundException("Sorry! Product is not existing with id: " + productId);
		}

		return Conversion.entityToModel(optionalProduct.get());
	
	}
	

	@Override
	public ProductModel getProductById(int productId) {
		Optional<Product> optionalProduct = productRepository.findById(productId);
		if (!optionalProduct.isPresent()) {
			throw new ProductNotFoundException("Sorry! Product is not existing with id: " + productId);
		}

		return Conversion.entityToModel(optionalProduct.get());
	
	}


	@Override
	public List<Product> getAllProducts() {
		
		List<Product> products =productRepository.findAll();	
		return products;
	}



}
