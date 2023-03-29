/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package presentation.dialog;

import java.awt.event.*;
import core.AddressaryException;
import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

// TODO: Auto-generated Javadoc
/**
 * The Class CreateInsertDialog.
 *
 * @author Ludvik Valicek
 */
public class CreateInsertDialog extends AbstractAction {

	/** The inst. */
	private static CreateInsertDialog inst;

	/**
	 * Gets the inst.
	 *
	 * @return the inst
	 */
	public static CreateInsertDialog getInst() {
		if (inst == null) {
			inst = new CreateInsertDialog();
		}
		return inst;
	}

	/**
	 * Instantiates a new creates the insert dialog.
	 */
	private CreateInsertDialog() {
		super("Insert Customer");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		try {
			new DialogInsertCustomer();
		} catch (AddressaryException ee) {
			JOptionPane.showMessageDialog(null, ee.toString(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}
