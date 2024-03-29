/**********************************************************************
*                  Assignment 9 -- Battleship                         *
*                                                                     *
* PROGRAMMER:        Jacob Hardman - hard7293@bears.unco.edu          *
* CLASS:             CS200 � Object Oriented Programming              *
* INSTRUCTOR:        Dean Zeller                                      *
* TERM:              Spring 2021                                      *
* SUBMISSION DATE:   4/16/2021		                                  *
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
*   scanner -- The Scanner Java util that is used to capture user     *
*   input.                                                            *
*                                                                     *
* COPYRIGHT:                                                          *
* This program is copyright (c)2021 Dean Zeller and Jacob Hardman.    *
*                                                                     *
**********************************************************************/

import java.text.MessageFormat;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Player {
	
	private String name;
	private int width;
	private int height;
	private char[][] playerBoard;
	private char[][] opponentBoard;
	private Scanner input;
	
	/***********************************************************************
	 * Method:   Constructor (all parameters)                               *
	 * Purpose:  Create a Player object with default parameters.            *
	 * Parameters: None.                                                    *
	 * Return value: None                                                   *
	 ***********************************************************************/
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
		this.input = new Scanner(System.in);
	}
	
	/************************************************************************
	 * Method: Display_Player_Board                                         *
	 * Purpose:  Displays the player's board.                               *
	 * Parameters: None                                                     *
	 * Return value: None                                                   *
	 ***********************************************************************/
	public void Display_Player_Board() {
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
	
	/************************************************************************
	 * Method: Display_Opponent_Board                                       *
	 * Purpose:  Displays the opponent's board.                             *
	 * Parameters: None                                                     *
	 * Return value: None                                                   *
	 ***********************************************************************/
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
	
	/************************************************************************
	 * Method: Reset_Board                                                  *
	 * Purpose:  Resets both player's boards.                               *
	 * Parameters: None                                                     *
	 * Return value: None                                                   *
	 ***********************************************************************/
	public void Reset_Board() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				this.playerBoard[i][j] = '.';
				this.opponentBoard[i][j] = '.';
			}
		}
	}
	
	/************************************************************************
	 * Method: Process_Turn                                                 *
	 * Purpose: Takes in the user's guess and checks to see if a hit        *
	 * 		    has been made.                                              *
	 * Parameters:                                                          *
	 *   firstCoordinate -- The first coordinate used to specify which      *
	 *   	space on the board to check.                                    *
	 *   secondCoordinate -- The second coordinate used to specify which    *
	 *   	space on the board to check.                                    *
	 * Return value: None                                                   *
	 ***********************************************************************/
	public void Process_Turn(int firstCoordinate, int secondCoordinate) {
		if (this.opponentBoard[firstCoordinate - 1][secondCoordinate - 1] == 'a') {
			this.opponentBoard[firstCoordinate - 1][secondCoordinate - 1] = 'A';
			this.playerBoard[firstCoordinate - 1][secondCoordinate - 1] = 'A';
			System.out.println("Aircraft Carrier Hit!");
			if (this.Check_If_AC_Destroyed() == true) {
				System.out.println("You sunk my Aircraft Carrier!");
			}
		} else if (this.opponentBoard[firstCoordinate - 1][secondCoordinate - 1] == 'b') {
			this.opponentBoard[firstCoordinate - 1][secondCoordinate - 1] = 'B';
			this.playerBoard[firstCoordinate - 1][secondCoordinate - 1] = 'B';
			System.out.println("Battleship Hit!");
			if (this.Check_If_Battleship_Destroyed() == true) {
				System.out.println("You sunk my Battleship!");
			}
		} else if (this.opponentBoard[firstCoordinate - 1][secondCoordinate - 1] == 'c') {
			this.opponentBoard[firstCoordinate - 1][secondCoordinate - 1] = 'C';
			this.playerBoard[firstCoordinate - 1][secondCoordinate - 1] = 'C';
			System.out.println("Cruiser Hit!");
			if (this.Check_If_Cruiser_Destroyed() == true) {
				System.out.println("You sunk my Cruiser!");
			}
		} else if (this.opponentBoard[firstCoordinate - 1][secondCoordinate - 1] == 's') {
			this.opponentBoard[firstCoordinate - 1][secondCoordinate - 1] = 'S';
			this.playerBoard[firstCoordinate - 1][secondCoordinate - 1] = 'S';
			System.out.println("Submarine Hit!");
			if (this.Check_If_Sub_Destroyed() == true) {
				System.out.println("You sunk my Submarine!");
			}
		} else if (this.opponentBoard[firstCoordinate - 1][secondCoordinate - 1] == 'd') {
			this.opponentBoard[firstCoordinate - 1][secondCoordinate - 1] = 'D';
			this.playerBoard[firstCoordinate - 1][secondCoordinate - 1] = 'D';
			System.out.println("Destroyer Hit!");
			if (this.Check_If_Destroyer_Destroyed() == true) {
				System.out.println("You sunk my Destroyer!");
			}
		} else {
			this.playerBoard[firstCoordinate - 1][secondCoordinate - 1] = '@';
			System.out.println("Miss!");
		}
		
		System.out.println("\nTurn Complete.");
	}
	
	/************************************************************************
	 * Method: Check_If_AC_Destroyed                                        *
	 * Purpose: Checks to see if the Aircraft Carrier has been destroyed.   *
	 * Parameters: None.                                                    *
	 * Return value:                                                        *
	 * 		isDestroyed -- Boolean value denoting whether the ship has      *
	 * 					   been destroyed.                                  *
	 ***********************************************************************/
	public boolean Check_If_AC_Destroyed() {
		boolean isDestroyed = true;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (this.opponentBoard[i][j] == 'a') {
					isDestroyed = false;
					break;
				}
			}
		}
		return isDestroyed;
	}
	
	/************************************************************************
	 * Method: Check_If_Battleship_Destroyed                                *
	 * Purpose: Checks to see if the Battleship has been destroyed.         *
	 * Parameters: None.                                                    *
	 * Return value:                                                        *
	 * 		isDestroyed -- Boolean value denoting whether the ship has      *
	 * 					   been destroyed.                                  *
	 ***********************************************************************/
	public boolean Check_If_Battleship_Destroyed() {
		boolean isDestroyed = true;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (this.opponentBoard[i][j] == 'b') {
					isDestroyed = false;
					break;
				}
			}
		}
		return isDestroyed;
	}
	
	/************************************************************************
	 * Method: Check_If_Cruiser_Destroyed                                   *
	 * Purpose: Checks to see if the Cruiser has been destroyed.            *
	 * Parameters: None.                                                    *
	 * Return value:                                                        *
	 * 		isDestroyed -- Boolean value denoting whether the ship has      *
	 * 					   been destroyed.                                  *
	 ***********************************************************************/
	public boolean Check_If_Cruiser_Destroyed() {
		boolean isDestroyed = true;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (this.opponentBoard[i][j] == 'c') {
					isDestroyed = false;
					break;
				}
			}
		}
		return isDestroyed;
	}
	
	/************************************************************************
	 * Method: Check_If_Sub_Destroyed                                       *
	 * Purpose: Checks to see if the Submarine has been destroyed.          *
	 * Parameters: None.                                                    *
	 * Return value:                                                        *
	 * 		isDestroyed -- Boolean value denoting whether the ship has      *
	 * 					   been destroyed.                                  *
	 ***********************************************************************/
	public boolean Check_If_Sub_Destroyed() {
		boolean isDestroyed = true;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (this.opponentBoard[i][j] == 's') {
					isDestroyed = false;
					break;
				}
			}
		}
		return isDestroyed;
	}
	
	/************************************************************************
	 * Method: Check_If_Destroyer_Destroyed                                 *
	 * Purpose: Checks to see if the Destroyer has been destroyed.          *
	 * Parameters: None.                                                    *
	 * Return value:                                                        *
	 * 		isDestroyed -- Boolean value denoting whether the ship has      *
	 * 					   been destroyed.                                  *
	 ***********************************************************************/
	public boolean Check_If_Destroyer_Destroyed() {
		boolean isDestroyed = true;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (this.opponentBoard[i][j] == 'd') {
					isDestroyed = false;
					break;
				}
			}
		}
		return isDestroyed;
	}
	
	/************************************************************************
	 * Method: Validate_First_Coordinate                                    *
	 * Purpose: Validates whether the user has entered a valid              *
	 * 			first coordinate.                                           *
	 * Parameters:                                                          *
	 * 		firstCoordinate -- The first coordinate used to specify a space *
	 * 		                   on the gameboard. Corresponds to the Letter  *
	 * 						   axis.                                        *
	 * Return value:                                                        *
	 * 		isDestroyed -- Boolean value denoting whether the user has      *
	 * 					   entered a valid coordinate.                      *
	 ***********************************************************************/
	public boolean Validate_First_Coordinate(String firstCoordinate) {
		boolean validInput = false;
		
		if (firstCoordinate.toUpperCase().equals("A") ||
				firstCoordinate.toUpperCase().equals("B") ||
				firstCoordinate.toUpperCase().equals("C") ||
				firstCoordinate.toUpperCase().equals("D") ||
				firstCoordinate.toUpperCase().equals("E") ||
				firstCoordinate.toUpperCase().equals("F") ||
				firstCoordinate.toUpperCase().equals("G") ||
				firstCoordinate.toUpperCase().equals("H") ||
				firstCoordinate.toUpperCase().equals("I") ||
				firstCoordinate.toUpperCase().equals("J")) {
			validInput = true;
		}
		
		return validInput;
	}
	
	/************************************************************************
	 * Method: Validate_Second_Coordinate                                   *
	 * Purpose: Validates whether the user has entered a valid              *
	 * 			second coordinate.                                          *
	 * Parameters:                                                          *
	 * 	   firstCoordinate -- The second coordinate used to specify a space *
	 * 		                  on the gameboard. Corresponds to the Letter   *
	 * 						  axis.                                         *
	 * Return value:                                                        *
	 * 		isDestroyed -- Boolean value denoting whether the user has      *
	 * 					   entered a valid coordinate.                      *
	 ***********************************************************************/
	public boolean Validate_Second_Coordinate(String secondCoordinate) {
		boolean validInput = true;
		int convertedInput = 0;
		
		try {
			convertedInput = Integer.parseInt(secondCoordinate);
		} catch (Exception e) {
			validInput = false;
		}
		
		if (convertedInput < 1 || convertedInput > 10) {
			validInput = false;
		}
		
		return validInput;
	}
	
	/************************************************************************
	 * Method: Convert_Input                                                *
	 * Purpose: Converts the user's first coordinate input from a letter    *
	 * 			into an integer value.                                      *
	 * Parameters:                                                          *
	 * 	   input -- The user's first input coordinate as a String.          *
	 * Return value: The converted input as an integer.                     *
	 ***********************************************************************/
	public int Convert_Input(String input) {
		if (input.toUpperCase().equals("A")) { return 1; }
		else if (input.toUpperCase().equals("B")) { return 2; }
		else if (input.toUpperCase().equals("C")) { return 3; }
		else if (input.toUpperCase().equals("D")) { return 4; }
		else if (input.toUpperCase().equals("E")) { return 5; }
		else if (input.toUpperCase().equals("F")) { return 6; }
		else if (input.toUpperCase().equals("G")) { return 7; }
		else if (input.toUpperCase().equals("H")) { return 8; }
		else if (input.toUpperCase().equals("I")) { return 9; }
		else if (input.toUpperCase().equals("J")) { return 10; }
		else { return 0; }
	}
	
	/************************************************************************
	 * Method: Player_Turn                                                  *
	 * Purpose: Accepts input from the user to process a turn.              *
	 * Parameters: None.                                                    *          
	 * Return value: None.                                                  *
	 ***********************************************************************/
	public void Player_Turn() {
		System.out.println("\n" + this.name + "'s Turn.");
		this.Display_Player_Board();
		
		boolean validInput = false;
		while (!validInput) {
			System.out.print("\nCoordinates: ");
			String coordinates = this.input.nextLine();
			String[] fullCoordinates = coordinates.split("");
			
			if (fullCoordinates.length <= 3) {
				String firstCoordinatePart = fullCoordinates[0];
				String secondCoordinatePart = "";
				
				if (fullCoordinates.length == 2) { secondCoordinatePart = fullCoordinates[1]; }
				else { secondCoordinatePart = fullCoordinates[1] + fullCoordinates[2]; }
				
				if (this.Validate_First_Coordinate(firstCoordinatePart) == true && this.Validate_Second_Coordinate(secondCoordinatePart) == true) {
					int firstCoordinate = this.Convert_Input(firstCoordinatePart);
					int secondCoordinate = Integer.parseInt(secondCoordinatePart);
					this.Process_Turn(secondCoordinate, firstCoordinate); //Had to flip the two coordinates based on how the 2d array works
					validInput = true;
				} else {
					System.out.println("Please enter valid coordinates.");
				}
			} else {
				System.out.println("Please enter the coordinates that you'd like to fire on.");
			}
		}
		
	}
	
	/************************************************************************
	 * Method: Place_Aircraft_Carrier                                       *
	 * Purpose: Takes in coordinates, validates them, and then places       *
	 * 			the ship on the board.                                      *
	 * Parameters:                                                          *
	 *   firstCoordinate -- The first coordinate used to specify which      *
	 *   	space on the board to place the ship.                           *
	 *   secondCoordinate -- The second coordinate used to specify which    *
	 *   	space on the board to place the ship.                           *
	 *   direction -- Integer which denotes whether the ship should be      *
	 *   			  placed vertically or horizontally.                    *
	 * Return value: Boolean denoting whether or not the ship has been      *
	 * 				 been placed in a valid space on the board.             *
	 ***********************************************************************/
	public boolean Place_Aircraft_Carrier(int firstCoordinate, int secondCoordinate, int direction) {
		boolean validSpot = true;
		if (this.opponentBoard[secondCoordinate - 1][firstCoordinate - 1] == '.') {
			for (int i = 1; i < 5; i++) {
				if (direction == 0) {
					if (firstCoordinate > 5) {
						if (this.opponentBoard[secondCoordinate - 1][firstCoordinate - 1 - i] != '.') {
							validSpot = false;
							break;
						}
					} else {
						if (this.opponentBoard[secondCoordinate - 1][firstCoordinate - 1 + i] != '.') {
							validSpot = false;
							break;
						}
					}
				} else {
					if (secondCoordinate > 5) {
						if (this.opponentBoard[secondCoordinate -1 - i][firstCoordinate - 1] != '.') {
							validSpot = false;
							break;
						}
					} else {
						if (this.opponentBoard[secondCoordinate -1 + i][firstCoordinate - 1] != '.') {
							validSpot = false;
							break;
						}
					}
				}
			}
			
			if (validSpot) {
				this.opponentBoard[secondCoordinate - 1][firstCoordinate - 1] = 'a';
				for (int i = 1; i < 5; i++) {
					if (direction == 0) {
						if (firstCoordinate > 5) {
							this.opponentBoard[secondCoordinate - 1][firstCoordinate - 1 - i] = 'a';
						} else {
							this.opponentBoard[secondCoordinate - 1][firstCoordinate - 1 + i] = 'a';
						}
					} else {
						if (secondCoordinate > 5) {
							this.opponentBoard[secondCoordinate -1 - i][firstCoordinate - 1] = 'a';
						} else {
							this.opponentBoard[secondCoordinate -1 + i][firstCoordinate - 1] = 'a';
						}
					}
				}
			} else {
				System.out.println("Please select a spot and direction with enough space to place your ship.");
				validSpot = false;
			}
		} else {
			System.out.println("Please select an empty spot to place your ship.");
			validSpot = false;
		}
		
		return validSpot;
	}
	
	/************************************************************************
	 * Method: Place_Battleship                                             *
	 * Purpose: Takes in coordinates, validates them, and then places       *
	 * 			the ship on the board.                                      *
	 * Parameters:                                                          *
	 *   firstCoordinate -- The first coordinate used to specify which      *
	 *   	space on the board to place the ship.                           *
	 *   secondCoordinate -- The second coordinate used to specify which    *
	 *   	space on the board to place the ship.                           *
	 *   direction -- Integer which denotes whether the ship should be      *
	 *   			  placed vertically or horizontally.                    *
	 * Return value: Boolean denoting whether or not the ship has been      *
	 * 				 been placed in a valid space on the board.             *
	 ***********************************************************************/
	public boolean Place_Battleship(int firstCoordinate, int secondCoordinate, int direction) {
		boolean validSpot = true;
		if (this.opponentBoard[secondCoordinate - 1][firstCoordinate - 1] == '.') {
			for (int i = 1; i < 4; i++) {
				if (direction == 0) {
					if (firstCoordinate > 6) {
						if (this.opponentBoard[secondCoordinate - 1][firstCoordinate - 1 - i] != '.') {
							validSpot = false;
							break;
						}
					} else {
						if (this.opponentBoard[secondCoordinate - 1][firstCoordinate - 1 + i] != '.') {
							validSpot = false;
							break;
						}
					}
				} else {
					if (secondCoordinate > 6) {
						if (this.opponentBoard[secondCoordinate - 1 - i][firstCoordinate - 1] != '.') {
							validSpot = false;
							break;
						}
					} else {
						if (this.opponentBoard[secondCoordinate - 1 + i][firstCoordinate - 1] != '.') {
							validSpot = false;
							break;
						}
					}
				}
			}
			
			if (validSpot) {
				this.opponentBoard[secondCoordinate - 1][firstCoordinate - 1] = 'b';
				for (int i = 1; i < 4; i++) {
					if (direction == 0) {
						if (firstCoordinate > 6) {
							this.opponentBoard[secondCoordinate - 1][firstCoordinate - 1 - i] = 'b';
						} else {
							this.opponentBoard[secondCoordinate - 1][firstCoordinate - 1 + i] = 'b';
						}
					} else {
						if (secondCoordinate > 6) {
							this.opponentBoard[secondCoordinate - 1 - i][firstCoordinate - 1] = 'b';
						} else {
							this.opponentBoard[secondCoordinate - 1 + i][firstCoordinate - 1] = 'b';
						}
					}
				}
			} else {
				System.out.println("Please select a spot and direction with enough space to place your ship.");
				validSpot = false;
			}
		} else {
			System.out.println("Please select an empty spot to place your ship.");
			validSpot = false;
		}
		
		return validSpot;
	}
	
	/************************************************************************
	 * Method: Place_Cruiser                                                *
	 * Purpose: Takes in coordinates, validates them, and then places       *
	 * 			the ship on the board.                                      *
	 * Parameters:                                                          *
	 *   firstCoordinate -- The first coordinate used to specify which      *
	 *   	space on the board to place the ship.                           *
	 *   secondCoordinate -- The second coordinate used to specify which    *
	 *   	space on the board to place the ship.                           *
	 *   direction -- Integer which denotes whether the ship should be      *
	 *   			  placed vertically or horizontally.                    *
	 * Return value: Boolean denoting whether or not the ship has been      *
	 * 				 been placed in a valid space on the board.             *
	 ***********************************************************************/
	public boolean Place_Cruiser(int firstCoordinate, int secondCoordinate, int direction) {
		boolean validSpot = true;
		if (this.opponentBoard[secondCoordinate - 1][firstCoordinate - 1] == '.') {
			for (int i = 1; i < 3; i++) {
				if (direction == 0) {
					if (firstCoordinate > 7) {
						if (this.opponentBoard[secondCoordinate - 1][firstCoordinate - 1 - i] != '.') {
							validSpot = false;
							break;
						}
					} else {
						if (this.opponentBoard[secondCoordinate - 1][firstCoordinate - 1 + i] != '.') {
							validSpot = false;
							break;
						}
					}
				} else {
					if (secondCoordinate > 7) {
						if (this.opponentBoard[secondCoordinate - 1 - i][firstCoordinate - 1] != '.') {
							validSpot = false;
							break;
						}
					} else {
						if (this.opponentBoard[secondCoordinate - 1 + i][firstCoordinate - 1] != '.') {
							validSpot = false;
							break;
						}
					}
				}
			}
			
			if (validSpot) {
				this.opponentBoard[secondCoordinate - 1][firstCoordinate - 1] = 'c';
				for (int i = 1; i < 3; i++) {
					if (direction == 0) {
						if (firstCoordinate > 7) {
							this.opponentBoard[secondCoordinate - 1][firstCoordinate - 1 - i] = 'c';
						} else {
							this.opponentBoard[secondCoordinate - 1][firstCoordinate - 1 + i] = 'c';
						}
					} else {
						if (secondCoordinate > 7) {
							this.opponentBoard[secondCoordinate - 1 - i][firstCoordinate - 1] = 'c';
						} else {
							this.opponentBoard[secondCoordinate - 1 + i][firstCoordinate - 1] = 'c';
						}
					}
				}
			} else {
				System.out.println("Please select a spot and direction with enough space to place your ship.");
				validSpot = false;
			}
		} else {
			System.out.println("Please select an empty spot to place your ship.");
			validSpot = false;
		}
		
		return validSpot;
	}
	
	/************************************************************************
	 * Method: Place_Submarine                                              *
	 * Purpose: Takes in coordinates, validates them, and then places       *
	 * 			the ship on the board.                                      *
	 * Parameters:                                                          *
	 *   firstCoordinate -- The first coordinate used to specify which      *
	 *   	space on the board to place the ship.                           *
	 *   secondCoordinate -- The second coordinate used to specify which    *
	 *   	space on the board to place the ship.                           *
	 *   direction -- Integer which denotes whether the ship should be      *
	 *   			  placed vertically or horizontally.                    *
	 * Return value: Boolean denoting whether or not the ship has been      *
	 * 				 been placed in a valid space on the board.             *
	 ***********************************************************************/
	public boolean Place_Submarine(int firstCoordinate, int secondCoordinate, int direction) {
		boolean validSpot = true;
		if (this.opponentBoard[secondCoordinate - 1][firstCoordinate - 1] == '.') {
			for (int i = 1; i < 3; i++) {
				if (direction == 0) {
					if (firstCoordinate > 8) {
						if (this.opponentBoard[secondCoordinate - 1][firstCoordinate - 1 - i] != '.') {
							validSpot = false;
							break;
						}
					} else {
						if (this.opponentBoard[secondCoordinate - 1][firstCoordinate - 1 + i] != '.') {
							validSpot = false;
							break;
						}
					}
				} else {
					if (secondCoordinate > 8) {
						if (this.opponentBoard[secondCoordinate -1 - i][firstCoordinate - 1] != '.') {
							validSpot = false;
							break;
						}
					} else {
						if (this.opponentBoard[secondCoordinate -1 + i][firstCoordinate - 1] != '.') {
							validSpot = false;
							break;
						}
					}
				}
			}
			
			if (validSpot) {
				this.opponentBoard[secondCoordinate - 1][firstCoordinate - 1] = 's';
				for (int i = 1; i < 3; i++) {
					if (direction == 0) {
						if (firstCoordinate > 8) {
							this.opponentBoard[secondCoordinate - 1][firstCoordinate - 1 - i] = 's';
						} else {
							this.opponentBoard[secondCoordinate - 1][firstCoordinate - 1 + i] = 's';
						}
					} else {
						if (secondCoordinate > 8) {
							this.opponentBoard[secondCoordinate - 1 - i][firstCoordinate - 1] = 's';
						} else {
							this.opponentBoard[secondCoordinate - 1 + i][firstCoordinate - 1] = 's';
						}
					}
				}
			} else {
				System.out.println("Please select a spot and direction with enough space to place your ship.");
				validSpot = false;
			}
		} else {
			System.out.println("Please select an empty spot to place your ship.");
			validSpot = false;
		}
		
		return validSpot;
	}
	
	/************************************************************************
	 * Method: Place_Destroyer                                              *
	 * Purpose: Takes in coordinates, validates them, and then places       *
	 * 			the ship on the board.                                      *
	 * Parameters:                                                          *
	 *   firstCoordinate -- The first coordinate used to specify which      *
	 *   	space on the board to place the ship.                           *
	 *   secondCoordinate -- The second coordinate used to specify which    *
	 *   	space on the board to place the ship.                           *
	 *   direction -- Integer which denotes whether the ship should be      *
	 *   			  placed vertically or horizontally.                    *
	 * Return value: Boolean denoting whether or not the ship has been      *
	 * 				 been placed in a valid space on the board.             *
	 ***********************************************************************/
    public boolean Place_Destroyer(int firstCoordinate, int secondCoordinate, int direction) {
    	boolean validSpot = true;
    	if (this.opponentBoard[secondCoordinate - 1][firstCoordinate - 1] == '.') {
			for (int i = 1; i < 2; i++) {
				if (direction == 0) {
					if (firstCoordinate > 9) {
						if (this.opponentBoard[secondCoordinate - 1][firstCoordinate - 1 - i] != '.') {
							validSpot = false;
							break;
						}
					} else {
						if (this.opponentBoard[secondCoordinate - 1][firstCoordinate - 1 + i] != '.') {
							validSpot = false;
							break;
						}
					}
				} else {
					if (secondCoordinate > 9) {
						if (this.opponentBoard[secondCoordinate -1 - i][firstCoordinate - 1] != '.') {
							validSpot = false;
							break;
						}
					} else {
						if (this.opponentBoard[secondCoordinate -1 + i][firstCoordinate - 1] != '.') {
							validSpot = false;
							break;
						}
					}
				}
			}
			
			if (validSpot) {
				this.opponentBoard[secondCoordinate - 1][firstCoordinate - 1] = 'd';
				for (int i = 1; i < 2; i++) {
					if (direction == 0) {
						if (firstCoordinate > 9) {
							this.opponentBoard[secondCoordinate - 1][firstCoordinate - 1 - i] = 'd';
						} else {
							this.opponentBoard[secondCoordinate - 1][firstCoordinate - 1 + i] = 'd';
						}
					} else {
						if (secondCoordinate > 9) {
							this.opponentBoard[secondCoordinate -1 - i][firstCoordinate - 1] = 'd';
						} else {
							this.opponentBoard[secondCoordinate -1 + i][firstCoordinate - 1] = 'd';
						}
					}
				}
			} else {
				System.out.println("Please select a spot and direction with enough space to place your ship.");
				validSpot = false;
			}
		} else {
			System.out.println("Please select an empty spot to place your ship.");
			validSpot = false;
		}
    	
    	return validSpot;
    }
	
    /************************************************************************
	 * Method: Place_Ships                                                  *
	 * Purpose: Takes in user input, to be used as coordinates in order     *
	 *          to place ships on the board.                                *
	 * Parameters: None.                                                    *
	 * Return value: None.                                                  *
	 ***********************************************************************/
    public void Place_Ships() {
    	boolean validInput = false;
    	int firstCoordinate = 0, secondCoordinate = 0, direction = 0;
    	String[] shipNames = { "Aircraft Carrier", "Battleship", "Cruiser", "Submarine", "Destroyer" };
    	for (int i = 0; i < 5; i++) {
    		boolean validSpot = false;
    		while (!validSpot) {
    			validInput = false;
        		while (!validInput) {
            		System.out.print("\nPlease enter the origin coordinate that you'd like to place your " + shipNames[i] + " in: ");
                	String origin = this.input.nextLine();
                	String[] fullCoordinates = origin.split("");
            		
            		if (fullCoordinates.length <= 3) {
            			String firstCoordinatePart = fullCoordinates[0];
            			String secondCoordinatePart = "";
            			
            			if (fullCoordinates.length == 2) { secondCoordinatePart = fullCoordinates[1]; }
            			else { secondCoordinatePart = fullCoordinates[1] + fullCoordinates[2]; }
            			
            			if (this.Validate_First_Coordinate(firstCoordinatePart) == true && this.Validate_Second_Coordinate(secondCoordinatePart) == true) {
            			    firstCoordinate = this.Convert_Input(firstCoordinatePart);
            				secondCoordinate = Integer.parseInt(secondCoordinatePart);
            				validInput = true;
            			} else {
            				System.out.println("Please enter valid coordinates.");
            			}
            		} else {
            			System.out.println("Please enter the coordinates that you'd your ship to be placed.");
            		}
            	}
        		
        		validInput = false;
        		while (!validInput) {
        			System.out.print("\nPlease enter '1' if you'd like your ship to be placed vertically, or '0' if you'd like your ship to be placed horizontally: ");
        			String orientation = this.input.nextLine();
        			
        			if (orientation.equals("1")) {
        				direction = 1;
        				validInput = true;
        			} else if (orientation.equals("0")) {
        				direction = 0;
        				validInput = true;
        			} else {
        				System.out.println("Please enter a valid selection.");
        			}
        		}
        		
        		if (i == 0) {
        			if (this.Place_Aircraft_Carrier(firstCoordinate, secondCoordinate, direction) == true) {
            			System.out.println("Placing Aircraft Carrier...");
            			validSpot = true;
        			} 
        		} else if (i == 1) {
        			if (this.Place_Battleship(firstCoordinate, secondCoordinate, direction) == true) {
            			System.out.println("Placing Battleship...");
            			validSpot = true;
        			}
        		} else if (i == 2) {
        			if (this.Place_Cruiser(firstCoordinate, secondCoordinate, direction)) {
            			System.out.println("Placing Cruiser...");
            			validSpot = true;
        			}
        		} else if (i == 3) {
        			if (this.Place_Submarine(firstCoordinate, secondCoordinate, direction) == true) {
            			System.out.println("Placing Submarine...");
            			validSpot = true;
        			}
        		} else if (i == 4) {
        			if (this.Place_Destroyer(firstCoordinate, secondCoordinate, direction) == true) {
            			System.out.println("Placing Destroyer...");
            			validSpot = true;
        			}
        		}
    		}
    	}
    }
    
    /************************************************************************
	 * Method: Random_Place_Ships                                           *
	 * Purpose: Generates random coordinates to be used to place ships on   *
	 * 			random spots on the board.                                  *
	 * Parameters: None.                                                    *
	 * Return value: None.                                                  *
	 ***********************************************************************/
    public void Random_Place_Ships() {
    	for (int i = 0; i < 5; i++) {
    		boolean validSpot = false;
    		while (!validSpot) {
    			int firstCoordinate = ThreadLocalRandom.current().nextInt(1, 11);
        		int secondCoordinate = ThreadLocalRandom.current().nextInt(1, 11);
        		int direction = ThreadLocalRandom.current().nextInt(0, 2);
        		
        		if (i == 0) {
        			if (this.Place_Aircraft_Carrier(firstCoordinate, secondCoordinate, direction) == true) {
            			validSpot = true;
        			} 
        		} else if (i == 1) {
        			if (this.Place_Battleship(firstCoordinate, secondCoordinate, direction) == true) {
            			validSpot = true;
        			}
        		} else if (i == 2) {
        			if (this.Place_Cruiser(firstCoordinate, secondCoordinate, direction)) {
            			validSpot = true;
        			}
        		} else if (i == 3) {
        			if (this.Place_Submarine(firstCoordinate, secondCoordinate, direction) == true) {
            			validSpot = true;
        			}
        		} else if (i == 4) {
        			if (this.Place_Destroyer(firstCoordinate, secondCoordinate, direction) == true) {
            			validSpot = true;
        			}
        		}
    		}
    	}
    	System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }
    
    /************************************************************************
	 * Method: Check_For_Game_Over                                          *
	 * Purpose: Checks the board to see whether there are any ships still   *
	 * 			alive.                                                      *
	 * Parameters: None.                                                    *
	 * Return value: Boolean value denoting whether or not the game has     * 
	 * 				 ended.                                                 *
	 ***********************************************************************/
    public boolean Check_For_Game_Over() {
    	boolean isGameOver = true;
    	for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (this.opponentBoard[i][j] == 'a' ||
						this.opponentBoard[i][j] == 'b' ||
						this.opponentBoard[i][j] == 'c' ||
						this.opponentBoard[i][j] == 's' ||
						this.opponentBoard[i][j] == 'd') {
					isGameOver = false;
				}
			}
		}
    	return isGameOver;
    }
    
    /************************************************************************
	 * Method: Run_Until_Close                                              *
	 * Purpose: Keeps the game running until the win conditions have been   *
	 * 			met.                                                        *
	 * Parameters: None.                                                    *
	 * Return value: None.                                                  *
	 ***********************************************************************/
	public void Run_Until_Close() {
		boolean isRunning = true;
		int numOfGuesses = 0;
		this.Random_Place_Ships();
		while (isRunning) {
			this.Player_Turn();
			if (this.Check_For_Game_Over() == true) {
				isRunning = false;
			}
			numOfGuesses++;
		}
		System.out.println("\nGAME OVER!!!");
		System.out.println("It took you " + numOfGuesses + " guesses to win.");
	}

}
