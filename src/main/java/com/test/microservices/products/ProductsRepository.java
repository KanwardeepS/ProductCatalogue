package com.test.microservices.products;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductsRepository extends JpaRepository<Product, Long> {

	@Query("SELECT count(*) from Product")
	public int countProducts();
	public List<Product> findByType(String productType);
	public List<Product> findByName(String productName);
	public List<Product> findByPrice( BigDecimal p_productPrice );
	public List<Product> findByBrand( String p_productBrand );
	public List<Product> findByColor( String p_productColor );
	public List<Product> findBySize( String p_productSize );
	public List<Product> findBySku( String p_productSku );
	public List<Product> findBySellerid( String p_sellerid );
}
