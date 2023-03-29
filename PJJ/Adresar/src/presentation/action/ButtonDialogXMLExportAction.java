
package presentation.action;

import core.AddressaryException;
import core.Customer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collection;
import javax.swing.JOptionPane;
import javax.xml.parsers.FactoryConfigurationError;
import javax.xml.stream.*;

import presentation.Main;
import presentation.dialog.DialogXMLExport;

// TODO: Auto-generated Javadoc
/**
 * The Class ButtonDialogXMLExportAction.
 *
 * @author Ludvik Valicek
 */
public class ButtonDialogXMLExportAction implements ActionListener {

	/** The c. */
	DialogXMLExport c;

	/**
	 * Instantiates a new button dialog xml export action.
	 *
	 * @param c
	 *            the c
	 * @throws AddressaryException
	 *             the addressary exception
	 */
	public ButtonDialogXMLExportAction(DialogXMLExport c) throws AddressaryException {
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
			String s = c.getFileName();
			if (s == null)
				throw new AddressaryException("Please insert one more time file name");
			exportToXML(s);
			c.dispose();
		} catch (AddressaryException ex) {
			JOptionPane.showMessageDialog(c, ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
		} catch (NumberFormatException enf) {
			JOptionPane.showMessageDialog(c, enf.toString(), "Error", JOptionPane.ERROR_MESSAGE);
		} catch (IOException ioe) {
			JOptionPane.showMessageDialog(c, ioe.toString(), "Error", JOptionPane.ERROR_MESSAGE);
		} catch (FactoryConfigurationError fce) {
			JOptionPane.showMessageDialog(c, fce.toString(), "Error", JOptionPane.ERROR_MESSAGE);
		} catch (XMLStreamException se) {
			JOptionPane.showMessageDialog(c, se.toString(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Export to xml.
	 *
	 * @param file
	 *            the file
	 * @throws AddressaryException
	 *             the addressary exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws FactoryConfigurationError
	 *             the factory configuration error
	 * @throws XMLStreamException
	 *             the XML stream exception
	 */
	public void exportToXML(String file)
			throws AddressaryException, IOException, FactoryConfigurationError, XMLStreamException {
		Collection<Customer> cust;
		cust = Main.getInst().getDAOInterface().listAllCustomers();

		File f = new File(file + ".xml");

		if (f.exists())
			f.delete();

		XMLOutputFactory of = XMLOutputFactory.newInstance();
		XMLStreamWriter sw = of.createXMLStreamWriter(new FileOutputStream(f), "UTF-8");

		sw.writeStartDocument("UTF-8", "1.0");
		sw.writeCharacters("\r\n");
		sw.writeComment("Addressary of customers");
		sw.writeCharacters("\r\n");
		sw.writeStartElement("Addressary");

		for (Customer customer : cust) {
			sw.writeCharacters("\r\n");
			sw.writeStartElement("Customer");
			sw.writeAttribute("ID", customer.getCustomerId().toString());
			sw.writeCharacters("\r\n");
			sw.writeStartElement("Name");
			sw.writeCharacters(customer.getName());
			sw.writeEndElement();
			sw.writeCharacters("\r\n");
			sw.writeStartElement("Surname");
			sw.writeCharacters(customer.getSurname());
			sw.writeEndElement();
			sw.writeCharacters("\r\n");
			sw.writeStartElement("Address");
			sw.writeCharacters(customer.getAddress());
			sw.writeEndElement();
			sw.writeCharacters("\r\n");
			sw.writeStartElement("Commentary");
			sw.writeCharacters(customer.getCommentary());
			sw.writeEndElement();
			sw.writeCharacters("\r\n");
			sw.writeEndElement();
		}

		sw.writeCharacters("\r\n");
		sw.writeEndElement();
		sw.writeCharacters("\r\n");
		sw.writeEndDocument();

		sw.close();
	}
}
