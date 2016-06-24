# Twitter-Simulator
------------------------
Problem Description
------------------------

Program that simulates a twitter-like feed.Program will receive two seven-bit ASCII files. The first file contains a list of users and their followers. The second file contains tweets. Given the users, followers and tweets, the objective is to display a simulated twitter feed for each user to the console.<br />

The program should be well designed, handle errors and should be of sufficient quality to run on a production system. Indicate all assumptions made in completing the assignment.<br />

Each line of a well-formed user file contains a user, followed by the word 'follows' and then a comma separated list of users they follow. Where there is more than one entry for a user, consider the union of all these entries to determine the users they follow.<br />

Lines of the tweet file contain a user, followed by greater than, space and then a tweet that may be at most 140 characters in length. The tweets are considered to be posted by the each user in the order they are found in this file.<br />

Your program needs to write console output as follows. For each user / follower (in alphabetical order) output their name on a line. Then for each tweet, emit a line with the following format: <tab>@user: <space>message.<br />

Here is an example. Given user file named user.txt:
Ward follows Alan
Alan follows Martin
Ward follows Martin, Alan

And given tweet file named tweet.txt:
Alan> If you have a procedure with 10 parameters, you probably missed some.
Ward> There are only two hard things in Computer Science: cache invalidation, naming things and off-by-1 errors.
Alan> Random numbers should not be generated with a method chosen at random.

So invoking your program with user.txt and tweet.txt as arguments should produce the following console output:

Alan
@Alan: If you have a procedure with 10 parameters, you probably missed some.
@Alan: Random numbers should not be generated with a method chosen at random.

Martin

Ward
@Alan: If you have a procedure with 10 parameters, you probably missed some.
@Ward: There are only two hard things in Computer Science: cache invalidation, naming things and off-by-1 errors.
@Alan: Random numbers should not be generated with a method chosen at random.

----------------------
List of Files 
----------------------
Java file:  TwitterSimulator.java<br />
Text file: user.txt, tweet.txt <br />

---------------------------------------
Instructions on how to run the program
---------------------------------------

1) Please have all your files in the same folder <br />
2) Compile the TwitterSimulator.java file (either manually, or by runing 'make' in the command<br />
line), and then execute the program. <br />
3) For the test case use the text files provided.<br />

-------------
Limitations
-------------
The program reads the two text files and the user is not asked to input text file names. In the case you want to change your users or tweets please edit the text files. 





