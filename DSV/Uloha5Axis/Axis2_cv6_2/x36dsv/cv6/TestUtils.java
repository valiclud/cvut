package x36dsv.cv6;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;

public class TestUtils {

	/**
	 * Metoda pro vytvoreni zpravy pro echo server.
	 * @return XML SOAP body zpravy
	 */
	public static OMElement getEchoOMElement() {
	    OMFactory fac = OMAbstractFactory.getOMFactory();
	    OMNamespace omNs = fac.createOMNamespace(
	            "http://example1.org/example1", "example1");
	    OMElement method = fac.createOMElement("echo", omNs);
	    OMElement value = fac.createOMElement("Text", omNs);
	    value.addChild(fac.createOMText(value, "Axis2 Echo String "));
	    method.addChild(value);
	
	    return method;
	}
}
