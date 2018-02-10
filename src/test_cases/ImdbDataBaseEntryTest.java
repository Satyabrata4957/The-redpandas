package test_cases;

import java.util.List;

import org.testng.annotations.Test;

import generic_lib.BaseClass;
import generic_lib.Database;
import repository.IMDb_Top_250_Page;

public class ImdbDataBaseEntryTest extends BaseClass
{
	List<String> movieNameStr;
	List<String> movieReleaseYrStr;
	List<String> movieRatingStr;
	@Test(alwaysRun=true)
	public void fetchFromImdbPage()
	{
		IMDb_Top_250_Page imdb=new IMDb_Top_250_Page();
		movieNameStr=imdb.getTop_250_MovieName();
		movieReleaseYrStr=imdb.getTop_250_MovieReleseYear();
	    movieRatingStr=imdb.getTop_250_MovieRating();
	}
	@Test(alwaysRun=true, dependsOnMethods="fetchFromImdbPage")
	public void putDataToDataBase()
	{
		Database db=new Database();
		for (int i = 0; i < movieNameStr.size(); i++) 
		{
			String name=movieNameStr.get(i).replace("'", " ");
			String releaseYr=movieReleaseYrStr.get(i);
			float rating=Float.parseFloat(movieRatingStr.get(i));
			System.out.print((i+1)+" ");
			db.setMovieTable(i+1,name, releaseYr, rating);
		}
		
	}
	
	
}
