package com.example.jpetstore.domain;
import java.util.Queue;

public class AuctionItem extends Item {
		
		/* Private Fields */
		private int sellerId;
		private int buyerId;
		private int price;
		private String dueTime;
		private Queue<Account> users;
		
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
		public int getPrice() {
			return price;
		}
		public void setPrice(int price) {
			this.price = price;
		}
		public String getDueTime() {
			return dueTime;
		}
		public void setDueTime(String dueTime) {
			this.dueTime = dueTime;
		}
		public Queue<Account> getUsers() {
			return users;
		}
		public void setUsers(Queue<Account> users) {
			this.users = users;
		}
		
		/* Methods */
		public boolean isSold() {
			return false;
		}
		public boolean isTimesUp() {  
			// 경매 낙찰
			return false;
		}
		public void updatePrice(int val) {
			
		}
		// 경매 취소
		public int nextPerson() {
			// 구매 취소시, 다음사람으로 반환 : 반환값 userId
			return 0;
		}
		// 경매 실패
		public boolean isHighest(int userId) {
			// queue에서 useId가 첫번째가 아니면 return false;
			return false;
		}

}
