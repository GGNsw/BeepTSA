package TDA;



public class Tweets {




	Integer id;
	
	String user;
	
	String tweet;
	
	String pic;
	
	String sentimiento;
	
	public Tweets() {
		
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getTweet() {
		return tweet;
	}

	public void setTweet(String tweet) {
		this.tweet = tweet;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getSentimiento() {
		return sentimiento;
	}

	public void setSentimiento(String sentimiento) {
		this.sentimiento = sentimiento;
	}

	public Tweets(Integer id, String user, String tweet, String pic, String sentimiento) {
		super();
		this.id = id;
		this.user = user;
		this.tweet = tweet;
		this.pic = pic;
		this.sentimiento = sentimiento;
	}

	@Override
	public String toString() {
		return "Tweets [id=" + id + ", user=" + user + ", tweet=" + tweet + ", pic=" + pic + ", sentimiento="
				+ sentimiento + "]";
	}
	
	
	


	
}
