/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.expedia.service;

import com.expedia.domain.HotelOffer;
import java.util.Map;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Belal
 */
public class HotelOffersService {
	
	private final String URL;
	private final RestTemplate restTemplate;
	
	public HotelOffersService(String apiUrl) {
		this.URL = apiUrl;
		this.restTemplate = new RestTemplate();
	}
	
	public HotelOffer getHotelOffer(Map<String, String> params) {
		StringBuilder apiUrl = new StringBuilder(URL + "/offers/v2/getOffers");
		if (params != null && !params.isEmpty()) {
			apiUrl.append("?");

			params.forEach((k, v) -> {
				apiUrl.append(k);
				apiUrl.append("=");
				apiUrl.append(v);
				apiUrl.append("&");		// Extra & for the last parameter.
			});
		}

		return restTemplate.getForObject(apiUrl.toString(), HotelOffer.class);
	}
}
