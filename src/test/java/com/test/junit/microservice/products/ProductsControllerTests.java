package com.test.junit.microservice.products;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.test.microservices.products.Product;
import com.test.microservices.products.ProductsController;
import com.test.microservices.products.ProductsRepository;

public class ProductsControllerTests {

	protected static final String PRODUCT_NAME_1 = "Torn";
	protected static final String PRODUCT_TYPE_1 = "Jeans";
	protected static final String PRODUCT_BRAND_1 = "Arrow";
	protected static final String PRODUCT_COLOR_1 = "Black";
	protected static final String PRODUCT_SIZE_1 = "XL";
	protected static final BigDecimal PRODUCT_PRICE_1 = new BigDecimal( 1500 );
	protected static final String PRODUCT_SKU_1 = "321212";
	protected static final String PRODUCT_SELLERID_1 = "1";
	protected static final Product theProduct = new Product( PRODUCT_NAME_1,
															 PRODUCT_TYPE_1,
															 PRODUCT_PRICE_1,
															 PRODUCT_BRAND_1,
															 PRODUCT_COLOR_1,
															 PRODUCT_SIZE_1,
															 PRODUCT_SKU_1,PRODUCT_SELLERID_1 );

	@Autowired
	ProductsController productsController;

	protected TestProductsRepository testRepo = new TestProductsRepository();

	@Test
	public void validProductName() {
		List<Product> product = productsController.findByName( theProduct.getName() );
		Assert.assertNotNull( product );
		Assert.assertEquals( PRODUCT_NAME_1, product.get( 0 ).getName() );
	}
	
	
	@Test
	public void validProductType() {
		List<Product> product = productsController.byType( theProduct.getType() );
		Assert.assertNotNull( product );
		Assert.assertEquals( PRODUCT_TYPE_1, product.get( 0 ).getType() );
	}
	
	@Test
	public void validProductColor() {
		List<Product> product = productsController.byColor( theProduct.getColor() );
		Assert.assertNotNull( product );
		Assert.assertEquals( PRODUCT_COLOR_1, product.get( 0 ).getColor() );
	}
	
	@Test
	public void validProductPrice() {
		List<Product> product = productsController.byPrice( theProduct.getPrice().toString() );
		Assert.assertNotNull( product );
		Assert.assertEquals( PRODUCT_PRICE_1, product.get( 0 ).getPrice() );
	}
	
	@Test
	public void validProductSize() {
		List<Product> product = productsController.bySize( theProduct.getSize() );
		Assert.assertNotNull( product );
		Assert.assertEquals( PRODUCT_SIZE_1, product.get( 0 ).getSize() );
	}
	
	@Test
	public void validProductSku() {
		List<Product> product = productsController.bySku( theProduct.getSku() );
		Assert.assertNotNull( product );
		Assert.assertEquals( PRODUCT_SKU_1, product.get( 0 ).getSku() );
	}
	
	@Test
	public void validProductCountBySellerId() {
		Integer count = productsController.productCountBySeller( theProduct.getSellerId() );
		Assert.assertNotNull( count );
	}


	@Before
	public void setup() {
		productsController = new ProductsController( testRepo );
	}

	protected static class TestProductsRepository implements ProductsRepository {

		@Override
		public List<Product> findByType( String productType ) {
			if ( productType.equals( PRODUCT_TYPE_1 ) ) {
				List<Product> productList = new ArrayList<Product>();
				productList.add( theProduct );
				return productList;
			}
			else {
				return null;
			}
		}

		@Override
		public List<Product> findByName( String productName ) {
			List<Product> products = new ArrayList<Product>();
			if ( PRODUCT_NAME_1.toLowerCase().indexOf( productName.toLowerCase() ) != -1 )
				products.add( theProduct );
			else
				return null;

			return products;
		}

		@Override
		public List<Product> findByPrice( BigDecimal p_productPrice ) {
			if ( p_productPrice.equals( PRODUCT_PRICE_1 ) ) {
				List<Product> productList = new ArrayList<Product>();
				productList.add( theProduct );
				return productList;
			}
			else {
				return null;
			}
		}

		@Override
		public List<Product> findByBrand( String p_productBrand ) {
			if ( p_productBrand.equals( PRODUCT_BRAND_1 ) ) {
				List<Product> productList = new ArrayList<Product>();
				productList.add( theProduct );
				return productList;
			}
			else {
				return null;
			}
		}

		@Override
		public List<Product> findByColor( String p_productColor ) {
			if ( p_productColor.equals( PRODUCT_COLOR_1 ) ) {
				List<Product> productList = new ArrayList<Product>();
				productList.add( theProduct );
				return productList;
			}
			else {
				return null;
			}
		}

		@Override
		public List<Product> findBySize( String p_productSize ) {
			if ( p_productSize.equals( PRODUCT_SIZE_1 ) ) {
				List<Product> productList = new ArrayList<Product>();
				productList.add( theProduct );
				return productList;
			}
			else {
				return null;
			}
		}

		@Override
		public List<Product> findBySku( String p_productSku ) {
			if ( p_productSku.equals( PRODUCT_SKU_1 ) ) {
				List<Product> productList = new ArrayList<Product>();
				productList.add( theProduct );
				return productList;
			}
			else {
				return null;
			}
		}
		
		
		@Override
		public List<Product>  findBySellerid( String p_sellerid ) {
			if ( p_sellerid.equals( PRODUCT_SELLERID_1 ) ) {
				List<Product> productList = new ArrayList<Product>();
				productList.add( theProduct );
				return productList;
			}
			else {
				return null;
			}
		}

		@Override
		public void deleteAllInBatch() {
			// TODO Auto-generated method stub

		}

		@Override
		public void deleteInBatch( Iterable<Product> arg0 ) {
			// TODO Auto-generated method stub

		}

		@Override
		public List<Product> findAll() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<Product> findAll( Sort arg0 ) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<Product> findAll( Iterable<Long> arg0 ) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void flush() {
			// TODO Auto-generated method stub

		}

		@Override
		public Product getOne( Long arg0 ) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <S extends Product> List<S> save( Iterable<S> arg0 ) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <S extends Product> S saveAndFlush( S arg0 ) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Page<Product> findAll( Pageable pageable ) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <S extends Product> S save( S entity ) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Product findOne( Long id ) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean exists( Long id ) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public long count() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public void delete( Long id ) {
			// TODO Auto-generated method stub

		}

		@Override
		public void delete( Product entity ) {
			// TODO Auto-generated method stub

		}

		@Override
		public void delete( Iterable<? extends Product> entities ) {
			// TODO Auto-generated method stub

		}

		@Override
		public void deleteAll() {
			// TODO Auto-generated method stub

		}

		@Override
		public int countProducts() {
			// TODO Auto-generated method stub
			return 0;
		}

		

	}

}
