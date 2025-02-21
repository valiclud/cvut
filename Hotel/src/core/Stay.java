package core;

import java.time.LocalDateTime;
import java.util.List;

public class Stay extends BaseStay {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private StayId stayId;

	private boolean isCarParking;

	private List<Expense> expenses;
	
	private LocalDateTime checkOutDateTime; 

}