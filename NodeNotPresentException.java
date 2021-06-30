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
 * node with the indicated position variable was not found.
 */
public class NodeNotPresentException extends Exception {
    /**
     * Default constructor for an <CODE>NodeNotPresentException</CODE>
     * that passes a default string to the <CODE>Exception</CODE> class
     * constructor.
     *
     * <dt><b>Postcondition:</b><dd>
     * The object is created and contains the default message.
     */
    public NodeNotPresentException() {  //Default message
        super("Node with indicated position variable was not found.");
    }

    /**
     * Second constructor for the <CODE>NodeNotPresentException</CODE>
     * that passes a provided string to the <CODE>Exception</CODE> class
     * constructor.
     *
     *
     *
     * @param message the message that the object is to contain
     *                <dt><b>Postcondition:</b><dd>
     *                The object is created and contains the provided message.
     */
    public NodeNotPresentException(String message) {   //Passed message
        super(message);
    }
}
