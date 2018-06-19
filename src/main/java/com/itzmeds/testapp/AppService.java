/**
 * 
 */
package com.itzmeds.testapp;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.itzmeds.mac.core.container.AbstractContainer;
import com.itzmeds.mac.core.container.ContainerContext;
import com.itzmeds.mac.core.service.FactoryList;
import com.itzmeds.mac.core.service.FilterType;
import com.itzmeds.mac.core.service.ResourceFilterList;
import com.itzmeds.mac.core.service.ResourceList;
import com.itzmeds.mac.core.service.WebsocketResourceList;
import com.itzmeds.mac.exception.ServiceInitializationException;
import com.itzmeds.testapp.event.PriceListResource;
import com.itzmeds.testapp.event.ProductListResource;
import com.itzmeds.testapp.factory.AppFactoryImpl;
import com.itzmeds.testapp.filters.TestFilter;
import com.itzmeds.testapp.filters.TestFilter2;
import com.itzmeds.testapp.resource.TestApi;

/**
 * @author itzmeds
 *
 */

public class AppService extends AbstractContainer<AppConfiguration> {

	private static final Logger LOGGER = LogManager.getLogger(AppService.class);

	public static void main(String[] args) throws Exception {
		new AppService().boot(args);
	}

	@Override
	public void initialize(AppConfiguration configuration, ContainerContext containerCtx)
			throws com.itzmeds.mac.exception.ServiceInitializationException {
		containerCtx.setSwaggerAssets("/swaggerui");
	}

	@Override
	public ResourceList getRestResourceList() throws ServiceInitializationException {
		return new ResourceList(TestApi.class);
	}

	@Override
	public FactoryList getServiceFactoryList() throws ServiceInitializationException {
		return new FactoryList(AppFactoryImpl.class);
	}

	@Override
	public WebsocketResourceList getWebsocketResourceList() throws ServiceInitializationException {
		return new WebsocketResourceList(ProductListResource.class, PriceListResource.class);
	}

	@Override
	protected void preInitialize(AppConfiguration processContainerCfg) throws ServiceInitializationException {
		LOGGER.info("-----------Starting Server-------------");
	}

	@Override
	protected void postInitialize(AppConfiguration processContainerCfg) throws ServiceInitializationException {
		LOGGER.info("----------Server Started---------------");
	}

	@Override
	public ResourceFilterList getWebResourceFilterList() throws ServiceInitializationException {
		return new ResourceFilterList(new FilterType<TestFilter2>(TestFilter2.class, "/test/*"),
				new FilterType<TestFilter>(TestFilter.class, "/test/*"));
	}

}
