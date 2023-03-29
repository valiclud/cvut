package xd36dsv.valiclud.cvi1.server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import xd36dsv.valiclud.cvi1.simpledb.DBRecordDAO;
import xd36dsv.valiclud.cvi1.simpledb.DBRecordDAOInterface;

public class Server {
	
	public static void main(String[] args) {
		
		String dbname = "DB";
		
		try {
			
			DBRecordDAOInterface dbi =  DBRecordDAO.getInstance();
			DBRecordDAOInterface dbstub = (DBRecordDAOInterface) UnicastRemoteObject.exportObject(dbi, 50000);
			Registry dbregistry = LocateRegistry.createRegistry( Integer.parseInt(args[1]) );
			dbregistry.rebind(dbname, dbstub); 
			
			System.err.println("Server succesfully started and bind");			
		}
		catch (Exception e) {
			e.printStackTrace();
			System.err.println("Data exception: " + e.getMessage());
		}
	}
}