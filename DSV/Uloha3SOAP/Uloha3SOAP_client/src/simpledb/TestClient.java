package simpledb;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import org.apache.axis2.AxisFault;


public class TestClient {
	
	public static void main(String[] args)  { 
		
		File logfile = null;
		FileWriter fw = null;
		PrintWriter out = null;
		
	try {
		// create stub
		SimpledbStub stub = new SimpledbStub();
		// create requests
		SimpledbStub.CreateDB create = new SimpledbStub.CreateDB();
		SimpledbStub.ListDB list = new SimpledbStub.ListDB();
		SimpledbStub.Insert insert = new SimpledbStub.Insert();
		SimpledbStub.Update update = new SimpledbStub.Update();
		SimpledbStub.Get get = new SimpledbStub.Get();
		SimpledbStub.GetA getA = new SimpledbStub.GetA();
		SimpledbStub.Flush flush = new SimpledbStub.Flush();
		
		String sbname = "DB";
		//output log file		
		logfile = new File("clientLogs.log");
		if (! logfile.exists())
			logfile.createNewFile();
		fw = new FileWriter(logfile);
		out = new PrintWriter(fw, false);
		
		//testing database			
		File file = new File(args[0]);
		int row = 0;
		int col = 0;
		String[][] numbers=new String[26][16];
		
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
										SimpledbStub.ListDBResponse listDBResponse = stub.listDB(list);
										String [] s = listDBResponse.get_return();
										for (String dbstring : s ){
											System.out.println("<< ListDB command OK databases: \"" + dbstring.toString() +  "\"");
											out.println("<< ListDB command OK databases: \"" + dbstring.toString() +  "\"");
										}
										System.out.println("-------------------------------------------");
										out.println("-------------------------------------------");
										break;
				case ("createdb")	:	System.out.println(">> CreateDB command database: \"" + numbers[i][1] +  "\"");
										out.println(">> CreateDB command database: \"" + numbers[i][1] +  "\"");
										create.setDbname(numbers[i][1]);
										SimpledbStub.CreateDBResponse response = stub.createDB(create);
//										if (response.get_return()){
										System.out.println("<< CreateDB command OK");
										out.println("<< CreateDB command OK");
										System.out.println("-------------------------------------------");
										out.println("-------------------------------------------");
//										}
										break;
				case ("insert")		:	System.out.println(">> Insert command database: \"" + numbers[i][1] + "\" key: \""+ (numbers[i][2].trim()).toString() + "\" message: \"" +  numbers[i][3] +  "\"");
										out.println(">> Insert command database: \"" + numbers[i][1] + "\" key: \""+ (numbers[i][2].trim()).toString() + "\" message: \"" +  numbers[i][3] +  "\"");
										Object[] params2 = new Object[] { numbers[i][1], Integer.valueOf(numbers[i][2].trim()), numbers[i][3].trim() };
										insert.setDbname(numbers[i][1]);
										insert.setKey(Integer.valueOf(numbers[i][2].trim()));
										insert.setMessage(numbers[i][3].trim());	
										SimpledbStub.InsertResponse insertResponse = stub.insert(insert);	
										System.out.println("<< Insert command OK");
										out.println("<< Insert command OK");
										System.out.println("-------------------------------------------");
										out.println("-------------------------------------------");
										break;
				case ("update")		:	System.out.println(">> Update command database: \"" + numbers[i][1] + "\" key: \""+ numbers[i][2].trim().toString() + "\" message: \"" +  numbers[i][3] +  "\"");
										out.println(">> Update command database: \"" + numbers[i][1] + "\" key: \""+ numbers[i][2].trim().toString() + "\" message: \"" +  numbers[i][3] +  "\"");
										Object[] params3 = new Object[] { numbers[i][1], Integer.valueOf(numbers[i][2].trim()), numbers[i][3].trim() };
										update.setDbname(numbers[i][1]);
										update.setKey(Integer.valueOf(numbers[i][2].trim()));
										update.setMessage(numbers[i][3].trim());	
										SimpledbStub.UpdateResponse updateResponse = stub.update(update);	
										System.out.println("<< Update command OK");
										out.println("<< Update command OK");
										System.out.println("-------------------------------------------");
										out.println("-------------------------------------------");
										break;
				case ("get")		:	System.out.println(">> Get record command from database: \"" + numbers[i][1] +"\" key: \"" + (numbers[i][2].trim()).toString()+  "\"");
										out.println(">> Get record command from database: \"" + numbers[i][1] +"\" key: \"" + (numbers[i][2].trim()).toString()+  "\"");
										Object[] params4 = new Object[] { numbers[i][1], Integer.valueOf(numbers[i][2].trim()) };
										get.setDbname( numbers[i][1]);
										get.setKey(Integer.valueOf(numbers[i][2].trim()));
										SimpledbStub.GetResponse getResponse = stub.get(get);
										simpledb.SimpledbStub.DBRecord record = getResponse.get_return();
										System.out.println("<< Get record command OK key: " +record.getKey() + " message: " + record.getMessage());
										out.println("<< Get record command OK key: " +record.getKey() + " message:  " + record.getMessage());
										System.out.println("-------------------------------------------");
										out.println("-------------------------------------------");
										break;
				case ("geta")		:	int [] tempI = new int [16];
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
										getA.setDbname(numbers[i][1]);
										getA.setKey(tempI);
//										Object[] params5 = new Object[] { numbers[i][1], (Object [] )tempI};
										SimpledbStub.GetAResponse rsp = stub.getA(getA);
										simpledb.SimpledbStub.DBRecord [] records = rsp.get_return();
										for (simpledb.SimpledbStub.DBRecord dbrecord : records) {
											System.out.println("<< GetA records command OK key: " + dbrecord.getKey() + " message: " + dbrecord.getMessage());
											out.println("<< GetA records command OK key: " + dbrecord.getKey() + " message: " + dbrecord.getMessage());
										}										
										System.out.println("-------------------------------------------");
										out.println("-------------------------------------------");
										break;
				case ("flush")		:	System.out.println(">> Flush command");
										out.println(">> Flush command");
										SimpledbStub.FlushResponse flushResponse = stub.flush(flush);
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
					
		} catch (SimpledbDBNotFoundExceptionException e) {
//			e.printStackTrace();
			System.err.println("<< " + e.getMessage());
			out.println("<< " + e.getMessage());
			System.out.println("-------------------------------------------");
			out.println("-------------------------------------------");
		} catch (AxisFault e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SimpledbKeyNotFoundExceptionException e) {
//			e.printStackTrace();
			System.err.println("<< " + e.getMessage());
			out.println("<< " + e.getMessage());
			System.out.println("-------------------------------------------");
			out.println("-------------------------------------------");
		} catch (SimpledbRemoteExceptionException e) {
//			e.printStackTrace();
			System.err.println("<< " + e.getMessage());
			out.println("<< " + e.getMessage());
			System.out.println("-------------------------------------------");
			out.println("-------------------------------------------");
		} catch (SimpledbIOExceptionException e) {
//			e.printStackTrace();
			System.err.println("<< " + e.getMessage());
			out.println("<< " + e.getMessage());
			System.out.println("-------------------------------------------");
			out.println("-------------------------------------------");
		} catch (SimpledbDuplicateKeyExceptionException dke) {
//			dke.printStackTrace();
			System.err.println("<< " + dke.getMessage());
			out.println("<< " + dke.getMessage());
			System.out.println("-------------------------------------------");
			out.println("-------------------------------------------");
		} catch (java.rmi.RemoteException e) {
//			e.printStackTrace();
			System.err.println("<< " + e.getMessage());
			out.println("<< " + e.getMessage());
			System.out.println("-------------------------------------------");
			out.println("-------------------------------------------");
		} catch (SimpledbDBExistExceptionException e) {
//			e.printStackTrace();
			System.err.println("<< " + e.getMessage());
			out.println("<< " + e.getMessage());
			System.out.println("-------------------------------------------");
			out.println("-------------------------------------------");
			}	
		}	// end of for cyclus
	} catch (IOException e1) {
		e1.printStackTrace();
		}
	finally {
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
	}
}