package xd36dsv.valiclud.cvi1.simpledb;

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
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import xd36dsv.valiclud.cvi1.exceptions.DBExistException;
import xd36dsv.valiclud.cvi1.exceptions.DBNotFoundException;
import xd36dsv.valiclud.cvi1.exceptions.DuplicateKeyException;
import xd36dsv.valiclud.cvi1.exceptions.KeyNotFoundException;


public class DBRecordDAO implements DBRecordDAOInterface{

	private Map<Database, Set<DBRecord>> allDBRecords;
	private Set<DBRecord> set = new HashSet<DBRecord>();	
	private SimpleDateFormat formatt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private  String[] allDBs;
	private String DBFolder = "./databases";
	
	private static DBRecordDAO instance;
    
	/**
     * @return the instance
	 * @throws ApplicationException 
     */
    public static DBRecordDAO getInstance() throws  RemoteException, NumberFormatException, ParseException, IOException, DBNotFoundException {
    	
    	if(instance == null) {
            instance = new DBRecordDAO();
         }
         return instance;
    }
	
	private DBRecordDAO() throws  RemoteException, NumberFormatException, ParseException, IOException, DBNotFoundException {
		super();
		instance = this;
		
		boolean success = (new File(DBFolder)).mkdirs();
		 if (!success) {
		     //System.out.println("Did not manage to create new directory, directory already created");
		 }	 
		 	allDBs = listDB();	 	
		 	allDBRecords = new HashMap<Database,Set<DBRecord>>();
		 	
		 	for (String s : allDBs) {		 		
		 		set = getAllRecordsFromFile(s);
		 		allDBRecords.put(new Database(s), set);
		 		set.clear();
		 	}
	}
	
	@Override
	public String[] listDB()  {
		ArrayList<String> outStrings = new ArrayList<String>();		
		File folder = new File(DBFolder);
		File[] listOfFiles = null;
	    listOfFiles = folder.listFiles();    
	    String files;
	    if (listOfFiles == null)
	    	return null;
	    
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

	@Override
	public synchronized boolean createDB(String dbname) throws DBExistException, IOException {
		
		if (allDBRecords.containsKey(dbname)) {
			throw new DBExistException("ERROR in createDB command - database \"" + dbname + "\" already exists ");
		}
		
		String suffix = ".dbcsv";
		String newDB = dbname.concat(suffix);
		File f = new File(DBFolder+ "/" + newDB);

		if(f.createNewFile()) {
			return true;
		}   
		else {
			if (dbExists(dbname)){			
				throw new DBExistException("ERROR in createDB command - database \"" + dbname + "\" already exists ");
			}
			else
				throw new IOException("ERROR in createDB command - database \"" + dbname + "\" could not create new file ");	
		}
	}
	
	@Override
	public synchronized Integer insert(String dbname, Integer key, String message)
			throws DBNotFoundException, DuplicateKeyException {
		Set<DBRecord> tempset;
		if (dbExists(dbname)){
			if (allDBRecords.get(new Database(dbname)) == null) {
				tempset = new HashSet<DBRecord>();	
			}
			else {
				tempset = allDBRecords.get(new Database(dbname));			
			}
			
			for (DBRecord dbr : tempset) {
				if (dbr.getKey().equals(key)){
					throw new DuplicateKeyException("ERROR in insert command - key \"" + Integer.toString(key) + "\" already exists, record was not inserted."  );
				}
			}
			
			DBRecord record = new DBRecord( new Date(),  new Date(), key, message);
			tempset.add(record);
			allDBRecords.put(new Database(dbname), tempset);
		}
		else {
			throw new DBNotFoundException("ERROR in insert command - database \"" + dbname + "\" does not exist. "  );	
		}		
		return key;
	}
	@Override
	public synchronized Integer update(String dbname, Integer key, String message)
			throws DBNotFoundException, KeyNotFoundException {
		Set<DBRecord> tempset;
		DBRecord record = null;
		
		if (dbExists( dbname)){
			if (allDBRecords.get(new Database(dbname)) == null) {
				tempset = new HashSet<DBRecord>();	
				throw new KeyNotFoundException("ERROR in update command - record key \"" +  Integer.toString(key) + "\" does not exist. Database file is empty."  );	
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
				throw new KeyNotFoundException("ERROR in update command - record key \"" +  Integer.toString(key) + "\" does not exist. "  );	
			}
			else {
				record.setTsModify(new Date());
				record.setMessage(message);
				tempset.add(record);
				allDBRecords.put(new Database(dbname), tempset);
				return key;	
			}
		}
		else {
			throw new DBNotFoundException("ERROR in update command - database \"" + dbname + "\" does not exist. "  );	
		}
	}

	@Override
	public DBRecord get(String dbname, Integer key) throws DBNotFoundException,
			KeyNotFoundException {
		Set<DBRecord> tempset;
		DBRecord record = null;
		
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
				if (dbr.getKey().equals(key)) {
						 record = dbr;
						 break;
				}
			}
			
			if (record == null) {
				throw new KeyNotFoundException("ERROR in get command - record key \"" +  Integer.toString(key) + "\" does not exist. "  );	
			}
			else {
				return record;
			}
		}
		else {
				throw new DBNotFoundException("ERROR in get command - database \"" + dbname + "\" does not exist.");	
		}
	}

	@Override
	public  DBRecord[] getA(String dbname, Integer[] key)
			throws DBNotFoundException, KeyNotFoundException {
			Set<DBRecord> tempset;
			Set<DBRecord> setsDBR = new HashSet<DBRecord>();	
			
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
				
				for (Integer i : key) {
				if (dbr.getKey().equals(i)) {
					setsDBR.add(dbr);
					}
				}
			}
			
			if (setsDBR.isEmpty()) {
				throw new KeyNotFoundException("ERROR in getA command - required record keys do not exist.");	
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

	@Override
	public synchronized void flush() throws IOException {

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
	}
	
	private boolean dbExists(String name){
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
	
	synchronized Set<DBRecord> getAllRecords(String dbname){
		return allDBRecords.get(new Database(dbname));
	}
	
	
	synchronized Set<DBRecord> getAllRecordsFromFile(String dbname) throws NumberFormatException, IOException, ParseException, DBNotFoundException {
		
		String suffix = ".dbcsv";
		Set<DBRecord> tempSet = new HashSet<DBRecord>();
		String [] temp = new String[4];
		BufferedReader bufRdr = null;
		FileReader fileR = null;
		
	if (dbExists( dbname)){
		String db = dbname.concat(suffix);
		try {
			File file = new File(DBFolder+ "/"+db);
			if (!file.exists())
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
				r = new DBRecord(formatt.parse(temp[0]), formatt.parse(temp[1]), Integer.valueOf(temp[2]), temp[3]);
				tempSet.add(r);		
			}				 			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new IOException("ERROR in reading from file - could not read from the file " +e.getLocalizedMessage() );
		}	catch (NumberFormatException e) {
				e.printStackTrace();
				throw new NumberFormatException("ERROR in reading from file - could not convert to number " +e.getLocalizedMessage() );
		} catch (ParseException e) {
				e.printStackTrace();
				throw new ParseException("ERROR in reading from file - could not parse the date value from file " +e.getLocalizedMessage(), 1 );
		} finally {
				//close the file
				bufRdr.close();
				fileR.close();
		}
	}
	else {
		throw new DBNotFoundException("ERROR in in reading from file - database \"" + dbname + "\" does not exist.");	
	}
	return tempSet;	
	}
}
