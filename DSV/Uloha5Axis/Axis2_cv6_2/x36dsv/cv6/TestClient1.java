package x36dsv.cv6;

import org.apache.axiom.om.OMElement;
import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;

public class TestClient1 {

    private static EndpointReference targetEPR = new EndpointReference("http://eeyore.sin.cvut.cz:8080/axis2/services/TestServer1");

    public static void main(String[] args) {
        try {
            OMElement payload = TestUtils.getEchoOMElement();
            Options options = new Options();
            options.setTo(targetEPR);

            System.out.println("Payload: "+payload);
            
            //Blocking invocation
            ServiceClient sender = new ServiceClient();
            sender.setOptions(options);
            OMElement result = sender.sendReceive(payload);

            System.out.println("Result: "+result);

        } catch (AxisFault axisFault) {
            axisFault.printStackTrace();
        }
    }
}
