package core;

import entities.concretes.Customer;
import google.GoogleLoginManager;

public class GoogleLoginManagerAdapter implements LoginService{
	
	GoogleLoginManager googleLoginManager=new GoogleLoginManager();

	@Override
	public void signUp(Customer customer) {
		
		googleLoginManager.signUp(customer.getEmail(),customer.getPassword());
	}
	@Override
	public void signIn(Customer customer) {
		// TODO Auto-generated method stub
		
	}
}
