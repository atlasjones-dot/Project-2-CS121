
/*
*
*/

import java.util.Scanner;

public class TextBookDriver {
    public static void main(String[] args) {
        
        System.out.println("Enter your name to enter TextBook: ");

        Scanner kbd = new Scanner(System.in);
        String input = kbd.nextLine();
        boolean valid = false;
        String username = input;

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

        System.out.println(username + ", welcome to TextBook, the totally-text social media site!");
        
        // Prints Initial Menu

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

        input = kbd.nextLine();
        input = input.toUpperCase();
        boolean quit = false;           // sets quit condition, used in while conditional
        TextBook textBook = new TextBook();
        int selectedIndex;

        while (quit == false) {
        switch(input) {
            case "P":
                System.out.println(textBook.toString());
                break;
            case "A":
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
