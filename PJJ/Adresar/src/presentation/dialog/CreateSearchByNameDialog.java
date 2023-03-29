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
 * The Class CreateSearchByNameDialog.
 *
 * @author Ludvik Valicek
 */
public class CreateSearchByNameDialog extends AbstractAction {

	/** The inst. */
	private static CreateSearchByNameDialog inst;

	/**
	 * Gets the inst.
	 *
	 * @return the inst
	 */
	public static CreateSearchByNameDialog getInst() {
		if (inst == null) {
			inst = new CreateSearchByNameDialog();
		}
		return inst;
	}

	/**
	 * Instantiates a new creates the search by name dialog.
	 */
	private CreateSearchByNameDialog() {
		super("Search by Name");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		try {
			new DialogSearchByName();
		} catch (AddressaryException ee) {
			JOptionPane.showMessageDialog(null, ee.toString(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}
