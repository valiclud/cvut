
/**
 * SimpledbDBExistExceptionException.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

package simpledb;

public class SimpledbDBExistExceptionException extends java.lang.Exception{

    private static final long serialVersionUID = 1367851892869L;
    
    private simpledb.SimpledbStub.SimpledbDBExistException faultMessage;

    
        public SimpledbDBExistExceptionException() {
            super("SimpledbDBExistExceptionException");
        }

        public SimpledbDBExistExceptionException(java.lang.String s) {
           super(s);
        }

        public SimpledbDBExistExceptionException(java.lang.String s, java.lang.Throwable ex) {
          super(s, ex);
        }

        public SimpledbDBExistExceptionException(java.lang.Throwable cause) {
            super(cause);
        }
    

    public void setFaultMessage(simpledb.SimpledbStub.SimpledbDBExistException msg){
       faultMessage = msg;
    }
    
    public simpledb.SimpledbStub.SimpledbDBExistException getFaultMessage(){
       return faultMessage;
    }
}
    