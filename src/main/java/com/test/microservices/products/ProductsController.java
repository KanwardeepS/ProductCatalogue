package com.test.microservices.products;

import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.microservices.exceptions.RecordNotFoundException;

@RestController
public class ProductsController {

	protected Logger logger = Logger.getLogger(ProductsController.class
			.getName());
	protected ProductsRepository productRepository;

	@Autowired
	public ProductsController(ProductsRepository productRepository) {
		this.productRepository = productRepository;
		logger.info("ProductRepository says system has "
				+ productRepository.countProducts() + " products");
	}
	
	@RequestMapping(value="/products/create", method = RequestMethod.POST)
	public List<Product> createProduct(@RequestBody Product products) {
		logger.info("products-service createProduct() invoked: " + products);
		productRepository.save(new Product( products.getName(), products.getType(), products.getPrice(), products.getBrand(), products.getColor(), products.getSize(), products.getSku(), products.getSellerId()));
		return productRepository.findAll();
		
	}
	
	@RequestMapping(value="/products/delete/{productId}", method = RequestMethod.GET)
	public List<Product> deleteProduct(@PathVariable("productId") Long productId) {
		logger.info("products-service deleteProduct() invoked: " + productId);
		productRepository.delete(productId);
		return productRepository.findAll();	 
		 }
	

	@RequestMapping("/products/type/{productType}")
	public List<Product> byType(@PathVariable("productType") String productType) {

		logger.info("products-service byType() invoked: " + productType);
		List<Product> product  = productRepository.findByType(productType);
		logger.info("products-service byType() found: " + product);

		if (product == null)
			throw new RecordNotFoundException(productType);
		else {
			return product;
		}
	}
	
	@RequestMapping("/products/price/{productPrice}")
	public List<Product> byPrice(@PathVariable("productPrice") String productPrice) {
		BigDecimal priceVal = new BigDecimal(productPrice);
		logger.info("products-service byPrice() invoked: " + productPrice);
		List<Product> product  = productRepository.findByPrice(priceVal);
		logger.info("products-service byPrice() found: " + product);

		if (product == null)
			throw new RecordNotFoundException(productPrice);
		else {
			return product;
		}
	}
	
	
	@RequestMapping("/products/brand/{productBrand}")
	public List<Product> byBrand(@PathVariable("productBrand") String productBrand) {

		logger.info("products-service byBrand() invoked: " + productBrand);
		List<Product> product  = productRepository.findByBrand(productBrand);
		logger.info("products-service byBrand() found: " + product);

		if (product == null)
			throw new RecordNotFoundException(productBrand);
		else {
			return product;
		}
	}
	
	@RequestMapping("/products/color/{productColor}")
	public List<Product> byColor(@PathVariable("productColor") String productColor) {

		logger.info("products-service byColor() invoked: " + productColor);
		List<Product> product  = productRepository.findByColor(productColor);
		logger.info("products-service byColor() found: " + product);

		if (product == null)
			throw new RecordNotFoundException(productColor);
		else {
			return product;
		}
	}
	
	@RequestMapping("/products/size/{productSize}")
	public List<Product> bySize(@PathVariable("productSize") String productSize) {

		logger.info("products-service bySize() invoked: " + productSize);
		List<Product> product  = productRepository.findBySize(productSize);
		logger.info("products-service bySize() found: " + product);

		if (product == null)
			throw new RecordNotFoundException(productSize);
		else {
			return product;
		}
	}
	
	@RequestMapping("/products/sku/{productSku}")
	public List<Product> bySku(@PathVariable("productSku") String productSku) {

		logger.info("products-service bySku() invoked: " + productSku);
		List<Product> product  = productRepository.findBySku(productSku);
		logger.info("products-service bySku() found: " + product);

		if (product == null)
			throw new RecordNotFoundException(productSku);
		else {
			return product;
		}
	}
	
	
	
	//search product for productName
	@RequestMapping("/products/name/{productName}")
	public List<Product> findByName(@PathVariable("productName") String productName) {

		logger.info("products-service findByName() invoked: " + productName);
		//Product product = productRepository.findByType(productType);
		List<Product> product = productRepository.findByName(productName);
		logger.info("products-service findPriceByName() found: " + product);

		if (product == null)
			throw new RecordNotFoundException(productName);
		else {
			return product;
		}
	}
	
	
	//search product for productName
		@RequestMapping("/products/seller/{sellerid}")
		public Integer productCountBySeller(@PathVariable("sellerid") String sellerid) {

			logger.info("products-service productCountBySeller() invoked: " + sellerid);
			//Product product = productRepository.findByType(productType);
			List<Product> product = productRepository.findBySellerid(sellerid);
			logger.info("products-service findPriceByName() found: " + product);

			if (product == null)
				throw new RecordNotFoundException(sellerid);
			else {
				return product.size();
			}
		}
	
	

	

}