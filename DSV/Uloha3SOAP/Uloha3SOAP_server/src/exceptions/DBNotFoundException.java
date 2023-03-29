package exceptions;

public class DBNotFoundException extends java.lang.Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DBNotFoundException(String s) {
        super(s);
    }

    public DBNotFoundException(Throwable c) {
        super(c);
    }
}
