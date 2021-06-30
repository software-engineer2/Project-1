/*
Debamita Saha
SOLAR ID#: 112494564
debamita.saha@stonybrook.edu
Homework #5
Course: CSE 214
Recitation number: R04
TA's Name: James Finn
*/

package Homework5;

/**
 * This is an enum called GameState. It represents the current state of
 * the game. There are three states: the game is not over, the game is over
 * and the person playing lost, or the game is over and the person playing
 * won.
 */
public enum GameState {
    GAME_OVER_WIN, GAME_OVER_LOSE, GAME_NOT_OVER;

    /**
     * This is a String toString method that displays a String
     * representation of the constants in the enum
     * @return a String representation of the constants in the enum
     */
    public String toString(){
        return super.toString();
    }

}
