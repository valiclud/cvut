package xd36dsv.valiclud.cvi2.server;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.UnknownHostException;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.server.PropertyHandlerMapping;
import org.apache.xmlrpc.server.XmlRpcServer;
import org.apache.xmlrpc.server.XmlRpcServerConfigImpl;
import org.apache.xmlrpc.webserver.WebServer;

import xd36dsv.valiclud.cvi2.simpledb.DBRecordDAO;

public class Server {
	
	

    public static void main(String[] args) {
    	
    	final int port = Integer.parseInt(args[1]);
 	     
    	InetAddress addr = null;
    	File logfile = null;
		FileWriter fw = null;
		PrintWriter out = null;
    try {
    	//output log file		
		logfile = new File("serverLogs.log");
		if (! logfile.exists())
			logfile.createNewFile();
		fw = new FileWriter(logfile);
		out = new PrintWriter(fw, true);
		
		//addr = InetAddress.getByName("127.0.0.1");
		addr = InetAddress.getByName(args[0]);
		 // run web server - stand alone
        WebServer webServer = new WebServer(port, addr);
        System.out.println("Server started on "+addr+" on port "+port);
        // get XML-RPC Server from Web server
        XmlRpcServer xmlRpcServer = webServer.getXmlRpcServer();
        // mapping
        PropertyHandlerMapping phm = new PropertyHandlerMapping();
        // calling xmlrpc.database - > Instance is being created 
        phm.addHandler("xmlrpc.Database", DBRecordDAO.class); 
        // phm.addHandler(DBRecordDAOInterface.class.getName(), DBRecordDAO.class);
        // handler mapping
        xmlRpcServer.setHandlerMapping(phm);
        // set-up the server configuration
        XmlRpcServerConfigImpl serverConfig = (XmlRpcServerConfigImpl) xmlRpcServer.getConfig();
        serverConfig.setEnabledForExtensions(true);
        serverConfig.setContentLengthOptional(false);
        // run server
        webServer.start();
    	
		} catch (UnknownHostException e) {
   //		e.printStackTrace();
			System.err.println("<<  ERROR - UnknownHostException " + e.getMessage());
			out.println("<< ERROR - UnknownHostException " + e.getMessage());
			System.out.println("-------------------------------------------");
			out.println("-------------------------------------------");
		} 
	    catch (XmlRpcException e) {		
	//		e.printStackTrace();
			System.err.println("<<  ERROR - XmlRpcException " + e.getMessage());
			out.println("<< ERROR - XmlRpcException " + e.getMessage());
			System.out.println("-------------------------------------------");
			out.println("-------------------------------------------");
		} 
		catch (IOException e) {
    //		e.printStackTrace();
			System.err.println("<< ERROR - Can not read from input file with database command " +e.getMessage() );
			out.println("<< ERROR - Can not read from input file with database command " +e.getMessage() );
			System.out.println("-------------------------------------------");
			out.println("-------------------------------------------");
		} 
		catch (Exception e) {
	//		e.printStackTrace();
			System.err.println("<< ERROR - Exception " +e.getMessage() );
			out.println("<< ERROR - Exception " +e.getMessage() );
			System.out.println("-------------------------------------------");
			out.println("-------------------------------------------");
		} 
    }
}
