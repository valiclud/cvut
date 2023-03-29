package xd36dsv.valiclud.sem.evaluation;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import xd36dsv.valiclud.sem.exceptions.MessageNotReceivedException;
import xd36dsv.valiclud.sem.exceptions.MessageNotSentException;


public class Evaluation implements EvaluationInterface {

private static Evaluation instance;
    
	/**
     * @return the instance
	 * @throws NotBoundException 
     */

	private Message myPrivateMessage = null, electedMessage;

	private Registry registry;
	private EvaluationInterface	evalInterface;
	private String bindName;
	private boolean connected;
//	private String ipAddress = "localhost";
//	private int port = 3002;
//	private String nodeName =  "Node 1";
//	private int value = 5;
	
	private String ipAddress ;
	private int port;
	private String nodeName;
	private int value;

    public static Evaluation getInstance() throws  RemoteException, NotBoundException {
    	
    	if(instance == null) {
            instance = new Evaluation();
         }
         return instance;
    }
	
	private Evaluation() throws  RemoteException, NotBoundException {
		super();
		instance = this;
		
		//myPrivateMessage = new Message(myPrivateMessage.getNodeName() , "non-participant", value);
		electedMessage = new Message("", "", 0);
		
		connected = false;
	}
	
	@Override
	public int sendToNeighbour(Message message) throws MessageNotSentException, RemoteException, NotBoundException, MessageNotReceivedException {
		if ( ! connected) {
			connectToServer(ipAddress, port);
		}
		System.out.println(myPrivateMessage.getNodeName() + " sending message"); 
		int result = evalInterface.receiveMessage(message);
		return result;
	}

	@Override
	public int receiveMessage(Message message) throws MessageNotReceivedException, MessageNotSentException, RemoteException, NotBoundException {
		
	if ( ! message.getMessage().equalsIgnoreCase("leader")){
		
		if (message.getUid() > myPrivateMessage.getUid()) {
			System.out.println(myPrivateMessage.getNodeName() + " receiveMessage -- > election phase 1");
			myPrivateMessage.setMessage("participant");
			message.setMessage("non-participant");
			sendToNeighbour(message);
			return 1;
		}
		else if (message.getUid() < myPrivateMessage.getUid() && (myPrivateMessage.getMessage().equalsIgnoreCase("non-participant"))) {
			System.out.println(myPrivateMessage.getNodeName() + " receiveMessage -- > election phase 2");
			myPrivateMessage.setMessage("participant");
			message.setUid(myPrivateMessage.getUid());
			sendToNeighbour(message);
			return 2;
		}
		else if (message.getUid() < myPrivateMessage.getUid() && (myPrivateMessage.getMessage().equalsIgnoreCase("participant"))) {
//			discard the message
			System.out.println(myPrivateMessage.getNodeName() + " receiveMessage -- > election phase 3");
			return 3;
		}
		else if (message.getUid() == myPrivateMessage.getUid()) {
			System.out.println(myPrivateMessage.getNodeName() + " receiveMessage -- > election phase 4");
			myPrivateMessage.setMessage("leader");
			electedMessage.setUid(myPrivateMessage.getUid());
			sendToNeighbour(myPrivateMessage);
			myPrivateMessage.setMessage("non-participant");
			return 4;
		}
	}
	else {
		if (message.getMessage().equalsIgnoreCase(myPrivateMessage.getMessage())) {
			System.out.println(myPrivateMessage.getNodeName() + " election is over I am a leader UID: " + message.getUid());
			return 5;
		}
		else {
			myPrivateMessage.setMessage("non-participant");
			System.out.println(myPrivateMessage.getNodeName() + " receiveMessage -- > election phase 6 -- > Elected leader is: " +message.getNodeName() + " UID: "+ message.getUid());
			electedMessage.setUid(message.getUid());
			sendToNeighbour(message);
			return 6;
		}
	}
		return 0;
	}
	
	private void connectToServer(String ipAddress, int port) throws RemoteException, NotBoundException {
		System.out.println("connecting from "+myPrivateMessage.getNodeName()+" to second Node ");
		connected = true;
		bindName = "election";
		registry = LocateRegistry.getRegistry(ipAddress, port);
		evalInterface = (EvaluationInterface) registry.lookup(bindName); 
	}
	
	public String getIpAddress() {
		return ipAddress;
	}
	
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	
	public int getPort() {
		return port;
	}
	
	public void setPort(int port) {
		this.port = port;
	}
	
	public String getNodeName() {
		return nodeName;
	}
	
	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}
	
	public int getValue() {
		return value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	public Message getMyPrivateMessage() {
		return myPrivateMessage;
	}

	public void setMyPrivateMessage(Message myPrivateMessage) {
		this.myPrivateMessage = myPrivateMessage;
	}
}
