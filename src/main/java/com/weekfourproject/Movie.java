package com.weekfourproject;

public class Movie 
{
	private String movieID = null;
	private String movieTitle = null;
	private String movieRating = null;
	private String movieGenre = null;
	private String movielength = null;  
	
	public Movie() 
	{
		super();
	}

	public String getMovieID() 
	{
		return movieID;
	}

	public void setMovieID(String movieID) 
	{
		this.movieID = movieID;
	}

	public String getMovieTitle() 
	{
		return movieTitle;
	}

	public void setMovieTitle(String movieTitle)
	{
		this.movieTitle = movieTitle;
	}

	public String getMovieRating() 
	{
		return movieRating;
	}

	public void setMovieRating(String movieRating)
	{
		this.movieRating = movieRating;
	}

	public String getMovieGenre() 
	{
		return movieGenre;
	}

	public void setMovieGenre(String movieGenre)
	{
		this.movieGenre = movieGenre;
	}

	public String getMovielength() 
	{
		return movielength;
	}

	public void setMovielength(String string) 
	{
		this.movielength = string;
	}

	@Override
	public String toString() 
	{
		return "Movie [movieID=" + movieID + ", movieTitle=" + movieTitle + ", movieRating=" + movieRating
				+ ", movieGenre=" + movieGenre + ", movielength=" + movielength + "]";
	}
	
}//class
