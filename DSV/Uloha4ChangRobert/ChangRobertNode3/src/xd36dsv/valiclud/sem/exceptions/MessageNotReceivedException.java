package xd36dsv.valiclud.sem.exceptions;

public class MessageNotReceivedException extends java.lang.Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MessageNotReceivedException(String s) {
        super(s);
    }

    public MessageNotReceivedException(Throwable c) {
        super(c);
    }
}