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
import presentation.action.ButtonDialogSearchByIdAction;

// TODO: Auto-generated Javadoc
/**
 * The Class DialogSearchById.
 *
 * @author Ludvik Valicek
 */
public class DialogSearchById extends AbstractDialog {

	/** The b ok. */
	JButton bOK;

	/**
	 * Instantiates a new dialog search by id.
	 *
	 * @throws AddressaryException
	 *             the addressary exception
	 */
	public DialogSearchById() throws AddressaryException {
		super("Search by ID");

		this.setSize(100, 90);

		inPanel.setLayout(new GridLayout(1, 0));

		inPanel.add(new JLabel("ID to search"));
		inPanel.add(id = new JTextField(20));

		bOK = new JButton("OK");
		bPanel.add(bOK);
		bPanel.add(Box.createVerticalStrut(3));
		bOK.addActionListener(new ButtonDialogSearchByIdAction(this));

		pack();
		setVisible(true);
	}

}
