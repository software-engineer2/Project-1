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
 * This class is called StoryTreeNode which represents a segment
 * of the story. The StoryTreeNode class should contain 3 StoryTreeNode
 * references, leftChild, middleChild, and rightChild. In addition, the
 * class contains three String member variables: position, which
 * indicates the position of the node in the tree; option, which
 * represents the text that should be displayed to the user to
 * describe what choice this node represents (this will be read from
 * the parent node), and the message, which is the message displayed
 * when the user chooses this option (i.e: the consequence of taking
 * the option).
 */
public class StoryTreeNode {
    /*
    The purpose of this class is to create 3 StoryTreeNode references:
    leftChild, middleChild, and rightChild.

    Also, this class has 3 strings: position,
    the position of the node in the tree;
    "left child of a node with name "1-2-3" would be "1-2-3-1,
    the middle child of the same node would be "1-2-3-2,
    and the right child of the same node would be "1-2-3-3. "
    option,
    the text displayed to the user to describe what choice this node
    represents (this will be read from the parent node),
    "1) Wake up.
    2) Hit snooze.
    3) Turn off the alarm. "
    message,
   message displayed when user chooses this option
   "It is Monday morning and your alarm goes off. What do you do?"
     */
    private static final String WIN_MESSAGE = "YOU WIN";
    private static final String LOSE_MESSAGE = "YOU LOSE";
    private String position;
    private String option;
    private String message;
    private StoryTreeNode leftChild;
    private StoryTreeNode middleChild;
    private StoryTreeNode rightChild;

    /**
     * Brief:
     * Default constructor for the StoryTreeNode class.
     */
    public StoryTreeNode() {
    }

    /**
     * A custom constructors that takes the Strings position, message,
     * and option
     * @param position the String position that you want to navigate to in
     *                 the tree
     * @param option the String option that you want to show
     * @param message the String message tha you want to display
     */
    public StoryTreeNode(String position, String option, String message) {
        this.position = position;
        this.option = option;
        this.message = message;
    }

    /**
     * A getter for the position
     * @return the String position
     */
    public String getPosition() {
        return position;
    }

    /**
     * A setter for the position
     * @param newPosition the new String position that you want to set
     */
    public void setPosition(String newPosition) {
        this.position = newPosition;
    }

    /**
     * A getter for the option
     * @return the String option
     */
    public String getOption() {
        return option;
    }

    /**
     * A setter for the option
     * @param newOption the new String option that you want to set
     */
    public void setOption(String newOption) {
        this.option = newOption;
    }

    /**
     * A getter for the message
     * @return a String message
     */
    public String getMessage() {
        return message;
    }

    /**
     * A setter for the message
     * @param newMessage the new String message that you want to set
     */
    public void setMessage(String newMessage) {
        this.message = newMessage;
    }

    /**
     * A getter for the left child
     * @return a StoryTreeNode left child
     */
    public StoryTreeNode getLeftChild() {
        return leftChild;
    }

    /**
     * A setter for the left child
     * @param newLeftChild a StoryTreeNode that you want to set as
     *                     the left child
     */
    public void setLeftChild(StoryTreeNode newLeftChild) {
        this.leftChild = newLeftChild;
    }

    /**
     * A getter for the middle child
     * @return a StoryTreeNode middle child
     */
    public StoryTreeNode getMiddleChild() {
        return middleChild;
    }

    /**
     * A setter for the middle child
     * @param newMiddleChild the StoryTreeNode that you want to set as the
     *                       middle child
     */
    public void setMiddleChild(StoryTreeNode newMiddleChild) {
        this.middleChild = newMiddleChild;
    }

    /**
     * A getter for the right child
     * @return A StoryTreeNode right child
     */
    public StoryTreeNode getRightChild() {
        return rightChild;
    }

    /**
     * A setter for the StoryTreeNode right child
     * @param newRightChild the new StoryTreeNode child that you
     *                      want to set
     */
    public void setRightChild(StoryTreeNode newRightChild) {
        this.rightChild = newRightChild;
    }

    /**
     * Brief:
     * Checks if this node has any children.
     * Preconditions:
     * This node is initialized
     * Postconditions:
     * The tree remains unchanged
     * @return a boolean True if there are no children or a boolean
     * False if there is at least one child.
     */
    public boolean isLeaf() {
        boolean leaf = false;
            if(leftChild == null && rightChild == null){
                leaf = true;
            }
        return leaf;
        }

    /**
     * Brief:
     * Checks if this is a winning node. In order to be a winning node,
     * this node must be a leaf and contain the winning message.
     * Preconditions:
     * This node is initialized
     * Postconditions:
     * The tree remains unchanged
     * @return a boolean True if this node is a leaf and
     * contains WIN_MESSAGE in the message or a boolean False otherwise.
     */
    public boolean isWinningNode() {
        boolean winningNode = false;
        if(leftChild == null && rightChild == null
                && message.contains(WIN_MESSAGE)){
            winningNode = true;
        }
        return winningNode;
    }

    /**
     * Brief:
     * Checks if this is a losing node. In order to be a losing node,
     * this node must be a leaf and contain the losing message.
     * Preconditions:
     * This node is initialized
     * Postconditions:
     * The tree remains unchanged
     * @return a boolean True if this node is a leaf and does NOT
     * contain WIN_MESSAGE in the message or a boolean False otherwise.
     */
    public boolean isLosingNode() {
        boolean losingNode = false;
        if (leftChild == null && rightChild == null
                && !message.contains(WIN_MESSAGE)) {
            losingNode = true;
        }
        return losingNode;
    }
}