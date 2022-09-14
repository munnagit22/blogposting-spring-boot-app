package study.practice.enity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Blog {
	
	@Id
	private int blogId;
	private String blogTitle;
	private String blogCreator;
	public int getBlogId() {
		return blogId;
	}
	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}
	public String getBlogTitle() {
		return blogTitle;
	}
	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}
	public String getBlogCreator() {
		return blogCreator;
	}
	public void setBlogCreator(String blogCreator) {
		this.blogCreator = blogCreator;
	}
	
	
	
	public Blog() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Blog [blogId=" + blogId + ", blogTitle=" + blogTitle + ", blogCreator=" + blogCreator + "]";
	}
	
	

}
