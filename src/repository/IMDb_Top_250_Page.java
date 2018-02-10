package repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import generic_lib.BaseClass;


public class IMDb_Top_250_Page 
{
	public IMDb_Top_250_Page()
	{
		PageFactory.initElements(BaseClass.driver, this);
	}
	
	
  @FindBys({@FindBy(xpath="//tbody[@class='lister-list']/tr[*]/td[2]/a")})
  List<WebElement> topMovieName;
  
  @FindBys(@FindBy(xpath="//tbody[@class='lister-list']/tr[*]/td[2]/span"))
  List<WebElement> topMovieReleaseYear;
  
  @FindBys(@FindBy(xpath="//tbody[@class='lister-list']/tr[*]/td[3]/strong"))
  List<WebElement> topMovieRatings;
  
	public List<String> getTop_250_MovieName()
	{
		Iterator<WebElement> iterator=topMovieName.iterator();
		List<String> nstring=new ArrayList<String>();
		while (iterator.hasNext()) 
		{
		 nstring.add(iterator.next().getText());
		}
		return(nstring);
	}
	
	public List<String> getTop_250_MovieReleseYear()
	{
		Iterator<WebElement> iterator=topMovieReleaseYear.iterator();
		List<String> nstring=new ArrayList<String>();
		while (iterator.hasNext()) 
		{
		 nstring.add(iterator.next().getText());
		}
		return(nstring);
	}
	
	public List<String> getTop_250_MovieRating()
	{
		Iterator<WebElement> iterator=topMovieRatings.iterator();
		List<String> nstring=new ArrayList<String>();
		while (iterator.hasNext()) 
		{
		 nstring.add(iterator.next().getText());
		}
		return(nstring);
	}
	
	public void printMovieName()
	{
		for(String s:getTop_250_MovieName())
		{
			System.out.println(s);
		}
	}
	public void printMovieReleaseYear()
	{
		for(String s:getTop_250_MovieReleseYear())
		{
			System.out.println(s);
		}
	}
	public void printMovieRating()
	{
		for(String s:getTop_250_MovieRating())
		{
			System.out.println(s);
		}
	}
	
}
