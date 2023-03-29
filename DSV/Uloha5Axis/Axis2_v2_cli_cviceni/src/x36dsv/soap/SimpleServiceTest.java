package x36dsv.soap;

import java.rmi.RemoteException;

public class SimpleServiceTest {
	// stub was generated with (on Windows XP):
	//  ...\axis2-1.6.1\bin>WSDL2Java.bat -uri http://localhost:8080/axis2/services/RepeatService?wsdl -o client
	public static void main(String[] args) throws RemoteException { // -o kam m8m d8t kody tak se to generuje
		// create stub
		RepeatStub stub = new RepeatStub();
		// create request
		RepeatStub.RepeatMessage request = new RepeatStub.RepeatMessage();
		request.setMessage("All your base are belong to us");
		System.out.println("Service input: 'All your base are belong to us'");
		RepeatStub.RepeatMessageResponse response = 
			stub.repeatMessage(request);
		System.out.println("Service response: '" + response.get_return() + "'");
	}
}
