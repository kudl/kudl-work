package com.kudlwork.boot.base.repository;

import com.kudlwork.boot.base.model.ProductItem;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ProductItemRepositoryTest {

	@Autowired
	private ProductItemRepository productItemRepository;

	@Test
	public void productItemFindTest() {
		List<ProductItem> productItems = productItemRepository.findAll();

		assertThat(productItems.size()).isNotNull();
	}
}
