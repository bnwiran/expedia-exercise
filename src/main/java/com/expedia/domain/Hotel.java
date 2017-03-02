/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.expedia.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

/**
 *
 * @author Belal
 */
public class Hotel {
	private OfferDateRange offerDateRange;
	private Destination destination;
	private Info hotelInfo;
	private UrgencyInfo hotelUrgencyInfo;
	private PricingInfo hotelPricingInfo;
	private Urls urls;
	private Scores scores;

	public OfferDateRange getOfferDateRange() {
		return offerDateRange;
	}

	public void setOfferDateRange(OfferDateRange offerDateRange) {
		this.offerDateRange = offerDateRange;
	}

	public Destination getDestination() {
		return destination;
	}

	public void setDestination(Destination destination) {
		this.destination = destination;
	}

	public Info getHotelInfo() {
		return hotelInfo;
	}

	public void setHotelInfo(Info hotelInfo) {
		this.hotelInfo = hotelInfo;
	}

	public UrgencyInfo getHotelUrgencyInfo() {
		return hotelUrgencyInfo;
	}

	public void setHotelUrgencyInfo(UrgencyInfo hotelUrgencyInfo) {
		this.hotelUrgencyInfo = hotelUrgencyInfo;
	}

	public PricingInfo getHotelPricingInfo() {
		return hotelPricingInfo;
	}

	public void setHotelPricingInfo(PricingInfo hotelPricingInfo) {
		this.hotelPricingInfo = hotelPricingInfo;
	}

	public Urls getUrls() {
		return urls;
	}

	public void setUrls(Urls urls) {
		this.urls = urls;
	}

	public Scores getScores() {
		return scores;
	}

	public void setScores(Scores scores) {
		this.scores = scores;
	}
	
	
	
	public static class Scores {
		private double rawAppealScore;
		private double movingAverageScore;

		public double getRawAppealScore() {
			return rawAppealScore;
		}

		public void setRawAppealScore(double rawAppealScore) {
			this.rawAppealScore = rawAppealScore;
		}

		public double getMovingAverageScore() {
			return movingAverageScore;
		}

		public void setMovingAverageScore(double movingAverageScore) {
			this.movingAverageScore = movingAverageScore;
		}				
	}
	
	public static class Urls {
		private String hotelInfositeUrl;
		private String hotelSearchResultUrl;

		public String getHotelInfositeUrl() {
			return hotelInfositeUrl;
		}

		public void setHotelInfositeUrl(String hotelInfositeUrl) {
			this.hotelInfositeUrl = hotelInfositeUrl;
		}

		public String getHotelSearchResultUrl() {
			return hotelSearchResultUrl;
		}

		public void setHotelSearchResultUrl(String hotelSearchResultUrl) {
			this.hotelSearchResultUrl = hotelSearchResultUrl;
		}				
	}
	
	public static class PricingInfo {
		private double averagePriceValue;
		private double totalPriceValue;
		private String originalPricePerNight;	// Why is this String?
		private double hotelTotalBaseRate;
		private double hotelTotalTaxesAndFees;
		private String currency;
		private double hotelTotalMandatoryTaxesAndFees;
		private double percentSavings;
		private boolean drr;

		public double getAveragePriceValue() {
			return averagePriceValue;
		}

		public void setAveragePriceValue(double averagePriceValue) {
			this.averagePriceValue = averagePriceValue;
		}

		public double getTotalPriceValue() {
			return totalPriceValue;
		}

		public void setTotalPriceValue(double totalPriceValue) {
			this.totalPriceValue = totalPriceValue;
		}

		public String getOriginalPricePerNight() {
			return originalPricePerNight;
		}

		public void setOriginalPricePerNight(String originalPricePerNight) {
			this.originalPricePerNight = originalPricePerNight;
		}

		public double getHotelTotalBaseRate() {
			return hotelTotalBaseRate;
		}

		public void setHotelTotalBaseRate(double hotelTotalBaseRate) {
			this.hotelTotalBaseRate = hotelTotalBaseRate;
		}

		public double getHotelTotalTaxesAndFees() {
			return hotelTotalTaxesAndFees;
		}

		public void setHotelTotalTaxesAndFees(double hotelTotalTaxesAndFees) {
			this.hotelTotalTaxesAndFees = hotelTotalTaxesAndFees;
		}

		public String getCurrency() {
			return currency;
		}

		public void setCurrency(String currency) {
			this.currency = currency;
		}

		public double getHotelTotalMandatoryTaxesAndFees() {
			return hotelTotalMandatoryTaxesAndFees;
		}

		public void setHotelTotalMandatoryTaxesAndFees(double hotelTotalMandatoryTaxesAndFees) {
			this.hotelTotalMandatoryTaxesAndFees = hotelTotalMandatoryTaxesAndFees;
		}

		public double getPercentSavings() {
			return percentSavings;
		}

		public void setPercentSavings(double percentSavings) {
			this.percentSavings = percentSavings;
		}

		public boolean isDrr() {
			return drr;
		}

