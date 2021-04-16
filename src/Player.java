/**********************************************************************
*                  Assignment 9 -- Battleship                         *
*                                                                     *
* PROGRAMMER:        Jacob Hardman - hard7293@bears.unco.edu          *
* CLASS:             CS200 – Object Oriented Programming              *
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
*                                                                     *
* COPYRIGHT:                                                          *
* This program is copyright (c)2021 Dean Zeller and Jacob Hardman.    *
*                                                                     *
**********************************************************************/

import java.text.MessageFormat;
import java.util.Scanner;

public class Player {
	
	private String name;
	private int width;
	private int height;
	private char[][] playerBoard;
	private char[][] opponentBoard;
	private Scanner input;
	
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
	
	public void Process_Turn(int firstCoordinate, int secondCoordinate) {
		if (this.opponentBoard[firstCoordinate - 1][secondCoordinate - 1] == 'a') {
			this.opponentBoard[firstCoordinate - 1][secondCoordinate - 1] = 'A';
			this.playerBoard[firstCoordinate - 1][secondCoordinate - 1] = 'A';
			System.out.println("Aircraft Carrier Hit!");
		} else if (this.opponentBoard[firstCoordinate - 1][secondCoordinate - 1] == 'b') {
			this.opponentBoard[firstCoordinate - 1][secondCoordinate - 1] = 'B';
			this.playerBoard[firstCoordinate - 1][secondCoordinate - 1] = 'B';
			System.out.println("Battleship Hit!");
		} else if (this.opponentBoard[firstCoordinate - 1][secondCoordinate - 1] == 'c') {
			this.opponentBoard[firstCoordinate - 1][secondCoordinate - 1] = 'C';
			this.playerBoard[firstCoordinate - 1][secondCoordinate - 1] = 'C';
			System.out.println("Cruiser Hit!");
		} else if (this.opponentBoard[firstCoordinate - 1][secondCoordinate - 1] == 's') {
			this.opponentBoard[firstCoordinate - 1][secondCoordinate - 1] = 'S';
			this.playerBoard[firstCoordinate - 1][secondCoordinate - 1] = 'S';
			System.out.println("Submarine Hit!");
		} else if (this.opponentBoard[firstCoordinate - 1][secondCoordinate - 1] == 'd') {
			this.opponentBoard[firstCoordinate - 1][secondCoordinate - 1] = 'D';
			this.playerBoard[firstCoordinate - 1][secondCoordinate - 1] = 'D';
			System.out.println("Destroyer Hit!");
		} else {
			this.playerBoard[firstCoordinate - 1][secondCoordinate - 1] = '@';
			System.out.println("Miss!");
		}
		
		System.out.println("\nTurn Complete.");
	}
	
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
	
	public void Place_Aircraft_Carrier(int firstCoordinate, int secondCoordinate, int direction) {
		if (this.playerBoard[firstCoordinate - 1][secondCoordinate - 1] == '.') {
			boolean validSpot = true;
			
			for (int i = 1; i < 6; i++) {
				if (direction == 0) {
					if (this.playerBoard[secondCoordinate - 1][firstCoordinate - 1 + i] != '.') {
						validSpot = false;
						break;
					}
				} else {
					if (this.playerBoard[secondCoordinate -1 + i][firstCoordinate - 1] != '.') {
						validSpot = false;
						break;
					}
				}
			}
			
			if (validSpot) {
				this.playerBoard[secondCoordinate - 1][firstCoordinate - 1] = 'a';
				for (int i = 1; i < 6; i++) {
					if (direction == 0) {
						this.playerBoard[secondCoordinate - 1][firstCoordinate - 1 + i] = 'a';
					} else {
						this.playerBoard[secondCoordinate -1 + i][firstCoordinate - 1] = 'a';
					}
				}
			} else {
				System.out.println("Please select a spot and direction with enough space to place your ship.");
			}
		} else {
			System.out.println("Please select an empty spot to place your ship.");
		}
	}
	
