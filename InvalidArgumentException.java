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
     * An exception thrown in the <CODE>Set</CODE> class to indicate that the
     * position or String cannot be empty or null.
     */
    public class InvalidArgumentException extends Exception {
        /**
         * Default constructor for an <CODE>InvalidArgumentException</CODE>
         * that passes a default string to the <CODE>Exception</CODE> class
         * constructor.
         *
         * <dt><b>Postcondition:</b><dd>
         * The object is created and contains the default message.
         */
        public InvalidArgumentException() {  //Default message
            super("Position or String cannot be empty or null.");
        }

        /**
         * Second constructor for the <CODE>InvalidArgumentException</CODE>
         * that passes a provided string to the <CODE>Exception</CODE> class
         * constructor.
         *
         * @param message the message that the object is to contain
         *                <dt><b>Postcondition:</b><dd>
         *                The object is created and contains the
         *                provided message.
         */
        public InvalidArgumentException(String message) {   //Passed message
            super(message);
        }
    }
