package presentation;

import java.util.List;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import core.Customer;
import core.PersonId;

public class CustomersTableModel extends AbstractTableModel {
	
	private static final String GUESTS = "Hosté ";
	private static final String CUSTOMER_ID = "Id hosta";
	private static final String PASSPORT_ID = "Číslo OP/pasu";
	private static final String FIRST_NAME = "Jméno";
	private static final String LAST_NAME = "Příjmení";
	private static final String ADDRESS = "Adresa";
	private static final String COMMENTARY = "Komentář";
	private static final String ROOMS = "Pokoje";

	private List<Customer> customers = new ArrayList<Customer>();

	CustomersTableModel(){ 
    	Customer u1 = new Customer(new PersonId (1), "Ludvik", "Valíček", "Valiclud",
    			"Lenora", "680306/1895", null) ;
    	Customer u2 = new Customer(new PersonId (2), "Ludvik", "Rýmový", "Rymlud",
    			"Rýmička", "720306/1265", null) ;
    	Customer u3 = new Customer(new PersonId (3), "Olda", "Zdravý", "Zdravold",
    			"Hypochondrie", "750308/1595", null) ;
    	Customer u4 = new Customer(new PersonId (4), "Alois", "Kočkorád", "Kockodan",
    			"Slintavka", "850398/1895", null) ;
    	customers.add(u1);
    	customers.add(u2);
    	customers.add(u3);
    	customers.add(u4);
    }
	
	@Override
	public int getRowCount() {
		return customers.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 7;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Customer customer = customers.get(rowIndex);

		switch (columnIndex) {
		case 0:
			return customer.getPersonId();
		case 1:
			return customer.getSurname();
		case 2:
			return customer.getName();
		case 3:
			return customer.getPassportNo();
		case 4:
			return customer.getAddress();
		case 5:
			return customer.getCommentary();
		default:
			// LOG.error();
			return null;
		}
	}
	
	 @Override
	    public String getColumnName(int column) {
	        switch (column) {
	            case 0:
	                return CUSTOMER_ID;
	            case 1:
	            	return FIRST_NAME;
	            case 2:
	            	return LAST_NAME;	                
	            case 3:
	                return PASSPORT_ID;
	            case 4:
	                return ADDRESS;
	            case 5:
	                return COMMENTARY;
	            case 6:
	            	return ROOMS;
	        }
	        return null;
	    }


}
