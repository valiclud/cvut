/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package presentation.dialog;

import core.AddressaryException;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

// TODO: Auto-generated Javadoc
/**
 * The Class CreateXMLExportDialog.
 *
 * @author Ludvik Valicek
 */
public class CreateXMLExportDialog extends AbstractAction  {

    /** The inst. */
	private static CreateXMLExportDialog inst;

   /**
    * Gets the inst.
    *
    * @return the inst
    */
   public static CreateXMLExportDialog getInst() {
        if (inst == null) {
            inst = new CreateXMLExportDialog();
        }
        return inst;
    }

    /**
     * Instantiates a new creates the xml export dialog.
     */
    private CreateXMLExportDialog() {

    }

     /* (non-Javadoc)
      * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
      */
     public void actionPerformed(ActionEvent e) {
        try { new DialogXMLExport();
        }
        catch (AddressaryException ee){
            JOptionPane.showMessageDialog(null, ee.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        }
   }
