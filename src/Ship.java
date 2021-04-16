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
* The following is an OOP definition for a Ship in a game of          *
* Battleship.                                                         *
*                                                                     *
* ATTRIBUTES:                                                         *
* 	name -- The name of the ship, stored as a String.                 *
* 	length -- The number of tiles that the ship takes on the board.   *
*   health -- Tracks the current health of the ship.                  *
*   isDestroyed -- Tracks whether the ship is still alive.            *
*                                                                     *
* COPYRIGHT:                                                          *
* This program is copyright (c)2021 Dean Zeller and Jacob Hardman.    *
*                                                                     *
**********************************************************************/

public class Ship {
	
	private String name;
	private int length;
	private int health;
	private boolean isDestroyed;
	
	public Ship(String name_, int length_) {
		this.name = name_;
		this.length = length_;
		this.health = length_;
		this.isDestroyed = false;
	}
	
	public String Get_Name() {
		return this.name;
	}
	
	public int Get_Length() {
		return this.length;
	}
	
	public int Get_Health() {
		return this.health;
	}
	
	public boolean Get_Is_Destroyed() {
		return this.isDestroyed;
	}
	
	public void Take_Damage() {
		this.health--;
		if (this.health == 0) {
			this.isDestroyed = true;
		}
	}

}
