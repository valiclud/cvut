
/**
 * SimpledbKeyNotFoundExceptionException.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

package simpledb;

public class SimpledbKeyNotFoundExceptionException extends java.lang.Exception{

    private static final long serialVersionUID = 1367851892862L;
    
    private simpledb.SimpledbStub.SimpledbKeyNotFoundException faultMessage;

    
        public SimpledbKeyNotFoundExceptionException() {
            super("SimpledbKeyNotFoundExceptionException");
        }

        public SimpledbKeyNotFoundExceptionException(java.lang.String s) {
           super(s);
        }

        public SimpledbKeyNotFoundExceptionException(java.lang.String s, java.lang.Throwable ex) {
          super(s, ex);
        }

        public SimpledbKeyNotFoundExceptionException(java.lang.Throwable cause) {
            super(cause);
        }
    

    public void setFaultMessage(simpledb.SimpledbStub.SimpledbKeyNotFoundException msg){
       faultMessage = msg;
    }
    
    public simpledb.SimpledbStub.SimpledbKeyNotFoundException getFaultMessage(){
       return faultMessage;
    }
}
    