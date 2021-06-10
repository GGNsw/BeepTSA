package TDA;

import java.util.ArrayList;
import java.util.List;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.TwitterException;


public class BTweet
   {

		public static List<Tweets> getTweets(int count, String SearchTerm) {
	    	  
			List<Tweets> todoTweets = new ArrayList<Tweets>();
				
			Twitter twitter = new TwitterFactory().getInstance();	
			
			ArrayList<String> tweetList = new ArrayList<String>();
			
			Query query = new Query(SearchTerm);
			query.setCount(count);
			
			QueryResult result;
			
			NLP.init();
			
			try {
				
				result = twitter.search(query);
				int counter = 0;
				System.out.println("Count: "+result.getTweets().size());
				
				String SENT [] = {"Muy Negativo", "Negativo", "Positivo", "Muy Positivo"};
							
				for (Status tweet: result.getTweets()) {

					counter++;
					tweetList.add(tweet.getText());
					System.out.println("Tweet #"+counter+": @"+tweet.getUser().getName()
							+tweet.getUser().getProfileImageURL()+"tweeted \""+tweet.getText()+"\"");
					
					String user = tweet.getUser().getName();
					String tweets = tweet.getText();
					String pic = tweet.getUser().getProfileImageURL();
					String sentimiento = SENT[NLP.analizarSentimiento(tweet.getText())];
					
					Tweets CTweet = new Tweets(counter, user, tweets, pic, sentimiento);				
					
					todoTweets.add(CTweet);
				}
							
				
			} catch (TwitterException e) {
				
				e.printStackTrace();
			}
			return todoTweets;
		
		}
   
   }  