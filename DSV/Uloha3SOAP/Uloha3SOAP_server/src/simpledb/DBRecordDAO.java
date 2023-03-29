package simpledb;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import exceptions.DBExistException;
import exceptions.DBNotFoundException;
import exceptions.DuplicateKeyException;
import exceptions.KeyNotFoundException;

public class DBRecordDAO {

	private static ConcurrentMap<Database, Set<DBRecord>> allDBRecords;
	private static Set<DBRecord> set; 
	private SimpleDateFormat formatt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static  String[] allDBs;
	private static String DBFolder = "./databases";
	static File logfile = null;
	static PrintWriter out = null;

	
	static {
		boolean success = (new File(DBFolder)).mkdirs();
		 if (!success) {
		     System.out.println("Did not manage to create new directory, directory already created");
		 }	 
		 	allDBs = listDBStatic();	
				 	
		 	allDBRecords = new ConcurrentHashMap<Database,Set<DBRecord>>();
		 	
		 	for (String s : allDBs) {		 		
		 		
				set = getAllRecordsFromFile(s);
		 		allDBRecords.put(new Database(s), set);
		 		set.clear();
		 	}
		 	
		 	//output log file		
			logfile = new File("serverLogs2.log");
			if (! logfile.exists())
				try {
					logfile.createNewFile();
					out = new PrintWriter( new FileWriter(logfile), true);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			
	}

	public DBRecordDAO() throws  RemoteException, NumberFormatException, ParseException, IOException, DBNotFoundException {
	}

	private synchronized static  String[] listDBStatic()  {
		ArrayList<String> outStrings = new ArrayList<String>();		
		File folder = new File(DBFolder);
	    File[] listOfFiles = null;
	    listOfFiles = folder.listFiles();	    
	    String files;
	    
	    if (listOfFiles.equals(null)){
	    	return null;
	    }
	    
	    for (int i = 0; i < listOfFiles.length; i++) 
	    {	   
	     if (listOfFiles[i].isFile()) 
	     {
	     files = listOfFiles[i].getName();
	         if (files.endsWith(".dbcsv") || files.endsWith(".DBSCV"))
	         {
	            outStrings.add(listOfFiles[i].getName().substring(0, listOfFiles[i].getName().length() - 6));
	          }
	       }
	    }	  
	    String[] result = new String[outStrings.size()];
	    return outStrings.toArray(result);
	}

	public synchronized boolean createDB(String dbname) throws DBExistException, IOException, DBNotFoundException {

		String [] temp;
		String suffix = ".dbcsv";
		String newDB = dbname.concat(suffix);
		File f = new File(DBFolder+ "/" + newDB);

		if (dbExists(dbname)){			
			throw new DBExistException("ERROR in createDB command - database \"" + dbname + "\" already exists");
		}
		else if(f.createNewFile()) {
			if (allDBs.equals(null)){
				allDBs = new String[1];
				allDBs[0] = dbname;
			}
			else{
				temp = new String[allDBs.length+1];
				
				for (int i = 0; i < temp.length; i++) {
					if (i == temp.length -1) {
						temp[i] = dbname;
						break;
					}
					temp[i] = allDBs[i];
				}			
				allDBs = new String[temp.length];
				allDBs = temp;
			}			
		
			return true;
		}   
		else {
				throw new IOException("ERROR in createDB command - database \"" + dbname + "\" could not create new file ");	
		}
	}
	
	public synchronized Integer insert(String dbname, Integer key, String message)
			throws DBNotFoundException, DuplicateKeyException, IOException {

		Set<DBRecord> tempset;
		if (dbExists(dbname)){
			if (allDBRecords.get(new Database(dbname)) == null) {
				tempset = new HashSet<DBRecord>();	
			}
			else {
				tempset = allDBRecords.get(new Database(dbname));
			}
			
			for (DBRecord dbr : tempset) {
				if (dbr.getKey().equals(key)) {
					throw new DuplicateKeyException("ERROR in insert command - key \"" + Integer.toString(key) + "\" already exists, record was not inserted." );
				}
			}
			
			DBRecord record = new DBRecord( new Date(),  new Date(), key, message);
			tempset.add(record);
			allDBRecords.put(new Database(dbname), tempset);
		}
		else {
			throw new DBNotFoundException("ERROR in insert command - database \"" + dbname + "\" does not exist. " );	
		}		
		return key;
	}
	
	public synchronized Integer update(String dbname, Integer key, String message)
			throws DBNotFoundException, KeyNotFoundException, IOException {
		Set<DBRecord> tempset;
		DBRecord record = null;
		
		if (dbExists( dbname)){
			if (allDBRecords.get(new Database(dbname)) == null) {
				tempset = new HashSet<DBRecord>();	
				throw new KeyNotFoundException("ERROR in update command - record key \"" +  Integer.toString(key) + "\" does not exist. Database file is empty." );	
			}
			else {
				tempset = allDBRecords.get(new Database(dbname));			
			}
			
			for (DBRecord dbr : tempset) {
				if (dbr.getKey().equals(key)) {
						 record = dbr;
						 break;
				}
			}
			
			if (record == null) {
				throw new KeyNotFoundException("ERROR in update command - record key \"" +  Integer.toString(key) + "\" does not exist. " );	
			}
			else {
				record.setTsModify(new Date());
				record.setMessage(message);
				tempset.add(record);
				allDBRecords.put(new Database(dbname), tempset);
//				flush();
				return key;	
			}
		}
		else {
			throw new DBNotFoundException("ERROR in update command - database \"" + dbname + "\" does not exist. " );	
		}
	}

	public DBRecord get(String dbname, Integer key) throws DBNotFoundException,
			KeyNotFoundException, RemoteException {
		Set<DBRecord> tempset;
		DBRecord record = null;
		
		if (dbExists( dbname)){
			if (allDBRecords.get(new Database(dbname)) == null) {
				tempset = new HashSet<DBRecord>();	
				System.out.println("There are no records in database" );
				return null;
			}
			else {
				tempset = allDBRecords.get(new Database(dbname));			
			}
			
			for (DBRecord dbr : tempset) {
				if (dbr.getKey().equals(key)) {
						 record = dbr;
						 break;
				}
			}
			
			if (record == null) {
				throw new KeyNotFoundException("ERROR in get command - record key \"" +  Integer.toString(key) + "\" does not exist. " );	
			}
			else {
				return record;
			}
		}
		else {
				throw new DBNotFoundException("ERROR in get command - database \"" + dbname + "\" does not exist." );	
		}
	}

	public  DBRecord[] getA(String dbname, Integer[] key)
			throws DBNotFoundException, KeyNotFoundException, RemoteException {
			Set<DBRecord> tempset;
			Set<DBRecord> setsDBR = new HashSet<DBRecord>();	
			
			Integer [] iKey = new Integer [key.length];

			for (int i = 0 ; i < key.length; i ++) {
				iKey [i] =  key [i];
			}
		
			
		if (dbExists( dbname)){
			if (allDBRecords.get(new Database(dbname)) == null) {
				tempset = new HashSet<DBRecord>();	
				System.out.println("There are no records in database");
				return null;
			}
			else {
				tempset = allDBRecords.get(new Database(dbname));			
			}
			
			for (DBRecord dbr : tempset) {
				
				for (Integer i : iKey) {
					if (dbr.getKey().equals(i)) {
						setsDBR.add(dbr);
						}
				}
			}
			
			if (setsDBR.isEmpty()) {
				throw new KeyNotFoundException("ERROR in getA command - required record keys do not exist " );	
			}
			else {
				DBRecord[] result = new DBRecord[setsDBR.size()];
			    return setsDBR.toArray(result);
			}
		}
		else {
			throw new DBNotFoundException("ERROR in getA command - database \"" + dbname + "\" does not exist.");	
		}
	}

	public  synchronized boolean flush() throws IOException {
		String suffix = ".dbcsv";
		String newDB ; 
		File file = null;
		FileWriter fw = null;
		PrintWriter out = null;
		try {
		for (Database db : allDBRecords.keySet()) {
			
				newDB = db.getDbName().concat(suffix);
				file = new File(DBFolder+ "/" + newDB);	
				fw = new FileWriter(file);
				out = new PrintWriter(fw, true);
	
			for (DBRecord record : allDBRecords.get(db)) {
				out.print("\"" + formatt.format(record.getTsCreate()) + "\";\"" + formatt.format(record.getTsModify()) + "\";\"" +record.getKey().intValue() + "\";\"" + record.getMessage() + "\"" );
				out.println();
				out.flush();						
			}		
		  } 
		} catch (IOException e) {
			e.printStackTrace();
			throw new IOException("ERROR in flush command - could write databases to the file " +e.getLocalizedMessage() );
		}
		finally {
			out.close();
			fw.close();
			
		}
		return true;
	}
	
	private synchronized boolean dbExists(String name) throws RemoteException, DBNotFoundException{
		String[] dbNames = listDB();
		
		if (dbNames.length == 0)
			return false;
		
		for(String s : dbNames)
	    {
			if (s.equals(null))
				continue;
			
			if (s.equalsIgnoreCase(name))
				return true;
	    }		
		return false;
	}
	
	private synchronized static Set<DBRecord> getAllRecordsFromFile(String dbname) {
		SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String suffix = ".dbcsv";
		Set<DBRecord> tempSet = new HashSet<DBRecord>();
		String [] temp = new String[4];
		BufferedReader bufRdr = null;
		FileReader fileR = null;
		boolean dbExists = false;
		
		for(String s : allDBs)
	    {
			if (s.equalsIgnoreCase(dbname)) {
				dbExists = true;
				break;			
			}
	    }		
		
	if (dbExists){
		String db = dbname.concat(suffix);
		
		try {
			File file = new File(DBFolder+ "/"+db);
			if (! file.exists())
				file.createNewFile();
			fileR =  new FileReader(file);
			bufRdr = new BufferedReader(fileR);			
			String line = null;
			int col = 0;				 
			//read each line of text file
			while((line = bufRdr.readLine()) != null)
			{
				col = 0;
				StringTokenizer st = new StringTokenizer(line,";");
				while (st.hasMoreTokens())
				{
					//get next token and store it in the array
					temp[col] = st.nextToken().replace("\"", "");
					col++;
				}					
				DBRecord r = null;				
				r = new DBRecord(form.parse(temp[0]), form.parse(temp[1]), Integer.valueOf(temp[2]), temp[3]);
				tempSet.add(r);		
			}				 
			
		} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
		} catch (NumberFormatException e) {
				e.printStackTrace();
			
		} catch (ParseException e) {
				e.printStackTrace();
			
		} finally {
				//close the file
				try {
					bufRdr.close();
					fileR.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		}
	}
	else {	try {
					throw new DBNotFoundException("ERROR in in reading from file - database \"" + dbname + "\" does not exist.");
				} catch (DBNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
	}
	return tempSet;	
	}

	public String[] listDB() throws DBNotFoundException, RemoteException {
		return allDBs;
	}
}
