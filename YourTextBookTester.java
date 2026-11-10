/**
 * Tests the methods in the TextBook class.
 */
public class YourTextBookTester {

    public static void main(String[] args) {

        // Test the TextBook constructor
        TextBook textbook = new TextBook();

        System.out.println("=== TextBook Tester ===");

        // Test getPostCount()
        System.out.println("\n1. Initial post count:");
        System.out.println(textbook.getPostCount());

        // Test getLastID()
        System.out.println("\n2. Initial last ID:");
        System.out.println(textbook.getLastID());

        // Test addPost()
        textbook.addPost("Dallin", "Hello everyone!");
        textbook.addPost("Dallin", "This is my second post.");

        System.out.println("\n3. After adding two posts:");
        System.out.println(textbook);

        // Test getPostCount()
        System.out.println("\n4. Post count:");
        System.out.println(textbook.getPostCount());

        // Test getLastID()
        System.out.println("\n5. Last post ID:");
        System.out.println(textbook.getLastID());

        // Test getPostString()
        System.out.println("\n6. First post:");
        System.out.println(textbook.getPostString(0));

        // Test addComment()
        textbook.addComment(0, "Jack", "Nice post!");

        System.out.println("\n7. First post with comment:");
        System.out.println(textbook.getPostString(0));

        // Test getPosts()
        System.out.println("\n8. ArrayList copy size:");
        System.out.println(textbook.getPosts().size());

        // Test removePost()
        Post removed = textbook.removePost(0);

        System.out.println("\n9. Removed post ID:");
        System.out.println(removed.getPostID());

        // Test toString()
        System.out.println("\n10. Remaining posts:");
        System.out.println(textbook);

        System.out.println("\n=== Testing Complete ===");
    }
}
