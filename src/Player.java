/**********************************************************************
*                  Assignment 9 -- Battleship                         *
*                                                                     *
* PROGRAMMER:        Jacob Hardman - hard7293@bears.unco.edu          *
* CLASS:             CS200 – Object Oriented Programming              *
* INSTRUCTOR:        Dean Zeller                                      *
* TERM:              Spring 2021                                      *
* SUBMISSION DATE:   4/9/2021		                                  *
*                                                                     *
* DESCRIPTION:                                                        *
* The following is an OOP definition for a Player in a game of        *
* Battleship.                                                         *
*                                                                     *
* ATTRIBUTES:                                                         *
* 	name -- The name of the player, stored as a String.               *
* 	width -- The width of the player's gameboard, stored as an int.	  *
*   height -- The height of the player's gameboard, stored as an int. *
*   playerBoard -- The 2d array that store's the gameboard's values.  *
*   opponentBoard -- The 2d array that store's the opponent's         *
*   gameboard's value.                                                *
*                                                                     *
* COPYRIGHT:                                                          *
* This program is copyright (c)2021 Dean Zeller and Jacob Hardman.    *
*                                                                     *
**********************************************************************/

import java.text.MessageFormat;

public class Player {
	
	private String name;
	private int width;
	private int height;
	private char[][] playerBoard;
	private char[][] opponentBoard;
	
	public Player() {
		this.name = "Player 1";
		this.width = 10;
		this.height = 10;
		this.playerBoard = new char[width][height];
		this.opponentBoard = new char[width][height];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				this.playerBoard[i][j] = '.';
				this.opponentBoard[i][j] = '.';
			}
		}
	}
	
	public void Display_Player_Board() {
		
//		Initial board:   
//			| A  B  C  D  E  F  G  H  I  J |
//		 ---+------------------------------+ 
//		  1 | .  .  .  .  .  .  .  .  .  . | 
//		  2 | .  .  .  .  .  .  .  .  .  . |         a/A – Aircraft Carrier (5) 
//		  3 | .  .  .  .  .  .  .  .  .  . |         b/B – Battleship (4) 
//		  4 | .  .  .  .  .  .  .  .  .  . |         c/C – Cruiser (3) 
//		  5 | .  .  .  .  .  .  .  .  .  . |         s/S – Submarine (3) 
//		  6 | .  .  .  .  .  .  .  .  .  . |         d/D – Destroyer (2) 
//		  7 | .  .  .  .  .  .  .  .  .  . | 
//		  8 | .  .  .  .  .  .  .  .  .  . |          .  - Unexplored 
//		  9 | .  .  .  .  .  .  .  .  .  . |          @  - Missed shot
//		 10 | .  .  .  .  .  .  .  .  .  . |
//		 ---+------------------------------+
		
		System.out.println("   | A  B  C  D  E  F  G  H  I  J |");
		System.out.println("---+------------------------------+");
		for (int i = 0; i < 10; i++) {
			if (i != 9) { System.out.print(MessageFormat.format(" {0} |", i + 1)); } 
			else { System.out.print(MessageFormat.format("{0} |", i + 1)); }
			for (int j = 0; j < 10; j++) {
				System.out.print(MessageFormat.format(" {0} ", this.playerBoard[i][j]));
			}
			System.out.print("|\n");
		}
		System.out.println("---+------------------------------+");
	}
	
	public void Display_Opponent_Board() {
		System.out.println("   | A  B  C  D  E  F  G  H  I  J |");
		System.out.println("---+------------------------------+");
		for (int i = 0; i < 10; i++) {
			if (i != 9) { System.out.print(MessageFormat.format(" {0} |", i + 1)); } 
			else { System.out.print(MessageFormat.format("{0} |", i + 1)); }
			for (int j = 0; j < 10; j++) {
				System.out.print(MessageFormat.format(" {0} ", this.opponentBoard[i][j]));
			}
			System.out.print("|\n");
		}
		System.out.println("---+------------------------------+");
	}
	
	public void Reset_Board() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				this.playerBoard[i][j] = '.';
				this.opponentBoard[i][j] = '.';
			}
		}
	}
	
	

}
