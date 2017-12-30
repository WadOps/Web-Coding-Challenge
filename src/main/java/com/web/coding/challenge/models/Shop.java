package com.web.coding.challenge.models;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="shops")
public class Shop {
		@Id
		private String id;
		private String picture;
		private String name;
		private String email;
		private String city;
		private Location location;
		private List<String> likedByUserIds;
		private List<UserDislike> dislikedByUserIds;
		
		public Shop() {
			super();
			this.likedByUserIds=new ArrayList<String>();
			this.dislikedByUserIds=new ArrayList<UserDislike>();
		}
		public Shop(String id, String picture, String name, String email, String city, Location location, List<String> preferredByUserIds, List<UserDislike>dislikedByUserIds) {
			super();
			this.id = id;
			this.picture = picture;
			this.name = name;
			this.email = email;
			this.city = city;
			this.location = location;
			this.likedByUserIds=preferredByUserIds;
			this.dislikedByUserIds=dislikedByUserIds;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getPicture() {
			return picture;
		}
		public void setPicture(String picture) {
			this.picture = picture;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public Location getLocation() {
			return location;
		}
		public void setLocation(Location location) {
			this.location = location;
		}
		public List<String> getPreferredByUserIds() {
			return likedByUserIds;
		}
		public void setPrefferedByUserIds(List<String> prefferedByUserIds) {
			this.likedByUserIds = prefferedByUserIds;
		}
		public List<UserDislike> getDislikedByUserIds() {
			return dislikedByUserIds;
		}
		public void setDislikedByUserIds(List<UserDislike> dislikedByUserIds) {
			this.dislikedByUserIds = dislikedByUserIds;
		}
		@Override
		public String toString() {
			return "Shop [id=" + id + ", picture=" + picture + ", name=" + name + ", email=" + email + ", city=" + city
					+ ", location=" + location + ", prefferedByUserIds=" + likedByUserIds + ", dislikedByUserIds="
					+ dislikedByUserIds + "]";
		}
		
		
		
}
