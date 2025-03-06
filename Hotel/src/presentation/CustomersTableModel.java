package presentation;

import java.util.List;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import core.Customer;
import core.PersonId;

public class CustomersTableModel extends AbstractTableModel {

	private List<Customer> customers = new ArrayList<Customer>();

	CustomersTableModel(){ 
    	Customer u1 = new Customer(new PersonId (1), "Ludvik", "Valíček", "Valiclud",
    			"Lenora", "680306/1895") ;
    	Customer u2 = new Customer(new PersonId (2), "Ludvik", "Rýmový", "Rymlud",
    			"Rýmička", "720306/1265") ;
    	Customer u3 = new Customer(new PersonId (3), "Olda", "Zdravý", "Zdravold",
    			"Hypochondrie", "750308/1595") ;
    	Customer u4 = new Customer(new PersonId (4), "Alois", "Kočkorád", "Kockodan",
    			"Slintavka", "850398/1895") ;
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
			return customer.getName();
		case 2:
			return customer.getSurname();
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
	                return "Id";
	            case 1:
	                return "Jméno";
	            case 2:
	                return "Příjmení";
	            case 3:
	                return "Diagnoza";
	            case 4:
	                return "Rodné číslo";
	            case 5:
	                return "Adresa";
	            case 6:
	            	return "Pojišťovna";
	        }
	        return null;
	    }


}
