/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.expedia.controller;

import com.expedia.domain.Hotel;
import com.expedia.service.HotelOffersService;
import com.expedia.service.HotelOffersService.Filter;
import static com.expedia.util.Utils.toStringArray;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Belal
 */
@Controller
public class HomeController {

	@RequestMapping("/")
	public ModelAndView home(WebRequest request) {
		Map<String, String[]> params = new HashMap<>();
		String destination = request.getParameter("destination");

		params.put("scenario", toStringArray("deal-finder"));
		params.put("page", toStringArray("1"));
		params.put("uid", toStringArray("foo"));
		params.put("productType", toStringArray("Hotel"));
		params.putAll(request.getParameterMap());
		
		Filter filter = Filter.parseWebParams(params);
		
		if (destination != null && !"".equals(destination)) {
			if (destination.matches("(\\d*,?)+")) {
				filter.regionIds(destination.split(","));
			} else {
				filter.destinationName(destination);
			}
		}

		Hotel[] hotels = hotelOffersService.getHotelOffer(filter).getOffers().getHotels();
		
		ModelAndView model = new ModelAndView();
		model.setViewName("home");
		model.addObject("hotels", hotels);
		model.addObject("stayLengths", stayLengths);
		request.getParameterNames().forEachRemaining(p -> model.addObject(p, request.getParameter(p)));
		return model;
	}	

	@Autowired
	private HotelOffersService hotelOffersService;
	
	private static final int[] stayLengths = IntStream.range(0, 15).toArray();
}
