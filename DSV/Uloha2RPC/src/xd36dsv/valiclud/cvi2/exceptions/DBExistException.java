package xd36dsv.valiclud.cvi2.exceptions;

public class DBExistException extends java.lang.Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DBExistException(String s) {
        super(s);
    }

    public DBExistException(Throwable c) {
        super(c);
    }
}
