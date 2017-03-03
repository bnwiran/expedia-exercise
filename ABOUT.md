This is a simple website with a single page. It is used to search for hotel deals using the Expedia Web services. The frontend was built using JSP, Bootstrap, and jQuery UI, while the backend was built using Java 8 with Spring 4.3.x framework.

It is hosted on Heroku, you can access it via the link: https://pacific-cliffs-45784.herokuapp.com.

It is also uploaded to https://travis-ci.org.

Project Structure:

It consists of four packages: 

    1. com.expedia.controller: Contains the only Controller class to handle Web requests.
    2. com.expedia.domain: Contains the POJO classes that reflect the Expedia Webservice JSON response.
    3. com.expedia.service: Contains one Service class that used to access the Expedia Webservice.
    4. com.expedia.uitl: Contains a Utility class.
