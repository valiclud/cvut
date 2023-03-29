package xd36dsv.valiclud.cvi1.client;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.StringTokenizer;

import xd36dsv.valiclud.cvi1.exceptions.DBExistException;
import xd36dsv.valiclud.cvi1.exceptions.DBNotFoundException;
import xd36dsv.valiclud.cvi1.exceptions.DuplicateKeyException;
import xd36dsv.valiclud.cvi1.exceptions.KeyNotFoundException;
import xd36dsv.valiclud.cvi1.simpledb.DBRecord;
import xd36dsv.valiclud.cvi1.simpledb.DBRecordDAOInterface;

public class Client {

	public static void main(String args[]) {
//		Possible logging for future use		
//		final Logger log = Logger.getLogger(Client.class.getName());
//		log.setLevel(Level.ALL);
//		ConsoleHandler handler = new ConsoleHandler();
//		handler.setFormatter(new SimpleFormatter());
//		handler.setLevel(Level.ALL);
//		log.addHandler(handler);
//		log.fine("hello world");
		
//		if (System.getSecurityManager() == null)
//			System.setSecurityManager(new RMISecurityManager());
		File logfile = null;
		FileWriter fw = null;
		PrintWriter out = null;
		try {		
			DBRecordDAOInterface dbInterface;
			String sbname = "DB";
			Registry registry;
			registry = LocateRegistry.getRegistry(args[0], Integer.parseInt(args[1]));
			dbInterface = (DBRecordDAOInterface) registry.lookup(sbname); 
				
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
			String[][] numbers=new String[24][16];
			try {
					if(file.exists()){
						System.out.println("Input file \""+ file.getName()+"\" with database commands exists");
						out.println("Input file \""+ file.getName()+"\" with database commands exists");
						System.out.println("-------------------------------------------");
						out.println("-------------------------------------------");
						}     
					else {
						throw new FileNotFoundException(args[2]);
						} 
					BufferedReader bufRdr;
					bufRdr = new BufferedReader(new FileReader(file));
					String line = null;
						
					while((line = bufRdr.readLine()) != null){
					StringTokenizer st = new StringTokenizer(line,";");
					col=0;
					while (st.hasMoreTokens()){
					numbers[row][col] = st.nextToken().replace("\"", "");
					//System.out.print(numbers[row][col]+" ");
					col++;
					}
					//System.out.println();
					row++;
					}
					bufRdr.close();
					

				for (int i = 0; i < row; i++) {
					
					try {
						
					switch((numbers[i][0]).toLowerCase()) {
					
					case ("listdb")		:	System.out.println(">> ListDB command ");
											out.println(">> ListDB command ");
											String [] s = dbInterface.listDB();
											for (String dbstring : s ) {
												System.out.println("<< ListDB command OK databases: \"" + dbstring +  "\"");
											out.println("<< ListDB command OK databases: \"" + dbstring +  "\"");
											}
											System.out.println("-------------------------------------------");
											out.println("-------------------------------------------");
											break;
					case ("createdb")	:	System.out.println(">> CreateDB command database: \"" + numbers[i][1] +  "\"");
											out.println(">> CreateDB command database: \"" + numbers[i][1] +  "\"");
											dbInterface.createDB(numbers[i][1]);
											System.out.println("<< CreateDB command OK");
											out.println("<< CreateDB command OK");
											System.out.println("-------------------------------------------");
											out.println("-------------------------------------------");
											break;
					case ("insert")		:	System.out.println(">> Insert command database: \"" + numbers[i][1] + "\" key: \""+ (numbers[i][2].trim()).toString() + "\" message: \"" +  numbers[i][3] +  "\"");
											out.println(">> Insert command database: \"" + numbers[i][1] + "\" key: \""+ (numbers[i][2].trim()).toString() + "\" message: \"" +  numbers[i][3] +  "\"");
											dbInterface.insert(numbers[i][1], Integer.valueOf(numbers[i][2].trim()), numbers[i][3].trim());
											System.out.println("<< Insert command OK");
											out.println("<< Insert command OK");
											System.out.println("-------------------------------------------");
											out.println("-------------------------------------------");
											break;
					case ("update")		:	System.out.println(">> Update command database: \"" + numbers[i][1] + "\" key: \""+ numbers[i][2].trim().toString() + "\" message: \"" +  numbers[i][3] +  "\"");
											out.println(">> Update command database: \"" + numbers[i][1] + "\" key: \""+ numbers[i][2].trim().toString() + "\" message: \"" +  numbers[i][3] +  "\"");
											dbInterface.update(numbers[i][1], Integer.valueOf(numbers[i][2].trim()), numbers[i][3].trim());
											System.out.println("<< Update command OK");
											out.println("<< Update command OK");
											System.out.println("-------------------------------------------");
											out.println("-------------------------------------------");
											break;
					case ("get")		:	System.out.println(">> Get record command from database: \"" + numbers[i][1] +"\" key: \"" + (numbers[i][2].trim()).toString()+  "\"");
											out.println(">> Get record command from database: \"" + numbers[i][1] +"\" key: \"" + (numbers[i][2].trim()).toString()+  "\"");
											DBRecord record = dbInterface.get(numbers[i][1],Integer.valueOf(numbers[i][2].trim()));
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
											DBRecord [] dbr = dbInterface.getA(numbers[i][1], tempI);
											for (DBRecord dbrecord : dbr) {
												System.out.println("<< GetA records command OK key: " + dbrecord.toString());
												out.println("<< GetA records command OK key: " + dbrecord.toString());
											}										
											System.out.println("-------------------------------------------");
											out.println("-------------------------------------------");
											break;
					case ("flush")		:	System.out.println(">> Flush command");
											out.println(">> Flush command");
											dbInterface.flush();
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
					catch (DuplicateKeyException dke) {
//						dke.printStackTrace();
						System.err.println("<< " + dke.getMessage());
						out.println("<< " + dke.getMessage());
						System.out.println("-------------------------------------------");
						out.println("-------------------------------------------");
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
//						e.printStackTrace();
						System.err.println("<< " + e.getMessage());
						out.println("<< " + e.getMessage());
						System.out.println("-------------------------------------------");
						out.println("-------------------------------------------");
					} catch (DBExistException e) {
						// TODO Auto-generated catch block
//						e.printStackTrace();
						System.err.println("<< " + e.getMessage());
						out.println("<< " + e.getMessage());
						System.out.println("-------------------------------------------");
						out.println("-------------------------------------------");
					} catch (DBNotFoundException e) {
						// TODO Auto-generated catch block
//						e.printStackTrace();
						System.err.println("<< " + e.getMessage());
						out.println("<< " + e.getMessage());
						System.out.println("-------------------------------------------");
						out.println("-------------------------------------------");
					}  catch (KeyNotFoundException e) {
						// TODO Auto-generated catch block
//						e.printStackTrace();
						System.err.println("<< " + e.getMessage());
						out.println("<< " + e.getMessage());
						System.out.println("-------------------------------------------");
						out.println("-------------------------------------------");
						}  
						catch (NumberFormatException e) {
//						e.printStackTrace();
						System.err.println("<<  ERROR - NumberFormatException, record was not inserted " + e.getMessage());
						out.println("<< ERROR - NumberFormatException " + e.getMessage());
						System.out.println("-------------------------------------------");
						out.println("-------------------------------------------");
						}catch (IOException e) {
//						e.printStackTrace();
						System.err.println("<< " + e.getMessage());
						out.println("<< " + e.getMessage());
						System.out.println("-------------------------------------------");
						out.println("-------------------------------------------");
						} catch(Exception ex) {
						ex.printStackTrace();
					}
				}
			}
			catch (FileNotFoundException e)
			{
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
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally {
			try {	
				 if(fw != null)						
					fw.close();
				 if (out != null)
					 out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			
			}
			System.out.println("Client has successfully finished");
	}
}