	public void Place_Battleship(int firstCoordinate, int secondCoordinate, int direction) {
		if (this.playerBoard[firstCoordinate - 1][secondCoordinate - 1] == '.') {
			boolean validSpot = true;
			
			for (int i = 1; i < 5; i++) {
				if (direction == 0) {
					if (this.playerBoard[secondCoordinate - 1][firstCoordinate - 1 + i] != '.') {
						validSpot = false;
						break;
					}
				} else {
					if (this.playerBoard[secondCoordinate - 1 + i][firstCoordinate - 1] != '.') {
						validSpot = false;
						break;
					}
				}
			}
			
			if (validSpot) {
				this.playerBoard[secondCoordinate - 1][firstCoordinate - 1] = 'b';
				for (int i = 1; i < 5; i++) {
					if (direction == 0) {
						this.playerBoard[secondCoordinate - 1][firstCoordinate - 1 + i] = 'b';
					} else {
						this.playerBoard[secondCoordinate - 1 + i][firstCoordinate - 1] = 'b';
					}
				}
			} else {
				System.out.println("Please select a spot and direction with enough space to place your ship.");
			}
		} else {
			System.out.println("Please select an empty spot to place your ship.");
		}
	}
	
	public void Place_Cruiser(int firstCoordinate, int secondCoordinate, int direction) {
		if (this.playerBoard[firstCoordinate - 1][secondCoordinate - 1] == '.') {
			boolean validSpot = true;
			
			for (int i = 1; i < 4; i++) {
				if (direction == 0) {
					if (this.playerBoard[secondCoordinate - 1][firstCoordinate - 1 + i] != '.') {
						validSpot = false;
						break;
					}
				} else {
					if (this.playerBoard[secondCoordinate - 1 + i][firstCoordinate - 1] != '.') {
						validSpot = false;
						break;
					}
				}
			}
			
			if (validSpot) {
				this.playerBoard[secondCoordinate - 1][firstCoordinate - 1] = 'c';
				for (int i = 1; i < 4; i++) {
					if (direction == 0) {
						this.playerBoard[secondCoordinate - 1][firstCoordinate - 1 + i] = 'c';
					} else {
						this.playerBoard[secondCoordinate - 1 + i][firstCoordinate - 1] = 'c';
					}
				}
			} else {
				System.out.println("Please select a spot and direction with enough space to place your ship.");
			}
		} else {
			System.out.println("Please select an empty spot to place your ship.");
		}
	}
	
	public void Place_Submarine(int firstCoordinate, int secondCoordinate, int direction) {
		if (this.playerBoard[firstCoordinate - 1][secondCoordinate - 1] == '.') {
			boolean validSpot = true;
			
			for (int i = 1; i < 3; i++) {
				if (direction == 0) {
					if (this.playerBoard[secondCoordinate - 1][firstCoordinate - 1 + i] != '.') {
						validSpot = false;
						break;
					}
				} else {
					if (this.playerBoard[secondCoordinate -1 + i][firstCoordinate - 1] != '.') {
						validSpot = false;
						break;
					}
				}
			}
			
			if (validSpot) {
				this.playerBoard[secondCoordinate - 1][firstCoordinate - 1] = 's';
				for (int i = 1; i < 3; i++) {
					if (direction == 0) {
						this.playerBoard[secondCoordinate - 1][firstCoordinate - 1 + i] = 's';
					} else {
						this.playerBoard[secondCoordinate - 1 + i][firstCoordinate - 1] = 's';
					}
				}
			} else {
				System.out.println("Please select a spot and direction with enough space to place your ship.");
			}
		} else {
			System.out.println("Please select an empty spot to place your ship.");
		}
	}
	
    public void Place_Destroyer(int firstCoordinate, int secondCoordinate, int direction) {
    	if (this.playerBoard[firstCoordinate - 1][secondCoordinate - 1] == '.') {
			boolean validSpot = true;
			
			for (int i = 1; i < 2; i++) {
				if (direction == 0) {
					if (this.playerBoard[secondCoordinate - 1][firstCoordinate - 1 + i] != '.') {
						validSpot = false;
						break;
					}
				} else {
					if (this.playerBoard[secondCoordinate -1 + i][firstCoordinate - 1] != '.') {
						validSpot = false;
						break;
					}
				}
			}
			
			if (validSpot) {
				this.playerBoard[secondCoordinate - 1][firstCoordinate - 1] = 'd';
				for (int i = 1; i < 2; i++) {
					if (direction == 0) {
						this.playerBoard[secondCoordinate - 1][firstCoordinate - 1 + i] = 'd';
					} else {
						this.playerBoard[secondCoordinate -1 + i][firstCoordinate - 1] = 'd';
					}
				}
			} else {
				System.out.println("Please select a spot and direction with enough space to place your ship.");
			}
		} else {
			System.out.println("Please select an empty spot to place your ship.");
		}
    }
	
	public void Run_Until_Close() {
		boolean isRunning = true;
		while (isRunning) {
			this.Player_Turn();
		}
	}

}
