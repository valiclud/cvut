package xd36dsv.valiclud.cvi1.simpledb;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;

import xd36dsv.valiclud.cvi1.exceptions.DBExistException;
import xd36dsv.valiclud.cvi1.exceptions.DBNotFoundException;
import xd36dsv.valiclud.cvi1.exceptions.DuplicateKeyException;
import xd36dsv.valiclud.cvi1.exceptions.KeyNotFoundException;




public interface DBRecordDAOInterface extends Remote {

	public String[] listDB() throws  RemoteException;

	boolean createDB(String dbname) throws DBExistException, RemoteException, IOException;
    
	Integer insert(String dbname, Integer key, String message) throws
	DBNotFoundException, DuplicateKeyException, RemoteException;
    
	Integer update(String dbname, Integer key, String message) throws
	DBNotFoundException, KeyNotFoundException, RemoteException;

	DBRecord get(String dbname, Integer key) throws DBNotFoundException,
	KeyNotFoundException, RemoteException;

	DBRecord[] getA(String dbname, Integer[] key) throws DBNotFoundException,
	KeyNotFoundException, RemoteException;
    
	void flush() throws RemoteException, IOException;

}
