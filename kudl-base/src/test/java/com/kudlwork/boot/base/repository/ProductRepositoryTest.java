package com.kudlwork.boot.base.repository;

import com.kudlwork.boot.base.model.Product;
import com.kudlwork.boot.base.model.ProductDetail;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ProductRepositoryTest {

	@Autowired
	private ProductRepository productRepository;

	@Test
	public void productFindTest() {
		List<Product> productList = productRepository.findAll();

		assertThat(productList.size()).isNotNull();
	}

	@Test
	public void findAllProductDetailTest() {
		List<ProductDetail> productDetails = productRepository.findAllProductDetail();

		assertThat(productDetails.size()).isNotNull();
	}
}
