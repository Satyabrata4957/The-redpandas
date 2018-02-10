package test_cases;

import org.testng.annotations.Test;

import generic_lib.Database;

public class ImdbDataBaseViewTest
{
	@Test(alwaysRun=true)
	public void fetchFromImdbDataBase()
	{
		Database db=new Database();
		db.getMovieTable();
	}
}
