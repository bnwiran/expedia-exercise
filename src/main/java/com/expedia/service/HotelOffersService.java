/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.expedia.service;

import com.expedia.domain.HotelOffer;
import com.expedia.util.Utils;
import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Belal
 */
public class HotelOffersService {
	
	private final String URL;
	private final RestTemplate restTemplate;
	
	public static class Filter {
		private String scenario;
		private Integer page;
		private String uid;
		private String productType;
		private String destinationName;
		private String destinationCity;
		private String[] regionIds;
		private Date minTripStartDate;
		private Date maxTripStartDate;
		private Integer lengthOfStay;
		private Double minStarRating;
		private Double maxStarRating;
		private Integer minTotalRate;
		private Integer maxTotalRate;
		private Double minGuestRating;
		private Double maxGuestRating;

		public String scenario() {
			return scenario;
		}

		public Filter scenario(String scenario) {
			this.scenario = scenario;
			return this;
		}

		public Integer page() {
			return page;
		}

		public Filter page(Integer page) {
			this.page = page;
			return this;
		}

		public String uid() {
			return uid;
		}

		public Filter uid(String uid) {
			this.uid = uid;
			return this;
		}

		public String productType() {
			return productType;
		}

		public Filter productType(String productType) {
			this.productType = productType;
			return this;
		}
		
		public String destinationName() {
			return destinationName;
		}

		public Filter destinationName(String destinationName) {
			this.destinationName = destinationName;
			return this;
		}

		public String destinationCity() {
			return destinationCity;
		}

		public Filter destinationCity(String destinationCity) {
			this.destinationCity = destinationCity;
			return this;
		}

		public String[] regionIds() {
			return regionIds;
		}

		public Filter regionIds(String... regionIds) {
			this.regionIds = regionIds;
			return this;
		}

		public Date minTripStartDate() {
			return minTripStartDate;
		}

		public Filter minTripStartDate(Date minTripStartDate) {
			this.minTripStartDate = minTripStartDate;
			return this;
		}

		public Date maxTripStartDate() {
			return maxTripStartDate;
		}

		public Filter maxTripStartDate(Date maxTripStartDate) {
			this.maxTripStartDate = maxTripStartDate;
			return this;
		}

		public Integer lengthOfStay() {
			return lengthOfStay;
		}

		public Filter lengthOfStay(Integer lengthOfStay) {
			this.lengthOfStay = lengthOfStay;
			return this;
		}

		public Double minStarRating() {
			return minStarRating;
		}

		public Filter minStarRating(Double minStarRating) {
			this.minStarRating = minStarRating;
			return this;
		}

		public Double maxStarRating() {
			return maxStarRating;
		}

		public Filter maxStarRating(Double maxStarRating) {
			this.maxStarRating = maxStarRating;
			return this;
		}

		public Integer minTotalRate() {
			return minTotalRate;
		}

		public Filter minTotalRate(Integer minTotalRate) {
			this.minTotalRate = minTotalRate;
			return this;
		}

		public Integer maxTotalRate() {
			return maxTotalRate;
		}

		public Filter maxTotalRate(Integer maxTotalRate) {
			this.maxTotalRate = maxTotalRate;
			return this;
		}

		public Double minGuestRating() {
			return minGuestRating;
		}

		public Filter minGuestRating(Double minGuestRating) {
			this.minGuestRating = minGuestRating;
			return this;
		}

		public Double maxGuestRating() {
			return maxGuestRating;
		}

		public Filter maxGuestRating(Double maxGuestRating) {
			this.maxGuestRating = maxGuestRating;
			return this;
		}
		
		public static Filter parseWebParams(Map<String, String[]> params) {
			if (params == null) {
				return null;
			}
			
			Filter filter = new Filter();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			
			Field[] fields = filter.getClass().getDeclaredFields();
			
			for (Field field : fields) {
				String name = field.getName();
				if (params.containsKey(name)) {

					String[] v = params.get(name);
					
					if (v != null && v.length != 0) {
						Class fieldClz = field.getType();					
						try {
							if (fieldClz == Double.class) {
								field.set(filter, Double.parseDouble(v[0]));
							} else if (fieldClz == Integer.class) {
								field.set(filter, Integer.parseInt(v[0]));
							} else if (fieldClz == Date.class) {
								field.set(filter, formatter.parse(v[0]));
							} else if (fieldClz == String.class) {
								field.set(filter, v[0]);
							} else if (fieldClz == String[].class) {
								field.set(filter, v);
							}
						} catch(IllegalAccessException | ParseException e) {
						}
					}					
				}
			}
			
			return filter;
		}
		
		public String buildParamString() {
			Field[] fields = this.getClass().getDeclaredFields();
			StringBuilder str = new StringBuilder();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

			boolean firstElement = true;
			for(Field field : fields) {
				try {
					String name = field.getName();
					Object value = field.get(this);
					
					if (value == null) {
						continue;
					}
					
					if (!firstElement) {
						str.append("&");
					}
					str.append(name);
					str.append("=");
					
					if (value instanceof Date) {
						value = formatter.format((Date) value);
					} else if (value instanceof String[]) {
						value = Utils.toString((String[]) value, ",");
					}
					str.append(value);
					firstElement = false;
					
				} catch(IllegalAccessException e) {
					
				}
			}
			
			return str.toString();
		}	
	}	
	
	public HotelOffersService(String apiUrl) {
		this.URL = apiUrl;
		this.restTemplate = new RestTemplate();
	}
	
	public HotelOffer getHotelOffer(Filter filter) {
		StringBuilder apiUrl = new StringBuilder(URL + "/offers/v2/getOffers");
		if (filter != null) {
			String str = filter.buildParamString();

			if (!"".equals(str)) {
				apiUrl.append("?");
				apiUrl.append(str);
			}
		}

		return restTemplate.getForObject(apiUrl.toString(), HotelOffer.class);
	}
}
