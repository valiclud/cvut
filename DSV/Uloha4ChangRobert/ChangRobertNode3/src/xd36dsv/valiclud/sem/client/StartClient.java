package xd36dsv.valiclud.sem.client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import xd36dsv.valiclud.sem.evaluation.EvaluationInterface;
import xd36dsv.valiclud.sem.evaluation.Message;
import xd36dsv.valiclud.sem.exceptions.MessageNotReceivedException;
import xd36dsv.valiclud.sem.exceptions.MessageNotSentException;


public class StartClient {
	
	public static void main(String args[]) {

		Registry registry;
		EvaluationInterface	evalInterface;
		String bindName;
		Message myPrivateMessage;
		
		bindName = "election";
		
		try {
			myPrivateMessage = new Message(args[2], "non-participant", Integer.parseInt(args[3]));
			
			registry = LocateRegistry.getRegistry(args[0], Integer.parseInt(args[1]));
			evalInterface = (EvaluationInterface) registry.lookup(bindName); 
			evalInterface.receiveMessage(myPrivateMessage);
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessageNotSentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessageNotReceivedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
