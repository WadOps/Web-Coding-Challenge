package com.web.coding.challenge.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Point;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.web.coding.challenge.models.Location;
import com.web.coding.challenge.models.Shop;
import com.web.coding.challenge.services.IShopService;


@RestController
public class ShopController {
	@Autowired
	private IShopService shopService;
	
	@RequestMapping(value = "/{id}/shops" , method = RequestMethod.POST)
	public ResponseEntity<List<Shop>> getNearByShops(@PathVariable String id, @RequestBody Location location) {
		return ResponseEntity.ok(shopService.findNearByShopsByUserId(new Point(Double.valueOf(location.getCoordinates().get(0)),Double.valueOf(location.getCoordinates().get(1))), id));
	}
	
	@RequestMapping(value = "/{id}/shops/liked" , method = RequestMethod.GET)
	public ResponseEntity<List<Shop>> getLikedShops(@PathVariable String id) {
		return ResponseEntity.ok(shopService.getLikedShopsByUserId(id));
	}
	
	@RequestMapping(value = "/{id}/shops/like" , method = RequestMethod.POST)
	public ResponseEntity<Shop> likeShop(@PathVariable String id, @RequestBody Shop shop) {
		return ResponseEntity.ok(shopService.likeShop(shop.getId(), id));
	}
	
	@RequestMapping(value = "/{id}/shops/unlike" , method = RequestMethod.POST)
	public ResponseEntity<Shop> unlikeShop(@PathVariable String id, @RequestBody Shop shop) {
		return ResponseEntity.ok(shopService.unlikeShop(shop.getId(),id));
	}
	
	@RequestMapping(value = "/{id}/shops/dislike" , method = RequestMethod.POST)
	public ResponseEntity<Shop> dislikeShop(@PathVariable String id, @RequestBody Shop shop) {
		return ResponseEntity.ok(shopService.dislikeShop(shop.getId(), id));
	}

}
