package com.web.coding.challenge.services;

import java.util.List;

import org.springframework.data.geo.Point;

import com.web.coding.challenge.models.Shop;

public interface IShopService {
	
	Shop likeShop(String idShop, String idUser);
	
	Shop unlikeShop(String idShop, String idUser);
	
	Shop dislikeShop(String idShop, String idUser);

	List<Shop> findNearByShopsByUserId(Point point, String idUser);

	List<Shop> getLikedShopsByUserId(String idUser);

}
