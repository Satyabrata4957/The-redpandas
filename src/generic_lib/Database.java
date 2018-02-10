package generic_lib;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database
{
	Connection con;
	Statement stmt;
	private void setDataBase()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/IMDb","root","");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
    
	public void  setMovieTable(int SLNo,String movieName, String movieReleaseyr, float movieRatings)
	{
		
		try 
		{
			setDataBase();
			stmt=con.createStatement();
			int rsInsert=stmt.executeUpdate("insert into TOP_250_Movie_Info(SLNo,MovieName,MovieReleaseyr,MovieRatings) values ("+SLNo+",'"+movieName+"',"+movieReleaseyr+","+movieRatings+")");
			System.out.println("Insert value:"+rsInsert);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		
	}
	
	public void getMovieTable()
	{
		
		try 
		{
			setDataBase();
			stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from TOP_250_Movie_Info");
			while(rs.next())
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getFloat(4));
			
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		
	}
	
	
	
	
	
}
