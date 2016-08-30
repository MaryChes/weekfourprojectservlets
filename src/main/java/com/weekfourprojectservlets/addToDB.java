package com.weekfourprojectservlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.weekfourproject.DAO;
import com.weekfourproject.Movie;

/**
 * Servlet implementation class addToDB
 */
@WebServlet("/addToDB")
public class addToDB extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

    /**  
     * Default constructor. 
     */
    public addToDB() 
    {
    	super ();
        // TODO Auto-generated constructor stub
    }//end method

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}//doGet

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Movie addToDB = new Movie();
		
		addToDB.setMovieTitle(request.getParameter("title"));
		addToDB.setMovieRating(request.getParameter("rating"));
		addToDB.setMovieGenre(request.getParameter("genre"));
		addToDB.setMovielength(request.getParameter("length"));
		
		DAO.writeToDB(addToDB);
	}//doPost

}//end class
