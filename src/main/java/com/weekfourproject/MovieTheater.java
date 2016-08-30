package com.weekfourproject;

import java.util.Scanner;

public class MovieTheater 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		String userMenuInput = null;
		boolean menuCorrect = false;
		
		
		System.out.println("Welcome to the Movie Database");
		
		
		do {
			System.out.println("\tPress 1 to READ from the movie database. "
					+ "\n\tPress 2 to ADD a movie to the database."
					+ "\n\tPress 3 to DELETE a movie from the database."
					+ "\n\tPress 4 to MODIFY a movie in the database.");
			userMenuInput = sc.nextLine();
			switch (userMenuInput)
			{
			case "1":
				DAO.readFromDB();
				break;
				
			case "2":
				//DAO.writeToDB();
				DAO.readFromDB();
				break;
			
			case "3":
				DAO.readFromDB();
				DAO.deleteToDB();
				DAO.readFromDB();
				break;
			case "4":
				DAO.readFromDB();
				DAO.modifyToDB();
				DAO.readFromDB();
				break;
				
			default:
				System.out.println("You've entered an invalid option");
				menuCorrect = true;
			}
		} while (menuCorrect);
		
		sc.close();
	}//main
	
}//class
