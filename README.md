# trading-calendar-form

This is a spring MVC project to submit trading calendar form. JSP, spring JPA with hibernate and Oracle data base is the the tech stack used.

## Installation Process

## Prerequisites
	
	1. Java 8 or above
	2. Maven
	3. Oracle data base
	4. Java IDE. Eg. Eclipse	

## Steps for build and run
	1. Clone or download the repository and import as Maven project in eclipse IDE
	2. Update the database(DB) details in main/resources/application.properties file
	3. Run TradingCalendar.sql in DB(available in project home folder)
	4. Run maven commands. 
		4.1 mvn clean install
		4.2 mvn spring-boot:run -> This will run the application		
	5. That's all ! You can access the form using URL 		
		http://localhost:8080

## Future possible enhancements
    1. Better exception handling both in form and service
    2. Logging
    3. More unit testing to cover all the scenarios
    4. DB connection pooling

