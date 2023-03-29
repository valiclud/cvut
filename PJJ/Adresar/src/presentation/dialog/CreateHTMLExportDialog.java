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
 * The Class CreateHTMLExportDialog.
 *
 * @author Ludvik Valicek
 */
public class CreateHTMLExportDialog extends AbstractAction {

	/** The inst. */
	private static CreateHTMLExportDialog inst;

	/**
	 * Gets the inst.
	 *
	 * @return the inst
	 */
	public static CreateHTMLExportDialog getInst() {
		if (inst == null) {
			inst = new CreateHTMLExportDialog();
		}
		return inst;
	}

	/**
	 * Instantiates a new creates the html export dialog.
	 */
	private CreateHTMLExportDialog() {
		super("HTML Export");

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		try {
			new DialogHTMLExport();
		} catch (AddressaryException ee) {
			JOptionPane.showMessageDialog(null, ee.toString(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}
