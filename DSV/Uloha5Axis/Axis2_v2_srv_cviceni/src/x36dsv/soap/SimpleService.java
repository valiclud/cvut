package x36dsv.soap;

public class SimpleService {

	public String repeatMessage(String message) {
		System.out.println("SimpleService repeatMessage called");
		return "Repeating : " + message;
	}
}
