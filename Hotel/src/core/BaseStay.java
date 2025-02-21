package core;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public abstract class BaseStay implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private PersonId customerId;
	
	private List<RoomId> roomIds;
	
	private LocalDate dateFrom;
	
	private LocalDate dateTo;
	
	private int amount;
	
	private String currency;
	
	private String kindOfPayment;
	
	private LocalDateTime paymentDateTime;
	
	private boolean fullPension;
	
	private boolean halfPension;
	
	private PersonId takenByEmployee;
	
}
