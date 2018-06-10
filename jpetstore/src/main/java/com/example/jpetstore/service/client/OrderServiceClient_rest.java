package com.example.jpetstore.service.client;

import java.util.Iterator;
// import java.util.List;

import org.springframework.util.StopWatch;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.example.jpetstore.domain.LineItem;
import com.example.jpetstore.domain.Order;

public class OrderServiceClient_rest {

	private static RestTemplate restTemplate = new RestTemplate();
	private static String host = "localhost";
	private static String port = "8080";
	private static String jpetstoreSvcUrl = "http://" + host + ":" + port + "/jpetstore/rest";				

	public static void main(String[] args) {
		
		getOrderInfo(4);	

		getOrderInfo(30004);

		getOrderInfo("j2ee");
		
		deleteOrder(1147);
	}

	private static void getOrderInfo(int orderId) {
		StopWatch stopWatch = new StopWatch("getOrder" + " call");
		System.out.println("Calling ViewOrderController with order ID " + orderId);
		stopWatch.start("getOrderInfo()");
		
		Order order = null;
		try {
			order = restTemplate.getForObject(
					jpetstoreSvcUrl + "/order/{orderId}", Order.class, orderId);
		} catch (RestClientException e) {
			e.printStackTrace();
		}
		
		stopWatch.stop();		
		if (order != null) {
			printOrder(order);
		}
		else {
			System.out.println("Order with ID " + orderId + " not found");
		}
		System.out.println();
		System.out.println(stopWatch.prettyPrint());
	}

	private static void getOrderInfo(String username) {
		// StopWatch stopWatch = new StopWatch("getOrdersByUsername" + " call");
		System.out.println("Calling ViewOrderController with user's name " + username);
		// stopWatch.start("getOrderInfo()");		
		Order[] orders = null;
		try {
			orders = restTemplate.getForObject(
					jpetstoreSvcUrl + "/ordersBy/{username}", Order[].class, username);
		} catch (RestClientException e) {
			e.printStackTrace();
		}
		
		// stopWatch.stop();		
		if (orders != null) {
			printOrders(orders, username);
		}
		else {
			System.out.println("Orders by " + username + " not found");
		}
		System.out.println();
		// System.out.println(stopWatch.prettyPrint());
	}

	private static void deleteOrder(int orderId) {
		System.out.println("Calling deleteOrder with order ID " + orderId);
		
		try {
			restTemplate.delete(jpetstoreSvcUrl + "/order/{orderId}", orderId);
		} catch (RestClientException e) {
			e.printStackTrace();
			return;
		}		
		System.out.println("order " + orderId + " has been deleted.");
	}
	
	private static void printOrder(Order order) {
		System.out.println("Got order with order ID " + order.getOrderId() +
				" and order date " + order.getOrderDate());
		System.out.println("User name: " + order.getUsername());
		System.out.println("Shipping address: " + order.getShipAddress1() + ", " + order.getShipAddress2() + ", " + order.getShipCity());
		for (Iterator<LineItem> lineItems = order.getLineItems().iterator(); lineItems.hasNext();) {
			LineItem lineItem = (LineItem) lineItems.next();
			System.out.println("LineItem " + lineItem.getLineNumber() + ": " + lineItem.getQuantity() +
					" piece(s) of item " + lineItem.getItemId());
		}
		System.out.println("Total prices: " + order.getTotalPrice());
	}
	
	private static void printOrders(Order[] orders, String username) {		
		System.out.println("Number of orders by " + username + ": "+ orders.length);
		for (int i = 0; i < orders.length; i++) {
			Order order = orders[i];
			System.out.println("-------------------------------");
			System.out.println("Order ID: " + order.getOrderId());
			System.out.println("Order Date: " + order.getOrderDate());
			System.out.println("Shipping address: " + order.getShipAddress1() + ", " + order.getShipAddress2() + ", " + order.getShipCity());
			System.out.println("Total prices: " + order.getTotalPrice());
		}
	}
}
