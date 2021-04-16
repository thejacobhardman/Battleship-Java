/**********************************************************************
*                  Assignment 9 -- Battleship                         *
*                                                                     *
* PROGRAMMER:        Jacob Hardman - hard7293@bears.unco.edu          *
* CLASS:             CS200 – Object Oriented Programming              *
* INSTRUCTOR:        Dean Zeller                                      *
* TERM:              Spring 2021                                      *
* SUBMISSION DATE:   4/16/2021                            		      *
*                                                                     *
* DESCRIPTION:                                                        *
* The following is a tester for the Player object.                    *
*                                                                     *
* COPYRIGHT:                                                          *
* This program is copyright (c)2021 Dean Zeller and Jacob Hardman.    *
*                                                                     *
**********************************************************************/

public class PlayerTester {

	public static void main(String[] args) {
		Player PlayerOne = new Player();
		
		PlayerOne.Place_Aircraft_Carrier(1, 1, 0);
		PlayerOne.Place_Battleship(3, 2, 1);
		PlayerOne.Place_Cruiser(8, 1, 1);
		PlayerOne.Place_Destroyer(6, 7, 1);
		PlayerOne.Place_Submarine(1, 10, 0);
		
		PlayerOne.Run_Until_Close();
	}

}
