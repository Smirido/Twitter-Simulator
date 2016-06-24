import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class TwitterSimulator{

   public static void main(String [] args){
      //users and corresponding followers hashmap 
      HashMap user_followers = new HashMap<String,ArrayList>();
      //users tweet feed that has their tweets and the tweets of the users they follow
      HashMap tweetFeed = new HashMap<String,ArrayList>();
      //List of all the users 
      ArrayList<String> allUsers = new ArrayList<String>();
      
      try{
         //reading the text files 
         BufferedReader users = new BufferedReader(new FileReader("user.txt"));
         BufferedReader tweets = new BufferedReader(new FileReader("tweet.txt"));
         
         /**********************************************************************************************
          Processing the user file and creating hashmap of users and their followes
          ***********************************************************************************************/
         String user_line;
         String follower;
         String userkey;
         while ((user_line = users.readLine()) != null) {
             String[] strArray =  user_line.split(" follows |, ");
             follower = strArray[0];
	     if (!allUsers.contains(follower)) {
		allUsers.add(follower);
		}
             for(int i=1;i<strArray.length;i++){
                 userkey = strArray[i];
                  //user already exist in the hashmap
                  if(user_followers.containsKey(userkey)){
                     List<String> existingList = (ArrayList)user_followers.get(userkey);
                     //add follower only it's not already on the list 
                     if(!existingList.contains(follower)){
                        existingList.add(follower);
                     }
                     user_followers.put(userkey,existingList);
                  }
                  else{
                  
                     List<String> followersList = new ArrayList<String>();//list of users the user is following
                     followersList.add(follower);
                     user_followers.put(userkey,followersList);       
                  
                  }
		  if (!allUsers.contains(userkey)) {
			allUsers.add(userkey);
		  }

              }
          }
          
          /**********************************************************************************************
          Processing the tweets file and creating hashmap of the tweets
          ***********************************************************************************************/
          String tweet_line;
          String tweet;
          String tweetUser;
          while ((tweet_line = tweets.readLine()) != null) {
               String[] tweetsArray = tweet_line.split(">");
               tweetUser = tweetsArray[0];
               tweet = tweetsArray[1];
               //add tweet to the user's feed 
               if(tweetFeed.containsKey(tweetUser)){// if user has already tweeted 
                  List<String> existingTweets = (ArrayList)tweetFeed.get(tweetUser);
                  existingTweets.add("@"+tweetUser + ": " + tweet);
                  tweetFeed.put(tweetUser,existingTweets);
                  
                  
               }
               else{//new tweet
                  List<String> userTweets = new ArrayList<String>();
                  userTweets.add("@"+tweetUser + ": " + tweet);
                  tweetFeed.put(tweetUser,userTweets);
               
               }
               
               //add tweet to the user's followers
               ArrayList<String> userFollowers = (ArrayList)user_followers.get(tweetUser); 
               if(userFollowers != null){
               //loop through followers and add user's tweet
                  for(String uFollower: userFollowers){
                    
                     if(tweetFeed.containsKey(uFollower)){// if the follower already has tweet
                        
                        List<String> folowerTweets = (ArrayList)tweetFeed.get(uFollower);//retrieve the followers tweets
                        folowerTweets.add("@"+tweetUser + ": " + tweet);
                        tweetFeed.put(uFollower,folowerTweets);
                        
                        
                     }
                     else{
                        
                        List<String> folowerTweets1 = new ArrayList<String>();
                        folowerTweets1.add("@"+tweetUser + ": " + tweet);
                        tweetFeed.put(uFollower,folowerTweets1);
                        
                     
                     }
                     
                  
                  }
                  
               
               }
               
              
          } 
          
	      Collections.sort(allUsers);
         //Printing the sorted hashmap 
         for (String key : allUsers) { 

            //print users' tweet feed
      		System.out.println(key);
      		if (tweetFeed.containsKey(key)) {
      		       //retrieve tweets arraylist 
      		       List<String> sortedtweetList = (ArrayList)tweetFeed.get(key);
                     
      		       //looping through the tweets and printing them out. 
      		       for(String sortedfinalTweets: sortedtweetList){
      		          
      		          System.out.println( sortedfinalTweets );
      		       }
         		} 
               else {
         			System.out.println();
		         }
          }
          users.close();
          tweets.close();
      }
      catch (IOException e) {
          e.printStackTrace();   
      }
   }
}
