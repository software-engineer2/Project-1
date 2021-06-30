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

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.zip.DataFormatException;

/**
 * This class is called Zork. The class contains a main
 * method along with two static utility functions,
 * editGame(StoryTree tree) and playGame(StoryTree tree).
 * These are the two functions a user can choose to run,
 * which will allow the user to construct and traverse a
 * StoryTree, respectively. When the program begins, it uses
 * the static function StoryTree.readTree(filename) to build
 * the tree from the file (if the file does not yet, the
 * function should simply return a tree with a single root
 * node.). After constructing the tree, the program should
 * ask the user whether they wish to edit this tree or play
 * a game using this tree.
 */
public class Zork {

    /**
     * Requests the user to enter a file name and builds a tree from
     * the indicated file (if it exists, otherwise uses an empty tree)
     * and asks the user whether they would like to edit this tree (E),
     * play a game based on this tree (P), or exit the program (Q).
     * @param args the supplied command-line arguments as an array of
     *            String objects
     * @throws DataFormatException Thrown if the file contained data
     * inconsistent with the expected data format
     * @throws FileNotFoundException Thrown if the file cannot be found
     * @throws InvalidArgumentException Thrown if the String filename is empty
     * or null.
     * @throws NodeNotPresentException Thrown if a node with the
     * indicated position variable was not found.
     * @throws TreeFullException Thrown if all three child spots are
     * already full
     */
    public static void main(String[] args) throws DataFormatException,
            FileNotFoundException, InvalidArgumentException,
            NodeNotPresentException, TreeFullException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello and Welcome to Zork!");
//        System.out.print("Please enter the file name: ");
        System.out.print("Please enter the file name: \"SampleStory.txt\" without quotes ");
        String filename = scanner.nextLine();
        StoryTree gameTree = StoryTree.readTree(filename);
        System.out.println("Loading game from file...\n" +
                "File loaded!");

        boolean flag = true;

