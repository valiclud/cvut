

package presentation;

import core.AddressaryException;
import java.awt.event.*;
import javax.swing.JOptionPane;

// TODO: Auto-generated Javadoc
/**
 * The Class WindowClosing.
 *
 * @author Ludvik Valicek
 */
public class WindowClosing extends WindowAdapter{

    /* (non-Javadoc)
     * @see java.awt.event.WindowAdapter#windowClosing(java.awt.event.WindowEvent)
     */
    @Override
    public void windowClosing(WindowEvent e){
       try {
        Main.getInst().getDAOInterface().close();
         }
       catch (AddressaryException ee){
           JOptionPane.showMessageDialog(AddressaryFrame.getInst(), ee.toString(), "Error", JOptionPane.ERROR_MESSAGE);
       }
        System.exit(1);

    }
}
