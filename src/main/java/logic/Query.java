package logic;

public class Query {

	  private long id;
	  private String content;
	  private int count;

	  public long getId() {
	    return id;
	  }

	  public void setId(long id) {
	    this.id = id;
	  }

	  public String getContent() {
	    return content;
	  }

	  public void setContent(String content) {
	    this.content = content;
	  }

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "Query [id=" + id + ", content=" + content + ", count=" + count + "]";
	}

	
	  
	}