# PLAN.md P2 TextBook

[Team Members] - Dallin Berg, Atlas Jones, Jack DeAngelis

**Complete as a Group Before Beginning Any Coding**

Before anyone starts independent work on any part of this project, come together as a group to reach consensus answers to all of the following project planning questions. In particular, develop a breakdown of tasks, a plan for how code will be written and tested, and a timeline for completing those tasks. Will you attempt to assign different parts of the code to individuals that have to be integrated later or will you arrange your schedules to practice "pair-programming" where you all work together on code (one person at the keyboard with others watching for bugs and making suggestions)?

We will task each other with individual classes to build and then come together to test and implement each class accordingly.

## Program Overview

Explain the purpose of the program (not the assignment) in at most three sentences. What does it do? What is it used for?

This program takes responses from the user after providing a given menu, that will allow the user to add, delete, and view posts and comments in TextBook.
Stores text posts with the information of postID, author, text, and time of post that can then be commented on (saving the comments) and deleted in an arrayList postsList.


## Project Files

List each Java source file (.java file) in the project and a very short description of its purpose. Include source files given as handouts and any additional source files you will write, but do not list standard library files referenced in include statements at the top of source files.

PostInterface.java - store descriptions and expectations for all required methods for posting
PostUnitTester.java - test correct functionality of the Post class
TextBookInterface.java - store descriptions and expectations for all required methods for the textbook interface
TextBookUnitTester.java - test correct functionality of the textbook class 
Post.java - This class represents a single post and its associated comments.
TextBook.java - This class manages a collection of Posts and provides methods for interacting with its collection
TextBookDriver.java - This is the driver for the project, containing the main() method which is the entry point for the application.

## Compile and Run Instructions

From the directory containing all source code (.java) files, what is the command-line (terminal/console) command that compiles the program?

$ javac TextBookDriver.java

From the directory containing the compiled class (.class) files, what is the command-line (terminal/console) command that runs the program?

$ java TextBookDriver.java

## Concept References

Identify the slides (module and slide numbers) that introduce and
demonstrate each of the following concepts:

* Encapsulation - module 6 slide 30
* Instance Variables - module 6 slide 20
* Getters/Setters - module 6 slide 25
* ArrayLists - module 5 slide 5
* Interfaces - module 6 slide 83
* Reading files - module 5 slide 48
* Writing files - module 6 slide 147
* Writing vs. appending to files - module 6 slide 148
* Purpose of constructor - module 6 slide 21
* Exception handling - module 5 slide 52
* Aggregation - module 6 slide 96
* Tokenizing Strings/Handling CSV data - module 5 slide 56

## Activity Connections

This project requires writing different classes for specific jobs in
the project and getting them all to interact correctly.  You will also
need to frequently read and write files. 

Reflecting on the Task and ToDoList activities, answer the following questions:

* Why did you need getters and setters in your classes?  
   What access modifier should be used for instance variables?  
   What access modifier should be used for methods that other classes need to call?
We need getters and setters to preserve encapsulation by controlling the object's data. 
We will need to have our instance variables as Private because we don't want our instance variables changing.
We will need to have our methods and other classes as Public because we will need other classes to access them.

* What is the relationship between Task and ToDoList (using the class
  relationships defined in part 5 of module 6 slides)?

ToDoList utilizes the PrintWriter class to write to the file given by the user. The tasks were added to a given in our TaskMaster using ToDoList.java using methods we defined in the ToDoListInterface.java

* How did you find specific Tasks in the ToDoList?  How can you find
  specific Posts in the Textbook?

 To find specific tasks in the ToDoList we iterated through the tasks list searching for the specific task we were looking for. If we never found it then we knew the task did not exist. We can use a similar method for the Textbook by storing posts in an array alongside the associated info on the post ( postID, author, text, and time ).

* How were Interfaces used in the activities?  
   What is the purpose of the Interfaces provided in this project?
We are using interfaces with TextBookInterface and Post Interface because we are implementing their attributes into our own class TextBook & Post.

* In ToDoList, one constructor took a File object. How is this
  constructor similar to the TextBook constructor?  How can the file
  be used to populate the Textbook (think how it was used to populate
  the ToDoList)?

  We can use a similar structured constructor called TextBook which takes in a File parameter to initialize our textbook like we did with the ToDoList.


## Testing Plan

How will you test this program during development to ensure it meets
all requirements? How will you know your program has met all
requirements? Be specific.

Post.java - This class represents a single post and its associated comments.
Run PostUnitTester.java, as it is the job of that code to test Post.java
Compile Post.java: make sure it will compile
Ensure instance variables are private
Attempt to make 4 posts, do one wrong
Try with a space in the username, make sure that is not valid
Make sure the time is actually the time the post was created.
Make sure data in 
Check Post-<postId>.txt (look)
Make sure time is in right format
Data is separated by spaces
Make sure postID is 5 digits long
Make sure postID adds correctly per post
Check line looks like: <postId> <timestamp> <author> <text>
Post Comments on all 3 posts, 2 on one, one on others
Ensure also being saved to files correctly
Attempt to recover all three posts individually, + one nonexistent
Make sure recovering the correct file
Ensure error message from nonexistent file
Ensure date formatting is correct
Ensure comments are retained

TextBook.java - This class manages a collection of Posts and provides methods for interacting with its collection
TextBookUnitTester.java, as it is the job of that code to test TextBook.java
Compile TextBook.java: make sure it will compile
TextBook updates this file whenever Posts are added or deleted from the TextBook.
TextBook.java implements TextBookInterface
Attributes: postsList, lastID
instance variables are private in TextBook.java
TextBook.java also sets and arranges an ID to a post and changes the ID number according to the number of posts made.






TextBookDriver.java - This is the driver for the project, containing the main() method which is the entry point for the application.
Compile TextBookDriver.java: make sure it will compile
Check menu prints correctly on start
Set multiple usernames
Ensure saved correctly
Check menu prints correctly on good username
Input lowercase versions of commands, ensure it works
Input wrong letters, ensure error
Input Q, make sure program quits with message same as P1

Run all sections when there are no posts, make sure it informs user of empty status
D, C, R x3
Put in wrong index for getting a post, get error message
Ensure index is grabbing correct info
A x3
Make sure new post is also using username and time, saving properly
Retaining information
After quitting, restart, then call for info from before


## Project Timeline

Set planned target times to complete specific project milestones so you can be confident all requirements will be met by the project due date. When setting completion targets, consider how long you think it will actually take to write and troubleshoot/debug specific features. Allow plenty of buffer time to accommodate unexpected challenges or interruptions. Indicate who from the team will be responsible for each task. A few suggested steps are given to get you started. You can change them at the team's discretion.

* 11/6 - Complete PLAN.md in class and submit it for group - 1 hr estimate - all team members, independently
* 11/10 - Complete your segment of the codebase - 5 hr estimate - completed independently
* 11/11 - Review codebase and perform all required tests to confirm everything works correctly updates - 1 hour estimate - all team members, independently
* 11/12 - fix any issues found from review - 1 hr estimate - completed independently
* 11/13 - PLAN submitted - 15 minute estimate - Jack is responsible for submission on behalf of the team


Responsibilities: 

Jack - post.java
TextBook.java
ATetlas - TextBookDriver.java

How to use GitHub

Final submission
