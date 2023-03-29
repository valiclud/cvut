package xd36dsv.valiclud.cvi2.client;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.StringTokenizer;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
import org.apache.xmlrpc.client.XmlRpcSunHttpTransportFactory;

import xd36dsv.valiclud.cvi2.simpledb.DBRecord;


public class Client {
	
    public static void main(String[] args) throws Exception {
    	
        // create client configuration
        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl(); 
//        InetAddress addr = InetAddress.getLocalHost();
//        config.setServerURL(new URL("http://127.0.0.1:2020"));
        config.setServerURL(new URL("http://" + args[0] + ":" + Integer.parseInt(args[1])));      
        config.setEnabledForExtensions(true);		// true -> setting extension
        config.setConnectionTimeout(60 * 1000);		// setting timeout
        config.setReplyTimeout(60 * 1000);			// setting reply timeout       
        //create client
        XmlRpcClient client = new XmlRpcClient(); 
      
        // create transport part - using java.net.URLConnection for http1.0
        client.setTransportFactory(new XmlRpcSunHttpTransportFactory(client));
        // Jakarta Common HttpClient - vyzaduje commons-httpclient-???.jar
        // client.setTransportFactory(new XmlRpcCommonsTransportFactory(client)); 
        client.setConfig(config);   
        // ClientFactory factory = new ClientFactory(client);
        // DBRecordDAOInterface dbInterface = (DBRecordDAOInterface) factory.newInstance(DBRecordDAOInterface.class);    
        
		File logfile = null;
		FileWriter fw = null;
		PrintWriter out = null;
		try {		
			//output log file		
			logfile = new File("clientLogs.log");
			if (! logfile.exists())
				logfile.createNewFile();
			fw = new FileWriter(logfile);
			out = new PrintWriter(fw, false);
			
			//testing database			
			File file = new File(args[2]);
			int row = 0;
			int col = 0;
			String[][] numbers=new String[26][16];
			try {
					if(file.exists()){
					System.out.println("Input file \""+ file.getName()+"\" with database commands exists");
					out.println("Input file \""+ file.getName()+"\" with database commands exists");
					System.out.println("-------------------------------------------");
					out.println("-------------------------------------------");
					}   
					   
					BufferedReader bufRdr;
					bufRdr = new BufferedReader(new FileReader(file));
					String line = null;
						
					while((line = bufRdr.readLine()) != null){
					StringTokenizer st = new StringTokenizer(line,";");
					col=0;
					while (st.hasMoreTokens()){
					numbers[row][col] = st.nextToken().replace("\"", "");
					col++;
					}
					row++;
					}
					bufRdr.close();
					

				for (int i = 0; i < row; i++) {
					
					try {
						
					switch((numbers[i][0]).toLowerCase()) {
					
					case ("listdb")		:	System.out.println(">> ListDB command ");
											out.println(">> ListDB command ");
											Object[] params0 = new Object[0] ;
											Object [] s =  (Object[]) client.execute("xmlrpc.Database.listDB", params0);
//											Object [] s =  (Object[]) dbInterface.listDB();
											for (Object dbstring : s ){
												System.out.println("<< ListDB command OK databases: \"" + dbstring.toString() +  "\"");
												out.println("<< ListDB command OK databases: \"" + dbstring.toString() +  "\"");
											}
											System.out.println("-------------------------------------------");
											out.println("-------------------------------------------");
											break;
					case ("createdb")	:	System.out.println(">> CreateDB command database: \"" + numbers[i][1] +  "\"");
											out.println(">> CreateDB command database: \"" + numbers[i][1] +  "\"");
											Object[] params1 = new Object[] { numbers[i][1]};
											boolean result1 = (boolean) client.execute("xmlrpc.Database.createDB", params1);
//											dbInterface.createDB(numbers[i][1]);
											System.out.println("<< CreateDB command OK");
											out.println("<< CreateDB command OK");
											System.out.println("-------------------------------------------");
											out.println("-------------------------------------------");
											break;
					case ("insert")		:	System.out.println(">> Insert command database: \"" + numbers[i][1] + "\" key: \""+ (numbers[i][2].trim()).toString() + "\" message: \"" +  numbers[i][3] +  "\"");
											out.println(">> Insert command database: \"" + numbers[i][1] + "\" key: \""+ (numbers[i][2].trim()).toString() + "\" message: \"" +  numbers[i][3] +  "\"");
											Object[] params2 = new Object[] { numbers[i][1], Integer.valueOf(numbers[i][2].trim()), numbers[i][3].trim() };
											Integer result2 = (Integer) client.execute("xmlrpc.Database.insert", params2);
//											dbInterface.insert(numbers[i][1], Integer.valueOf(numbers[i][2].trim()), numbers[i][3].trim());
											System.out.println("<< Insert command OK");
											out.println("<< Insert command OK");
											System.out.println("-------------------------------------------");
											out.println("-------------------------------------------");
											break;
					case ("update")		:	System.out.println(">> Update command database: \"" + numbers[i][1] + "\" key: \""+ numbers[i][2].trim().toString() + "\" message: \"" +  numbers[i][3] +  "\"");
											out.println(">> Update command database: \"" + numbers[i][1] + "\" key: \""+ numbers[i][2].trim().toString() + "\" message: \"" +  numbers[i][3] +  "\"");
											Object[] params3 = new Object[] { numbers[i][1], Integer.valueOf(numbers[i][2].trim()), numbers[i][3].trim() };
											Integer result3 = (Integer) client.execute("xmlrpc.Database.update", params3);
//											dbInterface.update(numbers[i][1], Integer.valueOf(numbers[i][2].trim()), numbers[i][3].trim());
											System.out.println("<< Update command OK");
											out.println("<< Update command OK");
											System.out.println("-------------------------------------------");
											out.println("-------------------------------------------");
											break;
					case ("get")		:	System.out.println(">> Get record command from database: \"" + numbers[i][1] +"\" key: \"" + (numbers[i][2].trim()).toString()+  "\"");
											out.println(">> Get record command from database: \"" + numbers[i][1] +"\" key: \"" + (numbers[i][2].trim()).toString()+  "\"");
											Object[] params4 = new Object[] { numbers[i][1], Integer.valueOf(numbers[i][2].trim()) };
											DBRecord record = (DBRecord) client.execute("xmlrpc.Database.get", params4);		
											System.out.println("<< Get record command OK key: " +record.toString());
											out.println("<< Get record command OK key: " +record.toString());
											System.out.println("-------------------------------------------");
											out.println("-------------------------------------------");
											break;
					case ("geta")		:	Integer [] tempI = new Integer [16];
											int j = 2;
											for (j = 2; j < numbers[i].length; j++) {
												if (numbers[i][j] != null){
													tempI [j-2] = Integer.valueOf(numbers[i][j].trim());
												}
												else
													break;
											}				
											System.out.println(">> getA records command from database: \"" + numbers[i][1] +"\" from key: \"" + (numbers[i][2].trim()).toString() + "\" to key: \"" + (numbers[i][j-1].trim()).toString()+  "\"");
											out.println(">> getA records command from database: \"" + numbers[i][1] +"\" from key: \"" + (numbers[i][2].trim()).toString() + "\" to key: \"" + (numbers[i][j-1].trim()).toString()+  "\"");
											Object[] params5 = new Object[] { numbers[i][1], (Object [] )tempI};
											Object [] ob = (Object []) client.execute("xmlrpc.Database.getA", params5);	
//											DBRecord [] dbr = (DBRecord []) ob;
//											DBRecord [] dbr = (DBRecord [])dbInterface.getA(numbers[i][1], tempI);
											for (Object dbrecord : ob) {
												System.out.println("<< GetA records command OK key: " + dbrecord.toString());
												out.println("<< GetA records command OK key: " + dbrecord.toString());
											}										
											System.out.println("-------------------------------------------");
											out.println("-------------------------------------------");
											break;
					case ("flush")		:	System.out.println(">> Flush command");
											out.println(">> Flush command");
											Object[] params6 = new Object[0];
											client.execute("xmlrpc.Database.flush", params6);										
//											boolean result1 = (boolean) dbInterface.flush();
											System.out.println("<< Flush command OK");
											out.println("<< Flush command OK");
											System.out.println("-------------------------------------------");
											out.println("-------------------------------------------");
											break;
					default				:	System.out.println("<< ERROR - Command \"" + numbers[i][0] + "\" does not exist");
											out.println("<< ERROR - Command \"" + numbers[i][0] + "\" does not exist");
											System.out.println("-------------------------------------------");
											out.println("-------------------------------------------");
											break;				
							}
					}
					catch (NumberFormatException e) {
//						e.printStackTrace();
						System.err.println("<<  ERROR - NumberFormatException, record was not inserted/updated " + e.getMessage());
						out.println("<< ERROR - NumberFormatException " + e.getMessage());
						System.out.println("-------------------------------------------");
						out.println("-------------------------------------------");
					}
					catch (XmlRpcException e) {
//						e.printStackTrace();
						System.err.println("<<  ERROR - XmlRpcException, " + e.getMessage());
						out.println("<< ERROR - XmlRpcException " + e.getMessage());
						System.out.println("-------------------------------------------");
						out.println("-------------------------------------------");
					}				
					catch(Exception e) {
						e.printStackTrace();
						System.err.println("<<  ERROR - Exception, record was not inserted " + e.getMessage());
						out.println("<< ERROR - Exception " + e.getMessage());
						System.out.println("-------------------------------------------");
						out.println("-------------------------------------------");
					}
				}
			}
			catch (FileNotFoundException e) {
				//e.printStackTrace();
				System.err.println("<< ERROR - Input file with database command does not exist " +e.getMessage() );
				out.println("<< ERROR - Input file with database command does not exist " +e.getMessage() );
				System.out.println("-------------------------------------------");
				out.println("-------------------------------------------");
			} catch (IOException e) {
				//e.printStackTrace();
				System.err.println("<< ERROR - Can not read from input file with database command " +e.getMessage() );
				out.println("<< ERROR - Can not read from input file with database command " +e.getMessage() );
				System.out.println("-------------------------------------------");
				out.println("-------------------------------------------");
			} 
			} catch (RemoteException e) {
//				e.printStackTrace();
				System.err.println("<< ERROR - RemoteException " +e.getMessage() );
				out.println("<< ERROR - RemoteException " +e.getMessage() );
				System.out.println("-------------------------------------------");
				out.println("-------------------------------------------");
			} finally {
				try {	
				 if(fw != null)						
					fw.close();
				 if (out != null)
					 out.close();
				} catch (IOException e) {
//					e.printStackTrace();
					System.err.println("<< ERROR - IOException " +e.getMessage() );
					System.out.println("-------------------------------------------");
				}			
		 }
			System.out.println("Client has successfully finished");
     }
}






