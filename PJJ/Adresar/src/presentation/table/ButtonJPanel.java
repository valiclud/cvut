/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package presentation.table;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import presentation.dialog.CreateDeleteDialog;
import presentation.dialog.CreateHTMLExportDialog;
import presentation.dialog.CreateInsertDialog;
import presentation.dialog.CreateModifyDialog;
import presentation.dialog.CreateSearchByIdDialog;
import presentation.dialog.CreateSearchByNameDialog;
import presentation.dialog.CreateXMLExportDialog;

// TODO: Auto-generated Javadoc
/**
 * The Class ButtonJPanel.
 *
 * @author Ludvik Valicek
 */
public class ButtonJPanel extends JPanel {

	/**
	 * Instantiates a new button j panel.
	 */
	public ButtonJPanel() {

		this.setLayout(new FlowLayout());
		JButton insertCustomer = new JButton("Insert Customer");
		this.add(insertCustomer);
		JButton modifyCustomer = new JButton("Modify Customer");
		this.add(modifyCustomer);
		JButton deleteCustomer = new JButton("Delete Customer");
		this.add(deleteCustomer);
		JButton searchByName = new JButton("Search by name");
		this.add(searchByName);
		JButton searchById = new JButton("Search by ID");
		this.add(searchById);
		JButton exportToHTML = new JButton("Export to HTML");
		this.add(exportToHTML);
		JButton exportToXML = new JButton("Export to XML");
		this.add(exportToXML);

		insertCustomer.addActionListener(CreateInsertDialog.getInst());
		modifyCustomer.addActionListener(CreateModifyDialog.getInst());
		deleteCustomer.addActionListener(CreateDeleteDialog.getInst());
		searchByName.addActionListener(CreateSearchByNameDialog.getInst());
		searchById.addActionListener(CreateSearchByIdDialog.getInst());
		exportToHTML.addActionListener(CreateHTMLExportDialog.getInst());
		exportToXML.addActionListener(CreateXMLExportDialog.getInst());

	}

}
