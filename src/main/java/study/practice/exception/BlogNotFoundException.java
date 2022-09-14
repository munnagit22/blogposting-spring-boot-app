package study.practice.exception;

public class BlogNotFoundException extends Exception {

	private String message;

	public BlogNotFoundException(String message) {
		super();
		this.message = message;
	}
	 public BlogNotFoundException() {}
}
