package com.kudlwork.boot.base.model;

public class ProductDetail {

	private Long id;
	private String name;
	private String content;
	private String itemName;

	public ProductDetail(Long id, String name, String content, String itemName) {
		this.id = id;
		this.name = name;
		this.content = content;
		this.itemName = itemName;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getContent() {
		return content;
	}

	public String getItemName() {
		return itemName;
	}
}
