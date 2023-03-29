
/**
 * SimpledbRemoteExceptionException.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

package simpledb;

public class SimpledbRemoteExceptionException extends java.lang.Exception{

    private static final long serialVersionUID = 1367851892877L;
    
    private simpledb.SimpledbStub.SimpledbRemoteException faultMessage;

    
        public SimpledbRemoteExceptionException() {
            super("SimpledbRemoteExceptionException");
        }

        public SimpledbRemoteExceptionException(java.lang.String s) {
           super(s);
        }

        public SimpledbRemoteExceptionException(java.lang.String s, java.lang.Throwable ex) {
          super(s, ex);
        }

        public SimpledbRemoteExceptionException(java.lang.Throwable cause) {
            super(cause);
        }
    

    public void setFaultMessage(simpledb.SimpledbStub.SimpledbRemoteException msg){
       faultMessage = msg;
    }
    
    public simpledb.SimpledbStub.SimpledbRemoteException getFaultMessage(){
       return faultMessage;
    }
}
    