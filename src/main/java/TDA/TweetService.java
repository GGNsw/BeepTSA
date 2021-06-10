package TDA;

import java.util.List;

public interface TweetService {

	Tweets getTweetById(Integer id);
	
	Iterable<Tweets> listAllTweets();	
}
