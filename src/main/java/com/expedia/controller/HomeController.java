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

		params.put("scenario", toStringArray("deal-finder"));
		params.put("page", toStringArray("1"));
		params.put("uid", toStringArray("foo"));
		params.put("productType", toStringArray("Hotel"));
		params.putAll(request.getParameterMap());

		Hotel[] hotels = hotelOffersService.getHotelOffer(Filter.parseWebParams(params)).getOffers().getHotels();
		
		ModelAndView model = new ModelAndView();
		model.setViewName("home");
		model.addObject("hotels", hotels);
		
		System.out.println(hotels.length);
		
		return model;
	}	

	@Autowired
	private HotelOffersService hotelOffersService;
}
