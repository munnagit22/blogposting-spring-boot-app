package study.practice.exception;

public class BlogAllreadyExistException extends Exception {

	private String message;

	public BlogAllreadyExistException(String message) {
		super();
		this.message = message;
	}
	public BlogAllreadyExistException() {}
	
}
