
/**
 * SimpledbCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package simpledb;

    /**
     *  SimpledbCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class SimpledbCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public SimpledbCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public SimpledbCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for update method
            * override this method for handling normal response from update operation
            */
           public void receiveResultupdate(
                    simpledb.SimpledbStub.UpdateResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from update operation
           */
            public void receiveErrorupdate(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getA method
            * override this method for handling normal response from getA operation
            */
           public void receiveResultgetA(
                    simpledb.SimpledbStub.GetAResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getA operation
           */
            public void receiveErrorgetA(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for flush method
            * override this method for handling normal response from flush operation
            */
           public void receiveResultflush(
                    simpledb.SimpledbStub.FlushResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from flush operation
           */
            public void receiveErrorflush(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for get method
            * override this method for handling normal response from get operation
            */
           public void receiveResultget(
                    simpledb.SimpledbStub.GetResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from get operation
           */
            public void receiveErrorget(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for insert method
            * override this method for handling normal response from insert operation
            */
           public void receiveResultinsert(
                    simpledb.SimpledbStub.InsertResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from insert operation
           */
            public void receiveErrorinsert(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for listDB method
            * override this method for handling normal response from listDB operation
            */
           public void receiveResultlistDB(
                    simpledb.SimpledbStub.ListDBResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from listDB operation
           */
            public void receiveErrorlistDB(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for createDB method
            * override this method for handling normal response from createDB operation
            */
           public void receiveResultcreateDB(
                    simpledb.SimpledbStub.CreateDBResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from createDB operation
           */
            public void receiveErrorcreateDB(java.lang.Exception e) {
            }
                


    }
    