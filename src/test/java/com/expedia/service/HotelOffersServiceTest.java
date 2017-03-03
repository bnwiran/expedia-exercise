/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.expedia.service;

import com.expedia.domain.Hotel;
import com.expedia.service.HotelOffersService.Filter;
import com.expedia.util.Utils;
import static com.expedia.util.Utils.*;
import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;



/**
 *
 * @author Belal
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/applicationContext.xml")
public class HotelOffersServiceTest {

	@Autowired
	private HotelOffersService service;
	
	private static final SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat("yyy-MM-dd");
	private static final Filter FILTER = new Filter().uid("foo").scenario("deal-finder").page(1).productType("Hotel")
				.minTripStartDate(new Date()).regionIds("123,456");

	@Test
	public void testHotelServiceLengthOfStay() throws ParseException {
		Filter filter = new Filter().uid("foo").scenario("deal-finder").page(1).productType("Hotel")
				.lengthOfStay(3);
		Hotel[] hotels = service.getHotelOffer(filter).getOffers().getHotels();
		for (Hotel hotel : hotels) {
			assertEquals(3, hotel.getOfferDateRange().getLengthOfStay());
		}
	}
	
	@Test
	
	public void testHotelServiceTotalRate() throws ParseException {
		Integer minTotalRate = 4000;
		Integer maxTotalRate = 5000;
		Filter filter = new Filter().uid("foo").scenario("deal-finder").page(1).productType("Hotel")
				.minTotalRate(minTotalRate).maxTotalRate(maxTotalRate);
		Hotel[] hotels = service.getHotelOffer(filter).getOffers().getHotels();
		for (Hotel hotel : hotels) {
			assertTrue(Utils.isBetween(hotel.getHotelPricingInfo().getTotalPriceValue(), minTotalRate, maxTotalRate));
		}
	}
	
	@Test
	public void testHotelServiceStarRating() throws ParseException {
		Double minStarRate = Double.valueOf(2);
		Double maxStarRate = Double.valueOf(5);
		Filter filter = new Filter().uid("foo").scenario("deal-finder").page(1).productType("Hotel")
				.minStarRating(minStarRate).maxStarRating(maxStarRate);
		Hotel[] hotels = service.getHotelOffer(filter).getOffers().getHotels();
		for (Hotel hotel : hotels) {
			assertTrue(Utils.isBetween(Double.parseDouble(hotel.getHotelInfo().getHotelStarRating()), minStarRate, maxStarRate));
		}
	}
	
	@Test
	public void testHotelServiceGuestRating() throws ParseException {
		Double minGuestRate = Double.valueOf(3);
		Double maxGuestRate = Double.valueOf(5);
		Filter filter = new Filter().uid("foo").scenario("deal-finder").page(1).productType("Hotel")
				.minGuestRating(minGuestRate).maxGuestRating(maxGuestRate);
		Hotel[] hotels = service.getHotelOffer(filter).getOffers().getHotels();
		for (Hotel hotel : hotels) {
			assertTrue(Utils.isBetween(hotel.getHotelInfo().getHotelGuestReviewRating(), minGuestRate, maxGuestRate));
		}
	}	
	
	@Test
	public void testHotelServiceDestinationName() {
		Filter filter = new Filter().uid("foo").scenario("deal-finder").page(1).productType("Hotel")
				.destinationCity("Miami");
		Hotel[] hotels = service.getHotelOffer(filter).getOffers().getHotels();
		
		assertTrue(hotels != null && hotels.length > 0);
		for (Hotel hotel : hotels) {
			assertTrue("Destiation name must contain Miami", hotel.getDestination().getLongName().toLowerCase().contains("miami"));
		}
	}
	
	@Test
	public void testHotelServiceTripDate() throws ParseException {
		Date minDate = DATE_FORMATTER.parse("2017-03-03");
		Date maxDate = DATE_FORMATTER.parse("2017-03-31");
		Filter filter = new Filter().uid("foo").scenario("deal-finder").page(1).productType("Hotel")
				.minTripStartDate(minDate).maxTripStartDate(maxDate);
		
		Hotel[] hotels = service.getHotelOffer(filter).getOffers().getHotels();
		for (Hotel hotel : hotels) {
			Date startDate = DATE_FORMATTER.parse(Utils.toString(hotel.getOfferDateRange().getTravelStartDate(), "-"));			
			assertTrue(Utils.isBetween(startDate, minDate, maxDate));
		}
	}		
	
	@Test
	public void testHotelServiceFilterCreation() {
		String str = FILTER.buildParamString();
		String[] arr = str.split("&");
		Arrays.sort(arr);
		
		str = Utils.toString(arr, "&");

		assertEquals("minTripStartDate=" + DATE_FORMATTER.format(new Date()) + "&page=1"
				+ "&productType=Hotel&regionIds=123,456&scenario=deal-finder&uid=foo", str);
	}
	
	@Test
	public void testHotelServiceFilterParsing() {
		Date today = new Date();
		Map<String, String[]> params = new HashMap<>();
		
		params.put("maxTripStartDate", toStringArray(DATE_FORMATTER.format(today)));
		params.put("page", toStringArray(1));
		params.put("productType", toStringArray("Hotel"));
		params.put("regionIds", toStringArray("123", "456"));
		params.put("scenario", toStringArray("deal-finder"));
		params.put("uid", toStringArray("foo"));
		
		Filter filter = Filter.parseWebParams(params);

		String str = filter.buildParamString();
		String[] arr = str.split("&");
		Arrays.sort(arr);
		
		str = Utils.toString(arr, "&");

		assertEquals("maxTripStartDate=" + DATE_FORMATTER.format(new Date()) + "&page=1"
				+ "&productType=Hotel&regionIds=123,456&scenario=deal-finder&uid=foo", str);		
	}
}
