/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package presentation.dialog;

import core.AddressaryException;
import java.awt.GridLayout;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import presentation.action.ButtonDialogSearchByNameAction;

// TODO: Auto-generated Javadoc
/**
 * The Class DialogSearchByName.
 *
 * @author Ludvik Valicek
 */
public class DialogSearchByName extends AbstractDialog {

	/** The b ok. */
	JButton bOK;

	/**
	 * Instantiates a new dialog search by name.
	 *
	 * @throws AddressaryException
	 *             the addressary exception
	 */
	public DialogSearchByName() throws AddressaryException {
		super("Search By Name");

		this.setSize(100, 90);

		inPanel.setLayout(new GridLayout(1, 0));

		inPanel.add(new JLabel("Surname to search"));
		inPanel.add(surname = new JTextField(20));

		bOK = new JButton("OK");
		bPanel.add(bOK);
		bPanel.add(Box.createVerticalStrut(3));
		bOK.addActionListener(new ButtonDialogSearchByNameAction(this));

		pack();
		setVisible(true);
	}
}
