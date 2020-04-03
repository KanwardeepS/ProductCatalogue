package com.test.microservices.products;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCT")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;
	public static Long nextId = 0L;

	public Product() {
		super();
	}

	@Id
	protected Long id;

	public Product( String p_name, String p_type, BigDecimal p_price, String p_brand, String p_color, String p_size, String p_sku,
					String p_sellerid ) {
		super();
		id = getNextId();
		name = p_name;
		type = p_type;
		price = p_price;
		brand = p_brand;
		color = p_color;
		size = p_size;
		sku = p_sku;
		sellerid = p_sellerid;
	}
	
	public Product(String p_productName1, String p_productType1, BigDecimal p_productPrice1, String p_productBrand1, String p_productColor1, String p_productSize1, String p_productSku1) {
		super();
		id = getNextId();
		name = p_productName1;
		type = p_productType1;
		price = p_productPrice1;
		brand = p_productBrand1;
		color = p_productColor1;
		size = p_productSize1;
		sku = p_productSku1;
	}

	@Column(name = "name")
	protected String name;
	
	@Column(name = "type") // category
	protected String type;
	
	@Column(name = "price")
	protected BigDecimal price;
	
	@Column(name = "brand")
	protected String brand;
	
	@Column(name = "color")
	protected String color;
	
	@Column(name = "size")
	protected String size;
	
	@Column(name = "sku")
	protected String sku;
	
	@Column(name = "sellerid")
	protected String sellerid;
	
	protected static Long getNextId() {
		synchronized (nextId) {
			return nextId++;
		}
	}

	public long getId() {
		return id;
	}
	
	protected void setId(long id) {
		this.id = id;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	
	public String getBrand() {
		return brand;
	}

	
	public void setBrand( String p_brand ) {
		brand = p_brand;
	}

	
	public String getColor() {
		return color;
	}

	
	public void setColor( String p_color ) {
		color = p_color;
	}

	
	public String getSize() {
		return size;
	}

	
	public void setSize( String p_size ) {
		size = p_size;
	}

	
	public String getSku() {
		return sku;
	}

	
	public void setSku( String p_sku ) {
		sku = p_sku;
	}

	
	public String getSellerId() {
		return sellerid;
	}

	
	public void setSellerId( String p_sellerId ) {
		sellerid = p_sellerId;
	}
	

	@Override
	public String toString() {
		return "Product [name=" + name + ", type=" + type + ", price=" + price + ", brand=" + brand + ", color=" + color + ", size=" + size +
			   ", sku=" + sku + ", sellerid=" + sellerid + "]";
	}

}
