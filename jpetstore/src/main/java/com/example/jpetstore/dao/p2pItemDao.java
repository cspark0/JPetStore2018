package com.example.jpetstore.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.jpetstore.domain.P2PItem;
import com.example.jpetstore.domain.Order;

public interface p2pItemDao {
	public void updateQuantity(Order order) throws DataAccessException;

	boolean isP2PItemInStock(String p2pItemId) throws DataAccessException;

	List<P2PItem> getItemListByProduct(String productId) throws DataAccessException;

	P2PItem getItem(String p2pItemId) throws DataAccessException;
}
