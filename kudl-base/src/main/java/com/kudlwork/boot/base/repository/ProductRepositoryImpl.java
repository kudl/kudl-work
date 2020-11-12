package com.kudlwork.boot.base.repository;

import com.kudlwork.boot.base.model.Product;
import com.kudlwork.boot.base.model.ProductDetail;
import com.querydsl.core.types.ConstructorExpression;
import com.querydsl.core.types.Projections;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

import static com.kudlwork.boot.base.model.QProduct.product;
import static com.kudlwork.boot.base.model.QProductItem.productItem;

public class ProductRepositoryImpl extends QuerydslRepositorySupport implements ProductRepositoryCustom {

	public ProductRepositoryImpl() {
		super(Product.class);
	}

	@Override
	public List<ProductDetail> findAllProductDetail() {

		return from(product)
				.leftJoin(productItem).on(product.id.eq(productItem.productId))
				.select(getProductDetailProjections())
				.fetch();
	}

	public ConstructorExpression<ProductDetail> getProductDetailProjections() {
		return Projections.constructor(ProductDetail.class,
				product.id, product.name, product.contents, productItem.name);
	}

}
