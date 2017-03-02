<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html  lang="en">
    <head>
		<spring:url value="/resources/css/bootstrap.min.css" var="bootstrapCss" />
		<link href="${bootstrapCss}" rel="stylesheet" />
        <title>Expedia Exercise</title>
    </head>
    <body>
		<div class="container">
			<c:forEach var="hotel" items="${hotels}">
				<div class="row" style="margin: 10px">
					<div class="col-sm-1">
						<img src="${hotel.hotelInfo.hotelImageUrl}" />
					</div>
					<div class="col-sm-11">
						<h4>${hotel.hotelInfo.hotelName}</h4>
						<div>${hotel.hotelInfo.hotelCity}</div>
						<div>${hotel.hotelPricingInfo.originalPricePerNight}</div>
						<div>${hotel.hotelPricingInfo.averagePriceValue}</div>
						<div>${hotel.hotelPricingInfo.drr}</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</body>
</html>
