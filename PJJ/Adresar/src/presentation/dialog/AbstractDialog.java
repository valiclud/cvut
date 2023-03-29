/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package presentation.dialog;

import core.AddressaryException;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import presentation.AddressaryFrame;

// TODO: Auto-generated Javadoc
/**
 * The Class AbstractDialog.
 *
 * @author Ludvik Valicek
 */
public class AbstractDialog extends JDialog {

	/** The b cancel. */
	JButton bCancel;

	/** The in panel. */
	JPanel inPanel;

	/** The b panel. */
	Box bPanel;

	/** The id. */
	JTextField id;

	/** The surname. */
	JTextField surname;

	/** The name. */
	JTextField name;

	/** The address. */
	JTextField address;

	/** The comments. */
	JTextField comments;

	/** The filename. */
	JTextField filename;

	/**
	 * Instantiates a new abstract dialog.
	 *
	 * @param t
	 *            the t
	 * @throws AddressaryException
	 *             the addressary exception
	 */
	public AbstractDialog(String t) throws AddressaryException {

		super(AddressaryFrame.getInst(), t, true);
		setLayout(new GridLayout(2, 0, 5, 5));

		add(inPanel = new JPanel(), BorderLayout.CENTER);
		add(bPanel = new Box(2), BorderLayout.SOUTH);
		bPanel.add(Box.createHorizontalStrut(2));
		bPanel.add(Box.createVerticalStrut(3));

		// Sets the operation that will happen by default when
		// the user initiates a "close" on this dialog.
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		bCancel = new JButton("Cancel");
		bCancel.addActionListener(new ActionButtonCancel());
		bPanel.add(bCancel);
		bPanel.add(Box.createVerticalStrut(3));

	}

	/**
	 * Gets the customer id.
	 *
	 * @return the customer id
	 * @throws NumberFormatException
	 *             the number format exception
	 * @throws AddressaryException
	 *             the addressary exception
	 */
	public int getCustomerID() throws NumberFormatException, AddressaryException {
		String s = id.getText();
		if (s.length() == 0)
			throw new AddressaryException("Wrong number please insert one more time");
		int i = Integer.valueOf(s);
		return i;
	}

	/**
	 * Gets the customer name.
	 *
	 * @return the customer name
	 * @throws AddressaryException
	 *             the addressary exception
	 */
	public String getCustomerName() throws AddressaryException {
		if (name.getText().length() == 0) {
			throw new AddressaryException("Empty Name-please insert name");
		}
		return name.getText();
	}

	/**
	 * Gets the customer surname.
	 *
	 * @return the customer surname
	 * @throws AddressaryException
	 *             the addressary exception
	 */
	public String getCustomerSurname() throws AddressaryException {
		if (surname.getText().length() == 0) {
			throw new AddressaryException("Empty Surname-please insert surname");
		}
		return surname.getText();
	}

	/**
	 * Gets the customer address.
	 *
	 * @return the customer address
	 * @throws AddressaryException
	 *             the addressary exception
	 */
	public String getCustomerAddress() throws AddressaryException {
		if (address.getText().length() == 0) {
			throw new AddressaryException("Empty Address-please insert address");
		}
		return address.getText();
	}

	/**
	 * Gets the customer comments.
	 *
	 * @return the customer comments
	 * @throws AddressaryException
	 *             the addressary exception
	 */
	public String getCustomerComments() throws AddressaryException {
		return comments.getText();
	}

	/**
	 * Gets the file name.
	 *
	 * @return the file name
	 * @throws AddressaryException
	 *             the addressary exception
	 */
	public String getFileName() throws AddressaryException {
		if (filename.getText().length() == 0) {
			throw new AddressaryException("Empty file name-please insert file name");
		}
		return filename.getText();
	}

	/**
	 * The Class ActionButtonCancel.
	 */
	class ActionButtonCancel implements ActionListener {

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.
		 * ActionEvent)
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			dispose();
		}
	}
}
