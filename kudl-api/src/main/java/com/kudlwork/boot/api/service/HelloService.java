package com.kudlwork.boot.api.service;

import com.kudlwork.boot.base.model.ProductDetail;
import com.kudlwork.boot.base.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HelloService {

	public final ProductRepository productRepository;

	public List<ProductDetail> findAllProductDetail() {
		return productRepository.findAllProductDetail();
	}
}
