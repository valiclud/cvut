package x36dsv.cv6;

import javax.xml.stream.XMLStreamException;

import org.apache.axiom.om.OMElement;

public class TestServer1 { 
	
	/* echo service */
	public OMElement echo(OMElement element) throws XMLStreamException {
		/* vytvoreni 'DOM' stromu z cele prichozi zpravy */
        element.build();
        /* 'osamostatneni' prijate struktury */
        element.detach();
        return element;
    }
	
}
