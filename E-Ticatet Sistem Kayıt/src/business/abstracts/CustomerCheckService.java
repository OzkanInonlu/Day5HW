package business.abstracts;

import entities.concretes.Customer;

public interface CustomerCheckService {
	
	public boolean checkFirstName(Customer customer);
	public boolean checkLastName(Customer customer);
	public boolean checkEmail(Customer customer);
	public boolean checkPassword(Customer customer);
	public boolean uniqueEmail(Customer customer);   	
	public boolean isValid(Customer customer);
	

}
