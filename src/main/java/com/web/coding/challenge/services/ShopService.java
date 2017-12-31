package com.web.coding.challenge.services;

import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;

import com.web.coding.challenge.dao.ShopRepository;
import com.web.coding.challenge.models.Shop;
import com.web.coding.challenge.models.UserDislike;

@Service
public class ShopService implements IShopService {
	@Autowired
	private ShopRepository shopRepository;
	
	/* 
	 * this group of methods permit the user to like, unlike, dislike a shop
	 */
	
	@Override
	public Shop likeShop(String idShop, String idUser) {
		Shop shop=shopRepository.findOne(idShop);
		List<String> likes=shop.getPreferredByUserIds();
		likes.add(idUser);
		shop.setPrefferedByUserIds(likes);
		return shopRepository.save(shop);
	}

	@Override
	public Shop unlikeShop(String idShop, String idUser) {
		Shop shop=shopRepository.findOne(idShop);
		List<String> likes=shop.getPreferredByUserIds();
		likes.remove(idUser);
		shop.setPrefferedByUserIds(likes);
		return shopRepository.save(shop);
	}

	@Override
	public Shop dislikeShop(String idShop, String idUser) {
		Shop shop=shopRepository.findOne(idShop);
		List<UserDislike> dislikes=shop.getDislikedByUserIds();
		dislikes.add(new UserDislike(idUser,new Date()));
		shop.setDislikedByUserIds(dislikes);
		return shopRepository.save(shop);
	}
	
	/*
	 * this method return a list of shops that are nearby and does not include liked shops and disliked in the past two hours 
	 */
	
	@Override
	public List<Shop> findNearByShopsByUserId(Point point,String idUser) {
		DateTime dateTime = new DateTime().minusHours(2);
		return shopRepository.findNearByShops(point,idUser, dateTime.toDate());
	}
	
	/*
	 * this method return a list of shops liked by a user
	 */

	@Override
	public List<Shop> getLikedShopsByUserId(String idUser) {
		return shopRepository.findByLikedByUserIds(idUser);
	}
}
