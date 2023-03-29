package xd36dsv.valiclud.cvi2.simpledb;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;

import org.apache.xmlrpc.XmlRpcException;

import xd36dsv.valiclud.cvi2.exceptions.DBExistException;
import xd36dsv.valiclud.cvi2.exceptions.DBNotFoundException;
import xd36dsv.valiclud.cvi2.exceptions.DuplicateKeyException;
import xd36dsv.valiclud.cvi2.exceptions.KeyNotFoundException;




public interface DBRecordDAOInterface extends Remote {

	public String[] listDB() throws  RemoteException;

	boolean  createDB(String dbname) throws DBExistException, RemoteException, IOException, XmlRpcException;
    
	Integer insert(String dbname, Integer key, String message) throws
	DBNotFoundException, DuplicateKeyException, RemoteException, IOException;
    
	Integer update(String dbname, Integer key, String message) throws
	DBNotFoundException, KeyNotFoundException, RemoteException, IOException;

	DBRecord get(String dbname, Integer key) throws DBNotFoundException,
	KeyNotFoundException, RemoteException;

	DBRecord[] getA(String dbname, Object[] key) throws DBNotFoundException,
	KeyNotFoundException, RemoteException;
    
	boolean flush() throws RemoteException, IOException;

}
