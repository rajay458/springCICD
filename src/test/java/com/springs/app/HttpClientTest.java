package com.springs.app;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springs.app.controllers.Product;
import com.springs.app.controllers.ProductController;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("local")
@AutoConfigureWebTestClient
public class HttpClientTest {
	
	@Autowired
	private WebTestClient webTestClient;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	protected WebTestClient.BodyContentSpec getRequest(WebTestClient wt, String uri) {
		return wt
				.get()
				.uri(uri)
				.exchange()
				//then
				.expectStatus().isOk()
				.expectBody();
	}
	
	public static void setRequestContext() {
		MockHttpSession session = new MockHttpSession();
		MockHttpServletRequest request = new MockHttpServletRequest();
		request.setSession(session);
		ServletRequestAttributes requestAttributes = new ServletRequestAttributes(request);
		RequestContextHolder.setRequestAttributes(requestAttributes);
	}

	@Test
	public void get() {
		setRequestContext();
		String resp = getRequest(this.webTestClient, "/products").toString();
		System.out.println(resp);
		
	}

}
