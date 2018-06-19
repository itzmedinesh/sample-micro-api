package com.itzmeds.testapp.resource;

import static org.junit.Assert.assertEquals;

import javax.inject.Inject;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.itzmeds.testapp.TestConfigInitializer;
import com.itzmeds.testapp.TestConfiguration;
import com.itzmeds.testapp.factory.AppFactoryTest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {
		AppFactoryTest.class }, loader = AnnotationConfigContextLoader.class, initializers = TestConfigInitializer.class)
public class TestApiTest extends JerseyTest {

	private static final Logger LOGGER = LogManager.getLogger(TestApiTest.class);

	@Inject
	TestConfiguration testConfiguration;

	@Override
	protected Application configure() {
		ResourceConfig resourceConfig = new ResourceConfig();
		resourceConfig.registerClasses(TestApi.class);
		return resourceConfig;
	}

	@Test
	public void testGetMsg() {
		Response output = target("/test/hello").request().get();

		LOGGER.info(testConfiguration.getServiceConfig().getName());

		assertEquals(true, output.readEntity(String.class).contains("\"message\":\"hello\""));
	}

}
