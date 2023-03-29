package exceptions;

public class KeyNotFoundException extends java.lang.Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public KeyNotFoundException(String s) {
        super(s);
    }

    public KeyNotFoundException(Throwable c) {
        super(c);
    }
}
