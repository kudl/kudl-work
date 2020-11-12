package com.kudlwork.boot.base.repository;

import com.kudlwork.boot.base.model.ProductDetail;

import java.util.List;

public interface ProductRepositoryCustom {
	List<ProductDetail> findAllProductDetail();
}
