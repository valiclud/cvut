

package presentation;
import integration.*;



// TODO: Auto-generated Javadoc
/**
 * The Class Main.
 *
 * @author Ludvik Valíèek
 */
public class Main  {
	
	/**
	 * Logger for this class.
	 */
	static org.apache.log4j.Logger LOG = org.apache.log4j.Logger
			.getLogger(Main.class.getName());


   /** The inst. */
   private static Main inst;
   
   /** The interface dao. */
   private DAOInterface interfaceDAO;
      
   /**
    * The Enum DataSource.
    *
    * @author: Ludvik Valicek
    */
   public enum DataSource {/** The file. */
FILE, /** The sql. */
 SQL};

    /**
     * Gets the inst.
     *
     * @return the inst
     */
    public static Main getInst() {
        return inst;
    }

    /**
     * Instantiates a new main.
     *
     * @param d the d
     * @throws Exception the exception
     */
    private Main(DataSource d) throws Exception {
        inst = this;
        switch (d) {
                    case FILE:
                        interfaceDAO = new CustomerDAOFile();
                        break;
                    case SQL:
                        interfaceDAO = new CustomerDAOSql();
                        break;
                    }
     }


    /**
     * The main method.
     *
     * @param args the arguments
     * @throws Exception the exception
     */
    public static void main(String[] args) throws Exception {
        LOG.info("Starting application");
        DataSource d;
        if (args.length > 0 && "sql".startsWith(args[0])) {
            d = DataSource.SQL;
        } else if (args.length > 0 && "file".startsWith(args[0])) {
            d = DataSource.FILE;
        }
        else d= DataSource.FILE;
        new Main(d);
        AddressaryFrame.getInst();
        AddressaryFrame.getInst().refresh();
        }
   
    /**
     * Gets the DAO interface.
     *
     * @return the DAO interface
     */
    public DAOInterface getDAOInterface() {
        return interfaceDAO;
    }

    }
