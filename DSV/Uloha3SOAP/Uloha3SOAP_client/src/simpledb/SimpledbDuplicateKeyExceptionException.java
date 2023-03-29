
/**
 * SimpledbDuplicateKeyExceptionException.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

package simpledb;

public class SimpledbDuplicateKeyExceptionException extends java.lang.Exception{

    private static final long serialVersionUID = 1367851892842L;
    
    private simpledb.SimpledbStub.SimpledbDuplicateKeyException faultMessage;

    
        public SimpledbDuplicateKeyExceptionException() {
            super("SimpledbDuplicateKeyExceptionException");
        }

        public SimpledbDuplicateKeyExceptionException(java.lang.String s) {
           super(s);
        }

        public SimpledbDuplicateKeyExceptionException(java.lang.String s, java.lang.Throwable ex) {
          super(s, ex);
        }

        public SimpledbDuplicateKeyExceptionException(java.lang.Throwable cause) {
            super(cause);
        }
    

    public void setFaultMessage(simpledb.SimpledbStub.SimpledbDuplicateKeyException msg){
       faultMessage = msg;
    }
    
    public simpledb.SimpledbStub.SimpledbDuplicateKeyException getFaultMessage(){
       return faultMessage;
    }
}
    