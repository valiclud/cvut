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
 * The Class CreateModifyDialog.
 *
 * @author Ludvik Valicek
 */
public class CreateModifyDialog extends AbstractAction {

    /** The inst. */
    private static CreateModifyDialog inst;
   
   /**
    * Gets the inst.
    *
    * @return the inst
    */
   public static CreateModifyDialog getInst() {
        if (inst == null) {
            inst = new CreateModifyDialog();
        }
        return inst;
    }

    /**
     * Instantiates a new creates the modify dialog.
     */
    private CreateModifyDialog() {
        super("Modify Customer");
    }

    /* (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    public void actionPerformed(ActionEvent e) {
        try { new DialogModifyCustomer();
        }
        catch (AddressaryException ee){
            JOptionPane.showMessageDialog(null, ee.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        }
    }
