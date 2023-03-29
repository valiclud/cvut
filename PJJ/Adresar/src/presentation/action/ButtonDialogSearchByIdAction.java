
package presentation.action;

import core.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import presentation.AddressaryFrame;
import presentation.Main;
import presentation.dialog.DialogSearchById;

// TODO: Auto-generated Javadoc
/**
 * The Class ButtonDialogSearchByIdAction.
 *
 * @author Ludvik Valicek
 */
public class ButtonDialogSearchByIdAction implements ActionListener {

	/** The c. */
	DialogSearchById c;

	/** The i. */
	CustomerId i;

	/** The customer. */
	Customer customer;

	/**
	 * Instantiates a new button dialog search by id action.
	 *
	 * @param c
	 *            the c
	 */
	public ButtonDialogSearchByIdAction(DialogSearchById c) {
		this.c = c;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {

		try {
			int id = c.getCustomerID();
			int last = Main.getInst().getDAOInterface().getLastId();
			if ((id > last) | (id == 0))
				throw new AddressaryException("ID does not exist - please insert one more time with correct ID");
			else if (Main.getInst().getDAOInterface().existsId(id) == false)
				throw new AddressaryException("ID was already erased - please insert one more time with correct ID");
			i = new CustomerId(id);
			customer = Main.getInst().getDAOInterface().findCustomerById(i);
			JOptionPane.showMessageDialog(c, customer, customer.getName() + " " + customer.getSurname(),
					JOptionPane.INFORMATION_MESSAGE);
			// JOptionPane.showMessageDialog(c, String.valueOf(i.getIdNumber()),
			// customer.getName(), JOptionPane.INFORMATION_MESSAGE);
			AddressaryFrame.getInst().refresh();
			c.dispose();
		} catch (AddressaryException ex) {
			JOptionPane.showMessageDialog(c, ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(c, ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

}
