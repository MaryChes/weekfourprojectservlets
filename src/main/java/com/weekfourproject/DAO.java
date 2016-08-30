package com.weekfourproject;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class DAO 
{
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/?user=root&autoReconnect=true&useSSL=false";
	static final String USER = "root";
	static final String PASSWORD = "root";
	
	static Connection CONN= null;
	static Statement STMT= null;
	static PreparedStatement PREP_STMT = null;
	static ResultSet RES_SET= null;
	
	static Scanner sc = new Scanner(System.in);
	
	
	public static void connToDB()
	{
		try {
			Class.forName(JDBC_DRIVER);
			System.out.println("Trying to connect to the Database...");
			CONN = DriverManager.getConnection(DB_URL, USER, PASSWORD);
			System.out.println("Connected to the database.");
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Failed to connect to the databsae.");
			e.printStackTrace();
		}
	}//end method
	
	
	public static void readFromDB()
	{
		
		connToDB();
		
		ArrayList<Movie>ourMovies = new ArrayList<>();
		
		try 
		{
			STMT = CONN.createStatement();
			RES_SET = STMT.executeQuery("SELECT * FROM movies.movies;");
			
				while(RES_SET.next())
				{
					Movie movieInDB = new Movie();
					movieInDB.setMovieID(RES_SET.getString("movie_id"));
					movieInDB.setMovieTitle(RES_SET.getString("title"));
					movieInDB.setMovieRating(RES_SET.getString("rating"));
					movieInDB.setMovieGenre(RES_SET.getString("genre"));
					movieInDB.setMovielength(RES_SET.getString("length"));
				
					ourMovies.add(movieInDB);
				}//while
			
				for (Movie movie : ourMovies) 
				{
					System.out.println(movie.toString());
				}//for
					
		}//try 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
	}//end method
	
	public static void writeToDB(Movie movie)
	{
		Movie movieToAdd = new Movie();
		movieToAdd = movie;
		
		try
		{
			connToDB();
			
			PREP_STMT = CONN.prepareStatement(insertToDB);
			
			PREP_STMT.setString(1, movieToAdd.getMovieTitle());
			PREP_STMT.setString(2, movieToAdd.getMovieRating());
			PREP_STMT.setString(3, movieToAdd.getMovieGenre());
			PREP_STMT.setString(4, movieToAdd.getMovielength());
			
			System.out.println(PREP_STMT);
			
			PREP_STMT.executeUpdate();	
			
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}//end method
	
	private static String insertToDB = "INSERT INTO `movies`.`movies`"
			+ "(title, rating, genre, length)"
			+ "VALUES"
			+ "(?, ?, ?, ?)";
	
	public static Movie aboutTheMovie()
	{
		Movie movieToAdd = new Movie();
		
		System.out.println("Enter the movie's title.");
		movieToAdd.setMovieTitle(sc.nextLine());
		
		System.out.println("Enter the movie's rating.");
		movieToAdd.setMovieRating(sc.nextLine());
		
		System.out.println("Enter the movie's genre.");
		movieToAdd.setMovieGenre(sc.nextLine());
		
		System.out.println("Enter the movie's length.");
		movieToAdd.setMovielength(sc.nextLine());
		
		return movieToAdd;
	}//end method
	
	
	private static String deleteFromDB = "DELETE FROM `movies`.`movies`"
			+ "WHERE"
			+ "(title)"
			+ "= (?)";
	
	
	public static Movie aboutTheMovieDeleted()
	{
		Movie movieToDelete = new Movie();
		
		System.out.println("Enter the movie's title you wish to delete.");
		movieToDelete.setMovieTitle(sc.nextLine());
	
		return movieToDelete;
	}//end method
	
	public static void deleteToDB()
	{
		Movie movieToDelete = new Movie();
		movieToDelete = aboutTheMovieDeleted();
		connToDB();
		try
		{
			PREP_STMT = CONN.prepareStatement(deleteFromDB);
			
			PREP_STMT.setString(1, movieToDelete.getMovieTitle());
			
			
			PREP_STMT.executeUpdate();	
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}//end method
	
	
	private static String modifyfromDB = "UPDATE `movies`.`movies`"
			+ "SET"
			+" rating= ?, genre= ?, length= ?"
			+ " WHERE "
			+ "`title`"
			+ "= ?";
	
	public static Movie aboutTheMovieModified()
	{
		Movie movieToModify = new Movie();
		
		
		System.out.println("Enter the movie's updated rating.");
		movieToModify.setMovieRating(sc.nextLine());
		
		System.out.println("Enter the movie's updated genre.");
		movieToModify.setMovieGenre(sc.nextLine());
		
		System.out.println("Enter the movie's updated length.");
		movieToModify.setMovielength(sc.nextLine());
		
		System.out.println("Enter the movies's title");
		movieToModify.setMovieTitle(sc.nextLine());
		
		return movieToModify;
	}//end method
	
	
	public static void modifyToDB()
	{
		Movie movieToModify = new Movie();
		movieToModify = aboutTheMovieModified();
		connToDB();
		
		try
		{
			PREP_STMT = CONN.prepareStatement(modifyfromDB);
			
			PREP_STMT.setString(1, movieToModify.getMovieRating());
			PREP_STMT.setString(2, movieToModify.getMovieGenre());
			PREP_STMT.setString(3, movieToModify.getMovielength());
			PREP_STMT.setString(4, movieToModify.getMovieTitle());
			
			PREP_STMT.executeUpdate();	
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}//end method
	
}//class
