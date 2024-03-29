package com.vmware.orderservice;

//OrderPlacementTest.java
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

//import org.springframework.boot.web.server.LocalServerPort;
import static org.assertj.core.api.Assertions.assertThat;

import com.vmware.orderservice.model.OnlineOrder;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OrderPlacementTest {

 /*@LocalServerPort
 private int port;
 */


String port = "8083";

 @Autowired
 private TestRestTemplate restTemplate;

 @Test
 public void testPlaceOrder() {
	 for (int i = 1; i <=5; i++) {
		 OnlineOrder order = new OnlineOrder(2L, 1L, i);
		 String response = this.restTemplate.postForObject("http://localhost:"+port+"/test/place-order", order, String.class);
		 assertThat(response).isEqualTo("Order placed successfully!");
		 System.out.println("Order processing done successfully !");
	 }
 }
}
