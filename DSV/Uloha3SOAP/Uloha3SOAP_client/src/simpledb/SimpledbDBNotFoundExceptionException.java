
/**
 * SimpledbDBNotFoundExceptionException.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

package simpledb;

public class SimpledbDBNotFoundExceptionException extends java.lang.Exception{

    private static final long serialVersionUID = 1367851892855L;
    
    private simpledb.SimpledbStub.SimpledbDBNotFoundException faultMessage;

    
        public SimpledbDBNotFoundExceptionException() {
            super("SimpledbDBNotFoundExceptionException");
        }

        public SimpledbDBNotFoundExceptionException(java.lang.String s) {
           super(s);
        }

        public SimpledbDBNotFoundExceptionException(java.lang.String s, java.lang.Throwable ex) {
          super(s, ex);
        }

        public SimpledbDBNotFoundExceptionException(java.lang.Throwable cause) {
            super(cause);
        }
    

    public void setFaultMessage(simpledb.SimpledbStub.SimpledbDBNotFoundException msg){
       faultMessage = msg;
    }
    
    public simpledb.SimpledbStub.SimpledbDBNotFoundException getFaultMessage(){
       return faultMessage;
    }
}
    