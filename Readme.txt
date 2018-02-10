Project Title-RedPanda

Requirements:

As a user, I want to fetch name, ratings, and movie release year of top 250 movies from IMDB site and store the result in SQLite database

As a user, I want to Print database results



Prerequisites:

1.You should have Mysql server in your local system.
2.You should have a Database named as "IMDb" in your Mysql server.
3.Create a table under "imdb" database and use the query below:-
CREATE TABLE `top_250_movie_info` (
   `SLNo` int(5) not null,
   `MovieName` varchar(255) not null,
   `MovieReleaseyr` varchar(255) not null,
   `MovieRatings` float not null,
   PRIMARY KEY (`SLNo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
4.TestNG shold be installed and TestNG library should be added in the eclipse.


Getting Started:
1.Import the project from github to eclipse.
2.Update the maven project.
3.Convert the project to testNG.
4.Go to package "generic_lib" to class "Database" in method "setDataBase" enter the url,username and password of the database.
5.Add ImdbDataBaseEntryTest class to the testng.xml file as "<class name="test_cases.ImdbDataBaseEntryTest"/>" to store imdb page data to the database.
6.Add ImdbDataBaseViewTest class to the testng.xml file as "<class name="test_cases.ImdbDataBaseViewTest"/>" to view imdb page data from the database.
7.Run the testng.xml as testNG suite present in the project.
8.After it ran refresh the project and go to "ExtentReport" folder and open "redpanda.html" in the browser to see the test report.





Built With

    Selenium webdriver - Automation tool.
    Maven - Dependency Management and build automation tool.
    Mysql server
    Extent report-For customize report generation and logs.
    Log4j-For log generation.  


Author
Satyabrata dash
