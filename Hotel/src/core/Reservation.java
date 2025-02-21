package core;

import java.time.LocalDateTime;

public class Reservation extends BaseStay {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ReservationId reservationId;
	
	private boolean isResCanceled;
	
	private LocalDateTime cancelationDateTime;
	
}
