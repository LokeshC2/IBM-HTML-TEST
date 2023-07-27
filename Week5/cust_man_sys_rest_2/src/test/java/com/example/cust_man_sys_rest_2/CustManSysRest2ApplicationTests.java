package com.example.cust_man_sys_rest_2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class CustManSysRest2ApplicationTests {

	@Value("${local.server.port}")
	private int port;

	private String url;

	private HttpHeaders headers;

	@PostConstruct
	public void init() {
		url = "http://localhost:" + port + "/customers";
		System.out.println("port: " + port);
		System.out.println("url: " + url);
		headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");
		// headers.add("Accept", "*/*");
	}

	@Autowired
	private TestRestTemplate restTemplate;

	List<?> getCustomers() {
		return this.restTemplate.getForObject(url, List.class);
	}


	@Test
	void emptyCustomersTest() {
		String body = getCustomers().toString();
		assertEquals(body, "[]");
	}

	@Test
	void postTest() {
		HttpEntity<String> request = new HttpEntity<String>(
				"{\"firstName\":\"test\",\"lastName\":\"test\", \"email\":\"test\"}",
				headers);

		@SuppressWarnings("unchecked")
		Map<String, Object> response = this.restTemplate.postForObject(url, request, Map.class);

		assertEquals(response.get("firstName"), "test");
		assertEquals(response.get("lastName"), "test");
		assertEquals(response.get("email"), "test");
		assertTrue(response.containsKey("id"));
		assertNotNull(response.get("id"));

		List<?> customerList = getCustomers();
		assertEquals(customerList.size(), 1);

	}

	@Test
	void getById() {

	}
	
}
