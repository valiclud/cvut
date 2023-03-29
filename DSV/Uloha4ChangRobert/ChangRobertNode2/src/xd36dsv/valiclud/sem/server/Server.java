package xd36dsv.valiclud.sem.server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import xd36dsv.valiclud.sem.evaluation.Evaluation;
import xd36dsv.valiclud.sem.evaluation.EvaluationInterface;
import xd36dsv.valiclud.sem.evaluation.Message;


public class Server {
	
	public static void main(String[] args) {
		
		String bindName = "election";
		
		try {
			
			Message inputMessage = new Message(args[4] , "non-participant", Integer.parseInt(args[5]));
			
			Evaluation eval =  Evaluation.getInstance();
			eval.setMyPrivateMessage(inputMessage);
			eval.setIpAddress(args[2]);
			eval.setPort(Integer.parseInt(args[3]));
			EvaluationInterface evalInterface = eval;
//			EvaluationInterface evalInterface =  Evaluation.getInstance();
//			EvaluationInterface stub = (EvaluationInterface) UnicastRemoteObject.exportObject(evalInterface, 50001);
//			Registry dbregistry = LocateRegistry.createRegistry( 3001 );
			EvaluationInterface stub = (EvaluationInterface) UnicastRemoteObject.exportObject( evalInterface, Integer.parseInt(args[0]) );
			Registry dbregistry = LocateRegistry.createRegistry( Integer.parseInt(args[1]));
			dbregistry.rebind(bindName, stub); 
			
			System.err.println("Server "+ args[4] +" succesfully started and bind");			
		}
		catch (Exception e) {
			e.printStackTrace();
			System.err.println("Data exception: " + e.getMessage());
		}
	}
}