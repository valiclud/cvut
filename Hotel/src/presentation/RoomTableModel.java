package presentation;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import core.Room;
import core.RoomId;

public class RoomTableModel extends AbstractTableModel {

	private List<Room> rooms = new ArrayList<Room>();

	RoomTableModel(){ 
    	Room u1 = new Room(new RoomId (1), (short) 11, (short) 3, false, false);
    	Room u2 = new Room(new RoomId (2), (short) 11, (short) 3,  false, false);
    	Room u3 = new Room(new RoomId (3), (short) 11, (short) 3,  false, false);
    	Room u4 = new Room(new RoomId (4), (short) 11, (short) 3,  false, false);
    	rooms.add(u1);
    	rooms.add(u2);
    	rooms.add(u3);
    	rooms.add(u4);
    }
	
	@Override
	public int getRowCount() {
		return rooms.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 5;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Room room = rooms.get(rowIndex);

		switch (columnIndex) {
		case 0:
			return room.getRoomId();
		case 1:
			return room.getRoomNo();
		case 2:
			return room.getBedsNo();
		case 3:
			return room.isSeaView();
		case 4:
			return room.isExtraBed();
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
	                return "Číslo pokoje";
	            case 2:
	                return "Počet lůžek";
	            case 3:
	                return "Výhled na moře";
	            case 4:
	                return "Přistýlka";
	        }
	        return null;
	    }


}
