import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Scanner;
import java.text.DecimalFormat;
import java.io.FileOutputStream;

/**
 * Represents a single TextBook post and its comments, saved to a Post-<postID>.txt file.
 *
 * @author Jack DeAngelis, Dallin, Atlas
 */
public class Post implements PostInterface {
    private String author;
    private String text;
    private Instant timestamp;
    private int postId;
    private ArrayList<String> commentsList;

    // formats post IDs to 5 digits, shared by all posts
    private static final DecimalFormat DF = new DecimalFormat("00000");

    /**
     * Creates a new post and writes it to a new post file.
     *
     * @param id unique post ID
     * @param author one-word username of the author
     * @param text text of the post
     */
    public Post(int id, String author, String text) {
        this.timestamp = Instant.now();
        this.postId = id;
        this.author = author;
        this.text = text;
        this.commentsList = new ArrayList<String>();

        try {
            PrintWriter pw = new PrintWriter(new File(getFilename()));
            pw.println(toStringPostOnly());
            pw.close();
        }
        catch (FileNotFoundException fnfe) {
            System.out.println("Couldn't create file");
        }
    }

    /**
     * Recovers a post and its comments from its existing post file.
     *
     * @param id ID of the post to recover
     */
    public Post(int id) {
        this.postId = id;
        this.commentsList = new ArrayList<String>();

        try {
            Scanner fileScan = new Scanner(new File(getFilename()));
            
            // first line is the post, the rest of the line after author is the text
            this.postId = Integer.parseInt(fileScan.next());
            this.timestamp = Instant.parse(fileScan.next());
            this.author = fileScan.next();
            this.text = fileScan.nextLine().trim();
            
            // every line after that is a comment
            while (fileScan.hasNextLine()) {
                String line = fileScan.nextLine();
                commentsList.add(line);
            }
            fileScan.close();
        }
        catch (FileNotFoundException fnfe) {
            System.out.println("couldn't find file");
        }

    }

    public void addComment(String author, String text) {
        String comment = Instant.now() + " " + author + " " + text;
        commentsList.add(comment);
        
        // append so the existing post file isn't overwritten
        try {
            PrintWriter pw = new PrintWriter(new FileOutputStream(new File(getFilename()), true));
            pw.println(comment);
            pw.close();
        }
        catch (FileNotFoundException fnfe) {
            System.out.println("couldn't find file");
        }
    }

    public String toString() {
        String result = "";
        result += "Post: \n";
        result += toStringPostOnly() + "\n";
        result += "Comments: \n";
        for (String c: commentsList) {
            result += c + "\n";
        }

        return result;
    }

    public String toStringPostOnly() {
        String result;
        result = DF.format(getPostID()) + " " + getTimestamp() + " " + getAuthor() + " " + getText();
        return result;
    }

    public String getFilename() {
        String result = "Post-" + DF.format(getPostID()) + ".txt";
        return result;
    }

    public int getPostID() {
        return postId;
    }

    public String getText() {
        return text;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public String getAuthor() {
        return author;
    }

}
