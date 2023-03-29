package xd36dsv.valiclud.sem.evaluation;

import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

import xd36dsv.valiclud.sem.exceptions.MessageNotReceivedException;
import xd36dsv.valiclud.sem.exceptions.MessageNotSentException;


public interface EvaluationInterface extends Remote {
	
	public int sendToNeighbour(Message message) throws MessageNotSentException, RemoteException, NotBoundException, MessageNotReceivedException;

	public int receiveMessage(Message message) throws MessageNotReceivedException, MessageNotSentException, RemoteException, NotBoundException;
}
