/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.expedia.domain;

import com.expedia.service.HotelOffersService;
import java.util.HashMap;
import java.util.Map;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 *
 * @author Belal
 */
public class Main {
	public static void main(String[] args) {
		ApplicationContext ctx = new FileSystemXmlApplicationContext("D:\\Development\\Lab\\expedia-exercise\\src\\main\\webapp\\WEB-INF\\applicationContext.xml");
		HotelOffersService service = ctx.getBean(HotelOffersService.class);
		
		Map<String, String> params = new HashMap<>();

		params.put("scenario", "deal-finder");
		params.put("page", "1");
		params.put("uid", "foo");
		params.put("productType", "Hotel");
		
		System.out.println(service.getHotelOffer(params).getOffers().getHotels().length);
	}
}
