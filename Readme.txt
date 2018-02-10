Project Title-RedPanda

Requirements:

As a user, I want to fetch name, ratings, and movie release year of top 250 movies from IMDB site and store the result in SQLite database

As a user, I want to Print database results



Prerequisites:

1=You should have WAMPSERVER in your local system.
2=You should have a Database name as imdb in your WAMPSERVER username as-"root".
3=You need to creat a Table name as top_250_movie_info and name the 1st column name as Slno(int type,Primary key),Moviename(varchar type,nutnull),
  MoviereleaseYr(int type,nut null) and MovieRatings(Int type,nut null).


Getting Started:
1=Download the project from mail and unzip it.
2=Inport the unziped prject into eclipse.
3=Right click on project mousehover on maven and click on maven project it will download some jars files into the project.
4=After updateing your project you will get a "testng.xml" file on your project right click on it and run as testng suit.
5=After running the testng.xml file comment the "<class name="test_cases.ImdbDataBaseEntryTest"/>" because it will store
  same movie name and details again and again better pratice to run that code once and read the data base again and again.
5=Check the customize report in ExtentReport folder after refreshing the project.





Built With

    Selenium webdriver - Automation tool.
    Maven - Dependency Management and build automation tool.
    Apache poi-For work with Excel file.
    Extent report-For customize report generation and logs.
    Log4j-For log generation.  


Authors

    Satyabrata dash

* I have almost cleared every criteria you have given but didn't push the code to centralized repository because i have 
used svn as version control tool in my company didn't use github yet.

  