package presentation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import core.Customer;
import core.PersonId;
import core.Room;
import core.RoomId;

public class CustomerToRoomsTableModel extends AbstractTableModel {

	private List<Customer> customers = new ArrayList<Customer>();

	CustomerToRoomsTableModel(){ 
    	Room r1 = new Room(new RoomId (1), (short) 11, (short) 3, false, false);
        List<Room> l1 = Arrays.asList(r1); 
    	Room r2 = new Room(new RoomId (2), (short) 11, (short) 3,  false, false);
    	List<Room> l2 = Arrays.asList(r2);
    	Room r3 = new Room(new RoomId (3), (short) 11, (short) 3,  false, false);
    	List<Room> l3 = Arrays.asList(r3);
    	Room r4 = new Room(new RoomId (4), (short) 11, (short) 3,  false, false);
    	List<Room> l4 = Arrays.asList(r4);
    	Customer u1 = new Customer(new PersonId (1), "Ludvik", "Valíček", "Valiclud",
    			"Lenora", "680306/1895", l1) ;
    	Customer u2 = new Customer(new PersonId (2), "Ludvik", "Rýmový", "Rymlud",
    			"Rýmička", "720306/1265", l2) ;
    	Customer u3 = new Customer(new PersonId (3), "Olda", "Zdravý", "Zdravold",
    			"Hypochondrie", "750308/1595", l3) ;
    	Customer u4 = new Customer(new PersonId (4), "Alois", "Kočkorád", "Kockodan",
    			"Slintavka", "850398/1895", l4) ;
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
		return 6;
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
	                return "Číslo pasu";
	            case 4:
	                return "Adresa";
	            case 5:
	            	return "Komentář";
	        }
	        return null;
	    }


}
