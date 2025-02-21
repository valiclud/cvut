package integration;

import core.Customer;
import core.Employee;
import core.Expense;
import core.ExpenseId;
import core.PersonId;
import core.Reservation;
import core.ReservationId;
import core.Stay;
import core.StayId;

public interface DAOInterface {

	public boolean createCustomer(Customer customer);
	
	public boolean createEmployee(Employee employee);
	
    public boolean createExpense(Expense expense);
	
	public boolean createReservation(Reservation reservation);
	
	public boolean createStay(Stay stay);

	public boolean deleteCustomer(PersonId id);
	
	public boolean deleteEmployee(PersonId id);
	
    public boolean deleteExpense(ExpenseId expenseId);
	
	public boolean deleteReservation(ReservationId reservationId);
	
	public boolean deleteStay(StayId stayId);


}
