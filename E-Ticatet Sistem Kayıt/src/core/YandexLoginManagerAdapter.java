package core;

import entities.concretes.Customer;
import yandex.YandexLoginManager;

public class YandexLoginManagerAdapter implements LoginService{

	YandexLoginManager yandexLoginManager=new YandexLoginManager();
	@Override
	public void signUp(Customer customer) {
		
		yandexLoginManager.signUp(customer.getEmail(), customer.getPassword());
		
	}

	@Override
	public void signIn(Customer customer) {
		// TODO Auto-generated method stub
		
	}

}
