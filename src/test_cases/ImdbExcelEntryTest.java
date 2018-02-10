package test_cases;


import java.util.List;
import org.testng.annotations.Test;

import generic_lib.BaseClass;
import generic_lib.Exel;
import repository.IMDb_Top_250_Page;

public class ImdbExcelEntryTest extends BaseClass 
{
	
 
	@Test
	public void Test1() throws Throwable
	{
		Exel ex=new Exel();
		IMDb_Top_250_Page imdb=new IMDb_Top_250_Page();
		List<String> movieNameStr=imdb.getTop_250_MovieName();
		List<String> movieReleaseYrStr=imdb.getTop_250_MovieReleseYear();
		List<String> movieRatingStr=imdb.getTop_250_MovieRating();
	
		int count=0;
		
		
			for(int i=0;i<movieNameStr.size();i++)
		    {
		     ex.setdata("IMDb", count, 0,movieNameStr.get(i));
		     ex.setdata("IMDb", count, 1,movieReleaseYrStr.get(i));
		     ex.setdata("IMDb", count, 2,movieRatingStr.get(i));
		     count++;
		    }
			
		}
		
		
	
	
}