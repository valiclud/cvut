
/**
 * SimpledbIOExceptionException.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

package simpledb;

public class SimpledbIOExceptionException extends java.lang.Exception{

    private static final long serialVersionUID = 1367851892849L;
    
    private simpledb.SimpledbStub.SimpledbIOException faultMessage;

    
        public SimpledbIOExceptionException() {
            super("SimpledbIOExceptionException");
        }

        public SimpledbIOExceptionException(java.lang.String s) {
           super(s);
        }

        public SimpledbIOExceptionException(java.lang.String s, java.lang.Throwable ex) {
          super(s, ex);
        }

        public SimpledbIOExceptionException(java.lang.Throwable cause) {
            super(cause);
        }
    

    public void setFaultMessage(simpledb.SimpledbStub.SimpledbIOException msg){
       faultMessage = msg;
    }
    
    public simpledb.SimpledbStub.SimpledbIOException getFaultMessage(){
       return faultMessage;
    }
}
    