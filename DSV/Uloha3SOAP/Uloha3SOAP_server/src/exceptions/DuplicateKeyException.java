package exceptions;

public class DuplicateKeyException extends java.lang.Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DuplicateKeyException(String s) {
        super(s);
    }

    public DuplicateKeyException(Throwable c) {
        super(c);
    }
}