        while (flag) {
//            System.out.print("\nWould you like to edit (E), " +
//                    "play (P) or quit (Q)? ");
            System.out.print("\nPress P to play! Or press Q to quit. ");
            String userChoice = scanner.nextLine();
            if (userChoice.equalsIgnoreCase("q")) {
                flag = false;
            }
            switch (userChoice) {
                case "P":
                    playTree(gameTree);
                    System.out.println("\nThanks for playing.");
                    break;
                case "E":
                    editTree(gameTree);
                    StoryTree.saveTree(filename, gameTree);
                    System.out.print("Game being saved to " + filename + "\n"
                    + "Save successful!");

            }
        }
    }

    /**
     * Provides a user interface allowing a player to play the game
     * represented by tree This method will allow a user to traverse
     * the tree by continually displaying messages and allowing the
     * user to select options until a leaf is reached.
     * @param tree a StoryTree that is used to represent the game
     */
    public static void playTree(StoryTree tree) {
        Scanner input = new Scanner(System.in);
        tree.resetCursor();

        System.out.print(tree.getCursor().getLeftChild().getOption() + "\n"
                + tree.getCursor().getLeftChild().getMessage());
        tree.setCursor(tree.getCursor().getLeftChild());
        System.out.print("\n1)" + tree.getCursor().getLeftChild().getOption()
                + "\n2)" + tree.getCursor().getMiddleChild().getOption()
                + "\n3)" + tree.getCursor().getRightChild().getOption());



        boolean userFlag = true;

        while (userFlag) {
            System.out.print("\nPlease make a choice. ");
            String userInput = input.nextLine();
            if (userInput.equals("1")) {
                tree.setCursor(tree.getCursor().getLeftChild());
                System.out.print(tree.getCursorMessage());
                int x = 1;
                for (int i = 0; i < tree.getChoices().length; i++) {
                    if (tree.getChoices()[i] == null
                            || tree.getChoices()[i].equals("")) {
                        continue;
                    } else {
                        System.out.print("\n" + x
                                + ")" + tree.getChoices()[i]);
                        x++;
                    }
                }

                if (tree.getCursor().isWinningNode()) {
                    userFlag = false;
                }
                if (tree.getCursor().isLosingNode()) {
                    userFlag = false;
                }
            } else if (userInput.equals("2")) {
                tree.setCursor(tree.getCursor().getMiddleChild());
                System.out.print(tree.getCursorMessage());
                int y = 1;
                for (int i = 0; i < tree.getChoices().length; i++) {
                    //for (int j = 0; j < tree.getChoices()[0].length; j++) {
                    if (tree.getChoices()[i] == null
                            || tree.getChoices()[i].equals("")) {
                        continue;
                    } else {
                        System.out.print("\n"
                                + y + ")" + tree.getChoices()[i]);
                        y++;
                    }
                }

                if (tree.getCursor().isWinningNode()) {
                    System.out.print(GameState.GAME_OVER_WIN);
                    userFlag = false;
                }
                if (tree.getCursor().isLosingNode()) {
                    System.out.print(GameState.GAME_OVER_LOSE);
                    userFlag = false;
                }
                } else if (userInput.equals("3")) {

                tree.setCursor(tree.getCursor().getRightChild());
                System.out.print(tree.getCursorMessage());
                int m = tree.getChoices().length;
                int n = 1;
                for (int i = 0; i < tree.getChoices().length; i++) {
                    //for (int j = 0; j < tree.getChoices()[0].length; j++) {
                    if (tree.getChoices()[i] == null
                            || tree.getChoices()[i].equals("")) {
                        continue;
                    } else {
                        System.out.print("\n" + n
                                + ")"  + tree.getChoices()[i]);
                        n++;
                    }
                }

                if (tree.getCursor().isWinningNode()) {
                    System.out.print(GameState.GAME_OVER_WIN);
                    userFlag = false;
                }
                if (tree.getCursor().isLosingNode()) {
                    System.out.print(GameState.GAME_OVER_LOSE);
                    userFlag = false;
                }

            }
        }
    }

    /**
     * Brief:
     * Provides a user interface allowing a user to edit the story
     * followed by the game represented by tree. This function should
     * continue to process user commands until the user enters Q to
     * exit. The following commands should be supported for editing
     * the tree: V - View the cursor's position, option, and message,
     * S - Select a child of the cursor as the new cursor
     * (This option requests which child to descend to (1, 2, or 3)),
     * O - Set the option of the StoryNode referenced by cursor,
     * M - Set the message of the StoryNode referenced by cursor,
     * A - Add a child StoryNode to the cursor, D - Delete a child from
     * the cursor (This option requests which child to delete (1, 2, or 3)),
     * R - Moves the cursor to the root of the tree, and Q - Quit editing
     * the tree and return from the function.
     * @param tree the StoryTree that you are editing
     * @throws NodeNotPresentException Thrown if a node with the
     * indicated position variable was not found.
     * @throws InvalidArgumentException Thrown if the String filename is empty
     * or null.
     * @throws TreeFullException Thrown if all three child spots are
     * already full
     */
    public static void editTree(StoryTree tree) throws NodeNotPresentException,
            InvalidArgumentException, TreeFullException {
        Scanner scan = new Scanner(System.in);
        boolean userEdit = true;
        while (userEdit) {
            System.out.print(
                    "Zork Editor:\n" +
                            "    V: View the cursor's position, option and " +
                            "message.\n" +
                            "    S: Select a child of this cursor (options " +
                            "are 1, 2, and 3).\n" +
                            "    O: Set the option of the cursor.\n" +
                            "    M: Set the message of the cursor.\n" +
                            "    A: Add a child StoryNode to the cursor.\n" +
                            "    D: Delete one of the cursor's " +
                            "children and all its descendants.\n" +
                            "    R: Move the cursor to the root of " +
                            "the tree.\n" +
                            "    Q: Quit editing and return to main menu.\n" +
                            "Please select an option: ");
            String userLetterChoice = scan.nextLine();
            if (userLetterChoice.equalsIgnoreCase("q")) {
                userEdit = false;
            }
            switch (userLetterChoice) {
                case "V":
                    System.out.println("Position: "
                            + tree.getCursorPosition());
                    System.out.println("Option: " + tree.getCursorOption());
                    System.out.println("Message: " + tree.getCursorMessage());
                    break;
                case "S":
                    int numCounter = 0;
                    String numberChildren = "";
                    for (int i = 0; i < 3; i++) {
                        if (tree.getCursorChildrenNumbers()[i] != 0) {
                            numCounter++;
                        }
                    }
                    int[] numArray = new int[numCounter];
                    for (int i = 0; i < 3; i++) {
                        if (tree.getCursorChildrenNumbers()[i] == 0) {
                            continue;
                        } else {
                            numArray[i] = tree.getCursorChildrenNumbers()[i];
                        }
                    }
                    numberChildren += "[";
                    for (int i = 0; i < numArray.length; i++) {
                        numberChildren += numArray[i];
                        if (i < numArray.length - 1) {
                            numberChildren += ", ";
                        }
                    }
                    numberChildren += "]";
                    System.out.print("Please select a child: "
                            + numberChildren );
                    String number = scan.nextLine();

                    if (!numberChildren.contains(number)) {
                        System.out.println("Error. No child " + number +
                                " for the current node.");
                    } else {
                        tree.selectChild(number);
                    }
                    break;
                case "O":
                    System.out.print("Please enter a new option: ");
                    String newOption = scan.nextLine();
                    tree.setCursorOption(newOption);
                    System.out.println("Option set.");
                    break;
                case "M":
                   System.out.print("Please enter a new Message: ");
                   String newMessage = scan.nextLine();
                   tree.setCursorMessage(newMessage);
                   System.out.println("Message set.");
                   break;
                case "A":
                    System.out.print("Enter an option: ");
                    String userOption = scan.nextLine();
                    System.out.print("Enter a message: ");
                    String userMessage = scan.nextLine();
                    tree.addChild(userOption, userMessage);
                    System.out.println("Child added.");
                    break;
                case "D":
                    int counter = 0;
                    String children = "";
                    for (int i = 0; i < 3; i++) {
                        if (tree.getCursorChildrenNumbers()[i] != 0) {
                            counter++;
                        }
                    }
                    int[] arrayOfChildren = new int[counter];
                    for (int i = 0; i < 3; i++) {
                        if (tree.getCursorChildrenNumbers()[i] == 0) {
                            continue;
                        } else {
                            arrayOfChildren[i]
                                    = tree.getCursorChildrenNumbers()[i];
                        }
                    }
                    children += "[";
                    for (int i = 0; i < arrayOfChildren.length; i++) {
                        children += arrayOfChildren[i];
                        if (i < arrayOfChildren.length - 1) {
                            children += ", ";
                        }
                    }
                    children += "]";
                    System.out.print("Please select a child: " + children );
                    String childNumber = scan.nextLine();

                    if (!children.contains(childNumber)) {
                        System.out.println("Error. No child " + childNumber +
                                " for the current node.");
                    } else {
                        tree.removeChild(childNumber);
                        System.out.print("Subtree deleted.");
                    }
                    break;
                case "R":
                    tree.resetCursor();
                    System.out.println("Cursor moved to root.");
                    break;
            }
        }
    }
}