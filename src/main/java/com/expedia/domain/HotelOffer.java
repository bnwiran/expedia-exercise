/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.expedia.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author Belal
 */
public class HotelOffer {
	private OfferInfo offerInfo;
	private UserInfo userInfo;
	private Offers offers;

	public OfferInfo getOfferInfo() {
		return offerInfo;
	}

	public void setOfferInfo(OfferInfo offerInfo) {
		this.offerInfo = offerInfo;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public Offers getOffers() {
		return offers;
	}

	public void setOffers(Offers offers) {
		this.offers = offers;
	}
		
	
	public static class Offers {
		@JsonProperty(value = "Hotel")
		private Hotel[] hotels;
		
		public Hotel[] getHotels() {
			return hotels;
		}

		
		public void setHotels(Hotel[] hotels) {
			this.hotels = hotels;
		}				
	}
	
	public static class OfferInfo {
		private String siteID;
		private String language;
		private String currency;

		public String getSiteID() {
			return siteID;
		}

		public void setSiteID(String siteID) {
			this.siteID = siteID;
		}

		public String getLanguage() {
			return language;
		}

		public void setLanguage(String language) {
			this.language = language;
		}

		public String getCurrency() {
			return currency;
		}

		public void setCurrency(String currency) {
			this.currency = currency;
		}
		
		
	}
}
