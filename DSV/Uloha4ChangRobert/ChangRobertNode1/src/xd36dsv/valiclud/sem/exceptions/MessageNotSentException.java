package xd36dsv.valiclud.sem.exceptions;

public class MessageNotSentException extends java.lang.Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MessageNotSentException(String s) {
        super(s);
    }

    public MessageNotSentException(Throwable c) {
        super(c);
    }
}