package com.example.jpetstore.dao;

import java.util.List;

import com.example.jpetstore.domain.Item;
import com.example.jpetstore.domain.P2PItem;
import com.example.jpetstore.domain.AuctionItem;

public interface BestSellerDao {
	public void updateSupBestSeller();

	public void updateP2pBestSeller();

	public void updateAucBestSeller();

	List<Item> getSupItemBestSeller();

	List<P2PItem> getP2pItemBestSeller();

	List<AuctionItem> getAucItemBestSeller();

}
