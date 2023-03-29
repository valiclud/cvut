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
 * The Class CreateSearchByIdDialog.
 *
 * @author Ludvik Valicek
 */
public class CreateSearchByIdDialog extends AbstractAction {

	/** The inst. */
	private static CreateSearchByIdDialog inst;

	/**
	 * Gets the inst.
	 *
	 * @return the inst
	 */
	public static CreateSearchByIdDialog getInst() {
		if (inst == null) {
			inst = new CreateSearchByIdDialog();
		}
		return inst;
	}

	/**
	 * Instantiates a new creates the search by id dialog.
	 */
	private CreateSearchByIdDialog() {
		super("Search by ID");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		try {
			new DialogSearchById();
		} catch (AddressaryException ee) {
			JOptionPane.showMessageDialog(null, ee.toString(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}
