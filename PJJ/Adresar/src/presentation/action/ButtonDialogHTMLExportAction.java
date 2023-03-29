


package presentation.action;

import core.AddressaryException;
import core.Customer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Collection;
import javax.swing.JOptionPane;

import presentation.Main;
import presentation.dialog.DialogHTMLExport;


// TODO: Auto-generated Javadoc
/**
 * The Class ButtonDialogHTMLExportAction.
 *
 * @author Ludvik Valicek
 */
public class ButtonDialogHTMLExportAction implements ActionListener {


    /** The c. */
    DialogHTMLExport c;

    /**
     * Instantiates a new button dialog html export action.
     *
     * @param c the c
     * @throws AddressaryException the addressary exception
     */
    public ButtonDialogHTMLExportAction(DialogHTMLExport c) throws AddressaryException {
        this.c=c;
       }

    /* (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    public void actionPerformed(ActionEvent e)  {

        try {
            String s = c.getFileName();            
            if (s==null)
                 throw new AddressaryException("Please insert one more time file name");
            exportToHTML(s);
            c.dispose();
            }
        catch (AddressaryException ex) {
           JOptionPane.showMessageDialog(c, ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        catch (NumberFormatException enf) {
           JOptionPane.showMessageDialog(c, enf.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        catch (IOException ioe) {
           JOptionPane.showMessageDialog(c, ioe.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }
       }

    /**
     * Export to html.
     *
     * @param file the file
     * @throws AddressaryException the addressary exception
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public void exportToHTML(String file) throws AddressaryException,IOException {
         Collection<Customer> cust;
         cust= Main.getInst().getDAOInterface().listAllCustomers();
         
        File f=new File(file+".html");

         PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(f),"windows-1250"));

        if (f.exists())f.delete();

        pw.println("<html><head><title>Jméno</title></head><body>");
        pw.println("<meta http-equiv="+"Content-Type"+ "content="+"text/html;charset=windows-1250"+ "/>");
       
        pw.println("<table width="+750+" border="+1+" cellspacing="+1+" cellpadding="+4+ "allign="+"left"+ ">");
        pw.println("<tr><td>"+"ID"+"</td><td>"+"Name"+"</td><td>"+"Surname"+"</td><td>"+"Address"+"</td><td>"+"Commentary"+"</td></tr>");
       for (Customer customer : cust) {
            pw.print("<tr><td>"+customer.getCustomerId().toString()+ "</td> ");
            pw.print("<td>"+customer.getName()+ "</td> ");
            pw.print("<td>"+customer.getSurname()+ "</td> ");
            pw.print("<td>"+customer.getAddress()+ "</td> ");
            pw.println("<td>"+customer.getCommentary()+ "</td></tr>");
        }
        pw.println("</table>");
        pw.println("</body></html>");
        pw.close();      
    }    
}
