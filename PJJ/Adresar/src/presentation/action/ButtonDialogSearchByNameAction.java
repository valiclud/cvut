
package presentation.action;

import core.AddressaryException;
import core.Customer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import javax.swing.JOptionPane;

import presentation.Main;
import presentation.dialog.DialogSearchByName;
import presentation.table.SearchByNameFrame;

// TODO: Auto-generated Javadoc
/**
 * The Class ButtonDialogSearchByNameAction.
 *
 * @author Valicek
 */
public class ButtonDialogSearchByNameAction implements ActionListener {

	/** The cust. */
	Collection<Customer> cust;

	/** The customer. */
	Customer customer;

	/** The c. */
	DialogSearchByName c;

	/** The sbnf. */
	SearchByNameFrame sbnf;

	/**
	 * Instantiates a new button dialog search by name action.
	 *
	 * @param c
	 *            the c
	 * @throws AddressaryException
	 *             the addressary exception
	 */
	public ButtonDialogSearchByNameAction(DialogSearchByName c) throws AddressaryException {
		this.c = c;
		System.out.println("Konstruktor Dialog search by name vyska" + c.getHeight() + " " + c.getWidth());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {

		try {
			String customerSurname = c.getCustomerSurname();
			if (customerSurname == null)
				throw new AddressaryException("Please insert one more time name");
			cust = Main.getInst().getDAOInterface().findCustomerBySurname(customerSurname);
			if (cust == null) {
				throw new AddressaryException("Name does not exist please insert one more timeeee");
			}

			sbnf = new SearchByNameFrame();
			sbnf.refresh(customerSurname);
			sbnf = null;
			c.dispose();
		} catch (AddressaryException ex) {
			JOptionPane.showMessageDialog(c, ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

}
