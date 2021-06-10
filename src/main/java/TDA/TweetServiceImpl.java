package TDA;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import TDA.Tweets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TweetServiceImpl implements TweetService{
	private Map<Integer,Tweets> Tweets;
	


	@Override
	public Tweets getTweetById(Integer id) {
	return Tweets.get(id);
	}

	@Override
	public Iterable<Tweets> listAllTweets() {
		ArrayList<Tweets> e = new ArrayList<Tweets>(Tweets.values());
        System.out.println(e.toString());
        return e;
	}

}
