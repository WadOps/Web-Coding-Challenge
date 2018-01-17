package com.web.coding.challenge.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.web.coding.challenge.models.Shop;


public interface ShopRepository extends MongoRepository<Shop,String>{
	
	@Query("{location:{$nearSphere :?0},'likedByUserIds' : {$ne : ?1},dislikedByUserIds:{$not:{$elemMatch:{dislikedAt : {$gt : ?2}, id: ?1}}}}")
	List<Shop> findNearByShops(Point a, String idUser, Date date);
	
	List<Shop> findByLikedByUserIds(String idUser);
	
	@Query("{dislikedByUserIds:{$elemMatch: {dislikedAt : {$lt : ?1}, id: ?0} } }")
	List<Shop> findExpiredDislikedShopByUserIds(String idUser, Date date);
}
