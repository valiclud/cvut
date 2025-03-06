package core;

import java.io.Serializable;

public class Room implements Serializable {

	private RoomId roomId;
	
	private short roomNo;
	
	private short bedsNo;
	
	private boolean isSeaView;
	
	private boolean isExtraBed;

	public Room(RoomId roomId, short i, short j, boolean isSeaView, boolean isExtraBed) {
		super();
		this.roomId = roomId;
		this.roomNo = i;
		this.bedsNo = j;
		this.isSeaView = isSeaView;
		this.isExtraBed = isExtraBed;
	}

	public RoomId getRoomId() {
		return roomId;
	}

	public void setRoomId(RoomId roomId) {
		this.roomId = roomId;
	}

	public short getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(short roomNo) {
		this.roomNo = roomNo;
	}

	public short getBedsNo() {
		return bedsNo;
	}

	public void setBedsNo(short bedsNo) {
		this.bedsNo = bedsNo;
	}

	public boolean isSeaView() {
		return isSeaView;
	}

	public void setSeaView(boolean isSeaView) {
		this.isSeaView = isSeaView;
	}

	public boolean isExtraBed() {
		return isExtraBed;
	}

	public void setExtraBed(boolean isExtraBed) {
		this.isExtraBed = isExtraBed;
	}
	
	
	
}
