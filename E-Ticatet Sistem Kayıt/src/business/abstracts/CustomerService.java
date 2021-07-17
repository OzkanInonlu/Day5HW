package business.abstracts;

import entities.concretes.Customer;

public interface CustomerService {
	
	public void signIn(Customer customer);
	public void signUp(Customer customer);

}
