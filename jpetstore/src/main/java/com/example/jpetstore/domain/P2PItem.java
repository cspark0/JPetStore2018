package com.example.jpetstore.domain;

import java.util.Queue;

public class P2PItem extends Item {
	
	/* Private Fields */
	private int sellerId;
	private int buyerId;
	
	/* Getter & Setter */
	public int getSellerId() {
		return sellerId;
	}
	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}
	public int getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(int buyerId) {
		this.buyerId = buyerId;
	}
	
	/* Methods */

}
