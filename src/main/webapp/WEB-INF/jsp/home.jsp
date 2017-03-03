<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
    <head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
		<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
		<script>
			$(function () {
				$("#minTripStartDate").datepicker({
					dateFormat: "yy-mm-dd"
				});
				$("#maxTripStartDate").datepicker({
					dateFormat: "yy-mm-dd"
				});
			});

			$(function () {
				$("#starRatingSlider").slider({
					range: true,
					min: 1,
					max: 5,
					step: 0.5,
					values: [${minStarRating == null ? 1 : minStarRating}, ${maxStarRating == null ? 5 : maxStarRating}],
					slide: function (event, ui) {
						$("#minStarRating").val(ui.values[ 0 ]);
						$("#maxStarRating").val(ui.values[ 1 ]);
						$("#starRating").text("Star Rating: " + ui.values[ 0 ] + " - " + ui.values[ 1 ]);
					}
				});
				$("#minStarRating").val($("#starRatingSlider").slider("values", 0));
				$("#maxStarRating").val($("#starRatingSlider").slider("values", 1));
				$("#starRating").text("Star Rating: " + $("#starRatingSlider").slider("values", 0) +
						" - " + $("#starRatingSlider").slider("values", 1));
			});
			$(function () {
				$("#guestRatingSlider").slider({
					range: true,
					min: 0.0,
					max: 5.0,
					step: 0.1,
					values: [${minGuestRating == null ? 0.0 : minGuestRating}, ${maxGuestRating == null ? 5.0 : maxGuestRating}],
					slide: function (event, ui) {
						$("#minGuestRating").val(ui.values[ 0 ]);
						$("#maxGuestRating").val(ui.values[ 1 ]);
						$("#guestRating").text("Guest Rating: " + ui.values[ 0 ] + " - " + ui.values[ 1 ]);
					}
				});
				$("#minGuestRating").val($("#guestRatingSlider").slider("values", 0));
				$("#maxGuestRating").val($("#guestRatingSlider").slider("values", 1));
				$("#guestRating").text("Guest Rating: " + $("#guestRatingSlider").slider("values", 0) +
						" - " + $("#guestRatingSlider").slider("values", 1));
			});
		</script>		
        <title>Expedia Exercise</title>
    </head>
    <body>
		<div class="container">
			<div class="panel panel-default" style="margin-top: 20px">
				<div class="panel-body">
					<form>
						<div class="form-group row">
							<div class="col-md-8">
								<label for="destination">Destination</label>
								<input placeholder="Destination, City, or Region ID(s)" name="destination" type="text" class="form-control" id="destination" value="${destination}">
							</div>
						</div>
						<div class="form-group row">
							<div class="col-md-2">
								<label for="minTripStartDate">Check in</label>
								<input name="minTripStartDate" type="text" class="form-control" id="minTripStartDate" value="${minTripStartDate}">
							</div>
							<div class="col-md-2">
								<label for="maxTripStartDate">Check out</label>
								<input name = "maxTripStartDate" type="text" class="form-control" id="maxTripStartDate" value="${maxTripStartDate}">
							</div>
							<div class="col-md-2">
								<label for="lengthOfStay">Stay Length</label>
								<select name="lengthOfStay" class="form-control" id="lengthOfStay">
									<c:forEach var="n" items="${stayLengths}">
										<option ${n == lengthOfStay ? 'selected' : ''}>${n == 0 ? '' : n}</option>
									</c:forEach>
								</select>
							</div>								
						</div>
						<div class="form-group row">
							<div class="col-md-2">
								<label id="minTotalRate">Min. Total Rate</label>							  
								<input name="minTotalRate" type="text" class="form-control" id="minTotalRate"
									   value="${minTotalRate}">
							</div>	
							<div class="col-md-2">
								<label id="maxTotalRate">Max. Total Rate</label>							  
								<input name="maxTotalRate" type="text" class="form-control" id="maxTotalRate"
									   value="${maxTotalRate}">
							</div>	
							<div class="col-md-2 rightspan">
								<label id="starRating">Star Rating</label>							  
								<input name= "minStarRating" hidden type="text" id="minStarRating">
								<input name= "maxStarRating" hidden type="text" id="maxStarRating">
								<div id="starRatingSlider"></div>	
							</div>	
							<div class="col-md-2 rightspan">
								<label id="guestRating">Guest Rating</label>							  
								<input name= "minGuestRating" hidden type="text" id="minGuestRating">
								<input name= "maxGuestRating" hidden type="text" id="maxGuestRating">
								<div id="guestRatingSlider"></div>	
							</div>						
						</div>
						<button type="button" class="btn btn-primary" onClick="submit()">
							<span class="glyphicon glyphicon-search"></span> Search
						</button>
					</form>
				</div>
			</div>			
			<div class="panel-group">
				<c:forEach var="hotel" items="${hotels}">
					<div class="panel panel-default">
						<div class="panel-body">
							<div class="media">
								<div class="media-left">
									<img src="${hotel.hotelInfo.hotelImageUrl}" alt="${hotel.hotelInfo.hotelName}" class="media-object" style="width:80px">
								</div>	
								<div class="media-body">
									<h4 class="media-heading">${hotel.hotelInfo.hotelName}</h4>	
									<div class="row-group">
										<div class="row">
											<div class="col-md-${hotel.hotelPricingInfo.drr ? 10 : 11}">
												<p>${hotel.hotelInfo.hotelCity}</p>
											</div>
											<c:if test="${hotel.hotelPricingInfo.drr}">
												<div class="col-md-1 rightspan">
													<p style="text-decoration: line-through; font-weight: bold">$${hotel.hotelPricingInfo.originalPricePerNight}</p>
												</div>
											</c:if>
											<div class="col-md-1 rightspan">
												<p style="font-weight: bolder">$${hotel.hotelPricingInfo.averagePriceValue}</p>
											</div>
											<div class="col-md-${hotel.hotelPricingInfo.drr ? 10 : 11}">${hotel.hotelInfo.description}</div>										
										</div>	
										<hr>
										<div class="row">
											<div class="col-md-2"><span style="font-weight: bold">Total Price:</span> ${hotel.hotelPricingInfo.totalPriceValue}</div>										
											<div class="col-md-2"><span style="font-weight: bold">Star Rate: </span>${hotel.hotelInfo.hotelStarRating}</div>
											<div class="col-md-2"><span style="font-weight: bold">Guest Rate: </span>${hotel.hotelInfo.hotelGuestReviewRating}</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</body>
</html>
