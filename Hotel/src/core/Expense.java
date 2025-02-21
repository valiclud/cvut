package core;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Expense implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ExpenseId expenseId;
	
	private RoomId roomId;
	
	private int amount;
	
	private String currency;
	
	private LocalDateTime expDateTime;
	
	private String item;
	
	private PersonId takenByEmployee;

}
