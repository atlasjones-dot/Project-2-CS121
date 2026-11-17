import java.util.Scanner;

/**
 * TextBookDriver runs the program TextBook, a text-based social media that runs in the console.
 * In Text Book, there are multiple commands that can be ran, which are processed through a switch:
 *
 *  (P)rint TextBook posts, prints posts to console in format: index - ID TIME USER PostText
    (A)(dd a new post, adds text to file, using username provided earlier.
    (D)elete a post, removes post from TextBook, making it impossible to recall
    (C)omment on a post, saves a comment to a post, attached in its post file
    (R)ead a post and its comments, prints a post, then its comments
    (Q)uit, breaks loop, prints goodbye message, and ends program

 * Program will save all posts into seperate files that all have an index and post id, that incriment by one per post
 * 
 * @author Jack DeAngelis, Dallin, Atlas Jones
 */

public class TextBookDriver {
    public static void main(String[] args) {
        
        // Username prompt
        
        System.out.println("Enter your name to enter TextBook: ");

        Scanner kbd = new Scanner(System.in); // keyboard scanner used throughout code
        String input = kbd.nextLine();        // establishes variable to hold keyboard input throughout code
        boolean valid = false;                // looks to see if username has been set
        String username = input;              // establises variable outside of loop for username, used throughout code as name

        // Ensures valid username (no spaces), prints out error and prompts for valid username if not

        while (!valid) {
            if (!input.contains(" ")) {
            username = input;
            valid = true;
            } else {
            System.out.println("");
            System.out.println("Username must not include spaces.");
            System.out.println("");
            System.out.println("Enter your name to enter TextBook: ");
            input = kbd.nextLine();
            }
        }
        
        // Prints Initial Menu

        System.out.println(username + ", welcome to TextBook, the totally-text social media site!");

        System.out.println("--------------------------------");
        System.out.println("TextBook Site Menu");
        System.out.println("--------------------------------");
        System.out.println("  (P)rint TextBook posts");
        System.out.println("  (A)dd a new post");
        System.out.println("  (D)elete a post");
        System.out.println("  (C)omment on a post");
        System.out.println("  (R)ead a post and its comments");
        System.out.println("  (Q)uit");
        System.out.println();
        System.out.print("Select an option (or 'M' for Menu): ");

        input = kbd.nextLine();         // sets variable to new keyboard input
        input = input.toUpperCase();    // creates case insensitivity
        boolean quit = false;           // sets quit condition, used in while conditional
        TextBook textBook = new TextBook();     // This is the text book object used throughout the code to call methods and store posts.
        int selectedIndex;              // int value created so when user selects an indew/out recalling nextLinex it is saved.

        // Switch statement, used to interact with the menu, in a while loop that ends when the quit condition is set to false (done by the q command)
        
        while (quit == false) {
        switch(input) {
            case "P":
                // Prints post to console, using method in TextBook.java

                System.out.println(textBook.toString());
                break;
            case "A":
                // Appends post to new file at the next index to be stored
                // Uses username provided at start

                System.out.println("Enter the text for your new post: ");
                textBook.addPost(username, kbd.nextLine());
                break;
            case "D":
                System.out.println("Enter the index of the post to delete: ");
                selectedIndex = Integer.parseInt(kbd.nextLine());
                if (selectedIndex < textBook.getPostCount()) {
                    System.out.println("Removed Post: " + textBook.getPostString(selectedIndex));
                    textBook.removePost(selectedIndex);
                } else {
                    System.out.println("Index is for a post not made yet.");
                }
                break;
            case "C":
                System.out.println("Enter the index of the post on which to comment: ");
                selectedIndex = Integer.parseInt(kbd.nextLine());
                System.out.println("Enter your comment: ");
                textBook.addComment(selectedIndex, username, kbd.nextLine());
                break;
            case "R":
                System.out.println("Enter the index of the post to read: ");
                System.out.println("Post: ");
                selectedIndex = Integer.parseInt(kbd.nextLine());
                System.out.println(textBook.getPostString(selectedIndex));
                break;
            case "M":
                System.out.println("--------------------------------");
                System.out.println("TextBook Site Menu");
                System.out.println("--------------------------------");
                System.out.println("  (P)rint TextBook posts");
                System.out.println("  (A)dd a new post");
                System.out.println("  (D)elete a post");
                System.out.println("  (C)omment on a post");
                System.out.println("  (R)ead a post and its comments");
                System.out.println("  (Q)uit");
                System.out.println();
                break;
            case "Q":
                quit = true;
                break;
            default:
                System.out.println("Invalid selection!");
            }
            if (!"Q".equalsIgnoreCase(input)) {
                System.out.println();
                System.out.println("Select an option (or 'M' for Menu): ");
                input = kbd.nextLine();
                input = input.toUpperCase();
            }
        }

        kbd.close();
        System.out.println("--------------------------------");
        System.out.println("Quitting TextBook... Goodbye, " + username + "!");
        System.out.println("--------------------------------");
    }
}
