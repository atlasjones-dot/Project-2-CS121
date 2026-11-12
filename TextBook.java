import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Manages posts in the TextBook application.
 */
public class TextBook implements TextBookInterface 
{

    // Instance variables
    private ArrayList<Post> postsList;
    private int lastID;

    /**
     * Creates a TextBook and loads saved posts.
     */
    public TextBook() 
    {
        postsList = new ArrayList<Post>();
        lastID = 0;

        // Read saved post IDs from the file
        try 
        {
            Scanner input = new Scanner(new File(POST_LIST_FILENAME));

            while (input.hasNextInt()) 
            {
                int id = input.nextInt();

                Post post = new Post(id);
                postsList.add(post);

                lastID = id;
            }

            input.close();

        } 
        catch (FileNotFoundException e) 
        {
            // Start with an empty TextBook if no file exists
        }
    }

    /**
     * Returns the last assigned post ID.
     */
    @Override
    public int getLastID() 
    {
        return lastID;
    }

    /**
     * Returns the number of posts.
     */
    @Override
    public int getPostCount() 
    {
        return postsList.size();
    }

    /**
     * Returns a post and its comments as a String.
     */
    @Override
    public String getPostString(int index) 
    {
        return postsList.get(index).toString();
    }

    /**
     * Creates a new post and saves its ID.
     */
    @Override
    public void addPost(String author, String text) 
    {
        lastID++;

        // Create and store the new post
        Post newPost = new Post(lastID, author, text);
        postsList.add(newPost);

        // Append the post ID to the file
        try 
        {
            PrintWriter output = new PrintWriter(new FileWriter(POST_LIST_FILENAME, true));

            output.println(lastID);
            output.close();

        } 
        catch (IOException e) 
        {
            System.out.println("Error saving post ID.");
        }
    }

    /**
     * Removes a post at the given index.
     */
    @Override
    public Post removePost(int index) 
    {
        Post removedPost = postsList.remove(index);
        String fileName = removedPost.getFilename();
        File f = new File(fileName);
        f.delete();

        // Rewrite the file with remaining post IDs
        try 
        {   
            PrintWriter output = new PrintWriter(new File(POST_LIST_FILENAME));
            for (Post post : postsList) 
            {
                output.println(post.getPostID());
            }

            output.close();

        } 
        catch (FileNotFoundException e) 
        {
            System.out.println("Error updating post IDs.");
        }

        return removedPost;
    }

    /**
     * Adds a comment to the selected post.
     */
    @Override
    public void addComment(int postIndex, String author, String text) 
    {
        postsList.get(postIndex).addComment(author, text);
    }

    /**
     * Returns a String containing all posts.
     */
    @Override
    public String toString() 
    {
        String result = "TextBook contains " + postsList.size() + " posts:";

        // Add each post with its index
        for (int i = 0; i < postsList.size(); i++) 
        {
            result += "\n" + i + " - " + postsList.get(i).toStringPostOnly();
        }

        return result;
    }

    /**
     * Returns a copy of the posts ArrayList.
     */
    @Override
    public ArrayList<Post> getPosts() 
    {
        return new ArrayList<Post>(postsList);
    }
}