		public void setDrr(boolean drr) {
			this.drr = drr;
		}
	}
	
	public static class UrgencyInfo {
		private int airAttachRemainingTime;
		private int numberOfPeopleViewing;
		private int numberOfPeopleBooked;
		private int numberOfRoomsLeft;
		private long lastBookedTime;
		private String almostSoldStatus;
		private String link;
		private String[] almostSoldOutRoomTypeInfoCollection;
		private boolean airAttachEnabled;

		public int getAirAttachRemainingTime() {
			return airAttachRemainingTime;
		}

		public void setAirAttachRemainingTime(int airAttachRemainingTime) {
			this.airAttachRemainingTime = airAttachRemainingTime;
		}

		public int getNumberOfPeopleViewing() {
			return numberOfPeopleViewing;
		}

		public void setNumberOfPeopleViewing(int numberOfPeopleViewing) {
			this.numberOfPeopleViewing = numberOfPeopleViewing;
		}

		public int getNumberOfPeopleBooked() {
			return numberOfPeopleBooked;
		}

		public void setNumberOfPeopleBooked(int numberOfPeopleBooked) {
			this.numberOfPeopleBooked = numberOfPeopleBooked;
		}

		public int getNumberOfRoomsLeft() {
			return numberOfRoomsLeft;
		}

		public void setNumberOfRoomsLeft(int numberOfRoomsLeft) {
			this.numberOfRoomsLeft = numberOfRoomsLeft;
		}

		public long getLastBookedTime() {
			return lastBookedTime;
		}

		public void setLastBookedTime(long lastBookedTime) {
			this.lastBookedTime = lastBookedTime;
		}

		public String getAlmostSoldStatus() {
			return almostSoldStatus;
		}

		public void setAlmostSoldStatus(String almostSoldStatus) {
			this.almostSoldStatus = almostSoldStatus;
		}

		public String getLink() {
			return link;
		}

		public void setLink(String link) {
			this.link = link;
		}

		public String[] getAlmostSoldOutRoomTypeInfoCollection() {
			return almostSoldOutRoomTypeInfoCollection;
		}

		public void setAlmostSoldOutRoomTypeInfoCollection(String[] almostSoldOutRoomTypeInfoCollection) {
			this.almostSoldOutRoomTypeInfoCollection = almostSoldOutRoomTypeInfoCollection;
		}				

		public boolean isAirAttachEnabled() {
			return airAttachEnabled;
		}

		public void setAirAttachEnabled(boolean airAttachEnabled) {
			this.airAttachEnabled = airAttachEnabled;
		}
	}

	public static class Info {
		private String hotelId;
		private String hotelName;
		private String hotelDestination;
		private String hotelDestinationRegionID;
		private String hotelLongDestination;
		private String hotelStreetAddress;
		private String hotelCity;
		private String hotelProvince;
		private String hotelCountryCode;
		private String hotelLocation;
		private double hotelLatitude;
		private double hotelLongitude;
		private String hotelStarRating;
		private double hotelGuestReviewRating;
		
		@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
		private Date travelStartDate;
		
		@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
		private Date travelEndDate;
		private String hotelImageUrl;
		private double carPackageScore;
		private String description;
		private double distanceFromUser;
		private String language;
		private double movingAverageScore;
		private double promotionAmount;
		private String promotionDescription;
		private String promotionTag;
		private double rawAppealScore;
		private double relevanceScore;
		private String statusCode;
		private String statusDescription;
		private boolean carPackage;
		private boolean allInclusive;

		public String getHotelId() {
			return hotelId;
		}

		public void setHotelId(String hotelId) {
			this.hotelId = hotelId;
		}

		public String getHotelName() {
			return hotelName;
		}

		public void setHotelName(String hotelName) {
			this.hotelName = hotelName;
		}

		public String getHotelDestination() {
			return hotelDestination;
		}

		public void setHotelDestination(String hotelDestination) {
			this.hotelDestination = hotelDestination;
		}

		public String getHotelDestinationRegionID() {
			return hotelDestinationRegionID;
		}

		public void setHotelDestinationRegionID(String hotelDestinationRegionID) {
			this.hotelDestinationRegionID = hotelDestinationRegionID;
		}

		public String getHotelLongDestination() {
			return hotelLongDestination;
		}

		public void setHotelLongDestination(String hotelLongDestination) {
			this.hotelLongDestination = hotelLongDestination;
		}

		public String getHotelStreetAddress() {
			return hotelStreetAddress;
		}

		public void setHotelStreetAddress(String hotelStreetAddress) {
			this.hotelStreetAddress = hotelStreetAddress;
		}

		public String getHotelCity() {
			return hotelCity;
		}

		public void setHotelCity(String hotelCity) {
			this.hotelCity = hotelCity;
		}

		public String getHotelProvince() {
			return hotelProvince;
		}

		public void setHotelProvince(String hotelProvince) {
			this.hotelProvince = hotelProvince;
		}

		public String getHotelCountryCode() {
			return hotelCountryCode;
		}

		public void setHotelCountryCode(String hotelCountryCode) {
			this.hotelCountryCode = hotelCountryCode;
		}

