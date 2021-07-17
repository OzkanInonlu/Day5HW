package core;

import entities.concretes.Customer;

public interface LoginService {
	
	public void signUp(Customer customer);
	public void signIn(Customer customer);

}
