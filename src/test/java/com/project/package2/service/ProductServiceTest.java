package com.project.package2.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.package2.entity.Product;
import com.project.package2.exception.ProductNotFoundException;
import com.project.package2.model.ProductModel;
import com.project.package2.repository.ProductRepository;


@SpringBootTest
public class ProductServiceTest {
	
	@InjectMocks
	private ProductService productService = new ProductServiceImpl();
	
	@Mock
	private ProductRepository productRepository;
	
	
	
	@Test
	public void testGetProductById() {
		
		Product product = new Product();
		product.setProductId(1);
		product.setProductName("Jeevan Anand");
		product.setProductPrice(100000);
		product.setCreatedOn(LocalDate.of(2021, 03, 01));
		product.setInterestRate(7);
		product.setDuration(10);
		product.setDescription("LIC New Jeevan Anand is a participating non linked life insurance policy that offers the double benefit of protection and savings.");
		product.setPremiumType("7");
		product.setMaturityAmount(107000);
		
		Optional<Product> optionalProduct = Optional.of(product);
		int productId = 1 ;
		
        when(productRepository.findById(1)).thenReturn(optionalProduct);
		
		ProductModel existingProduct = productService.getProductById(productId);
		
		assertEquals(product.getProductId(),existingProduct.getProductId());
		
	}
	
	@Test
	public void testGetProductByIdNotFound() {
		
		int productId = 5;
		when(productRepository.findById(productId)).thenThrow(ProductNotFoundException.class);
		assertThrows(ProductNotFoundException.class,()->productService.getProductById(productId));
		
		
	}
	
		
   
	
	
	
	@Test
	public void deleteProductById() {
		
		int productId =3;
		
		Product product = new Product();
		product.setProductId(3);
		product.setProductName("Jeevan Anand");
		product.setProductPrice(100000);
		product.setCreatedOn(LocalDate.of(2021, 03, 01));
		product.setInterestRate(7);
		product.setDuration(10);
		product.setDescription("LIC New Jeevan Anand is a participating non linked life insurance policy that offers the double benefit of protection and savings.");
		product.setPremiumType("7");
		
        Optional<Product> optionalProduct = Optional.of(product);
		
		when(productRepository.findById(productId)).thenReturn(optionalProduct);

		
		productService.deleteProduct(product.getProductId());
		
		verify(productRepository,times(1)).deleteById(productId);
		
		doNothing().when(productRepository).deleteById(product.getProductId());
		
		
	}
	
}
		



