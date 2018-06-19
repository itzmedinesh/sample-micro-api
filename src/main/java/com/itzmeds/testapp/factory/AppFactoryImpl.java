package com.itzmeds.testapp.factory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.itzmeds.mac.core.service.AbstractFactory;
import com.itzmeds.testapp.AppConfiguration;
import com.itzmeds.testapp.event.PriceListResource;
import com.itzmeds.testapp.event.ProductListResource;
import com.itzmeds.testapp.filters.TestFilter;
import com.itzmeds.testapp.filters.TestFilter2;

@Configuration
public class AppFactoryImpl extends AbstractFactory<AppConfiguration> {

	@Bean
	public ProductListResource getProductResource() {
		return new ProductListResource();
	}

	@Bean
	public PriceListResource getPriceResource() {
		return new PriceListResource();
	}

	@Bean
	public TestFilter getTestFilter() {
		return new TestFilter();
	}
	
	@Bean
	public TestFilter2 getTestFilter2() {
		return new TestFilter2();
	}

}