		public String getHotelLocation() {
			return hotelLocation;
		}

		public void setHotelLocation(String hotelLocation) {
			this.hotelLocation = hotelLocation;
		}

		public double getHotelLatitude() {
			return hotelLatitude;
		}

		public void setHotelLatitude(double hotelLatitude) {
			this.hotelLatitude = hotelLatitude;
		}

		public double getHotelLongitude() {
			return hotelLongitude;
		}

		public void setHotelLongitude(double hotelLongitude) {
			this.hotelLongitude = hotelLongitude;
		}

		public String getHotelStarRating() {
			return hotelStarRating;
		}

		public void setHotelStarRating(String hotelStarRating) {
			this.hotelStarRating = hotelStarRating;
		}

		public double getHotelGuestReviewRating() {
			return hotelGuestReviewRating;
		}

		public void setHotelGuestReviewRating(double hotelGuestReviewRating) {
			this.hotelGuestReviewRating = hotelGuestReviewRating;
		}

		public Date getTravelStartDate() {
			return travelStartDate;
		}

		public void setTravelStartDate(Date travelStartDate) {
			this.travelStartDate = travelStartDate;
		}

		public Date getTravelEndDate() {
			return travelEndDate;
		}

		public void setTravelEndDate(Date travelEndDate) {
			this.travelEndDate = travelEndDate;
		}

		public String getHotelImageUrl() {
			return hotelImageUrl;
		}

		public void setHotelImageUrl(String hotelImageUrl) {
			this.hotelImageUrl = hotelImageUrl;
		}

		public double getCarPackageScore() {
			return carPackageScore;
		}

		public void setCarPackageScore(double carPackageScore) {
			this.carPackageScore = carPackageScore;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public double getDistanceFromUser() {
			return distanceFromUser;
		}

		public void setDistanceFromUser(double distanceFromUser) {
			this.distanceFromUser = distanceFromUser;
		}

		public String getLanguage() {
			return language;
		}

		public void setLanguage(String language) {
			this.language = language;
		}

		public double getMovingAverageScore() {
			return movingAverageScore;
		}

		public void setMovingAverageScore(double movingAverageScore) {
			this.movingAverageScore = movingAverageScore;
		}

		public double getPromotionAmount() {
			return promotionAmount;
		}

		public void setPromotionAmount(double promotionAmount) {
			this.promotionAmount = promotionAmount;
		}

		public String getPromotionDescription() {
			return promotionDescription;
		}

		public void setPromotionDescription(String promotionDescription) {
			this.promotionDescription = promotionDescription;
		}

		public String getPromotionTag() {
			return promotionTag;
		}

		public void setPromotionTag(String promotionTag) {
			this.promotionTag = promotionTag;
		}

		public double getRawAppealScore() {
			return rawAppealScore;
		}

		public void setRawAppealScore(double rawAppealScore) {
			this.rawAppealScore = rawAppealScore;
		}

		public double getRelevanceScore() {
			return relevanceScore;
		}

		public void setRelevanceScore(double relevanceScore) {
			this.relevanceScore = relevanceScore;
		}

		public String getStatusCode() {
			return statusCode;
		}

		public void setStatusCode(String statusCode) {
			this.statusCode = statusCode;
		}

		public String getStatusDescription() {
			return statusDescription;
		}

		public void setStatusDescription(String statusDescription) {
			this.statusDescription = statusDescription;
		}

		public boolean isCarPackage() {
			return carPackage;
		}

		public void setCarPackage(boolean carPackage) {
			this.carPackage = carPackage;
		}

		public boolean isAllInclusive() {
			return allInclusive;
		}

		public void setAllInclusive(boolean allInclusive) {
			this.allInclusive = allInclusive;
		}		
	}

	public static class Destination {

		private String regionID;
		private String longName;
		private String country;
		private String province;
		private String city;

		public String getRegionID() {
			return regionID;
		}

		public void setRegionID(String regionID) {
			this.regionID = regionID;
		}

		public String getLongName() {
			return longName;
		}

		public void setLongName(String longName) {
			this.longName = longName;
		}

		public String getCountry() {
			return country;
		}

		public void setCountry(String country) {
			this.country = country;
		}

		public String getProvince() {
			return province;
		}

		public void setProvince(String province) {
			this.province = province;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}
	}

	public static class OfferDateRange {

		private String[] travelStartDate;
		private String[] travelEndDate;
		private int lengthOfStay;

		public String[] getTravelStartDate() {
			return travelStartDate;
		}

		public void setTravelStartDate(String[] travelStartDate) {
			this.travelStartDate = travelStartDate;
		}

		public String[] getTravelEndDate() {
			return travelEndDate;
		}

		public void setTravelEndDate(String[] travelEndDate) {
			this.travelEndDate = travelEndDate;
		}

		public int getLengthOfStay() {
			return lengthOfStay;
		}

		public void setLengthOfStay(int lengthOfStay) {
			this.lengthOfStay = lengthOfStay;
		}
	}
}
