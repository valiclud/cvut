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
 * The Class CreateDeleteDialog.
 *
 * @author Ludvik Valicek
 */
public class CreateDeleteDialog extends AbstractAction {

	/** The inst. */
	private static CreateDeleteDialog inst;

	/**
	 * Gets the inst.
	 *
	 * @return the inst
	 */
	public static CreateDeleteDialog getInst() {
		if (inst == null) {
			inst = new CreateDeleteDialog();
		}
		return inst;
	}

	/**
	 * Instantiates a new creates the delete dialog.
	 */
	private CreateDeleteDialog() {
		super("Delete Customer");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		try {
			new DialogDeleteCustomer();
		} catch (AddressaryException ee) {
			JOptionPane.showMessageDialog(null, ee.toString(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}
