import business.concretes.CustomerCheckManager;
import business.concretes.CustomerManager;
import business.concretes.MailVerificationManager;
import core.GoogleLoginManagerAdapter;
import core.LoginService;
import dataAccess.concretes.HibernateCustomerDao;
import entities.concretes.Customer;

public class Main {

	public static void main(String[] args) {
		
		Customer customer1=new Customer(1,"Özkanxx","Ýnönlüxx","ozkaanmax@gmail.com","123456xx");
		Customer customer2=new Customer(2,"Özbexxx","Denizxxx","ozbe01@.com","1234xxxx");
		
		CustomerManager customerManager=new CustomerManager(
				new CustomerCheckManager(), 
				new MailVerificationManager(),
				new HibernateCustomerDao());
				
		customerManager.signUp(customer1);

		
		//using Google or Yandex
		LoginService loginService=new GoogleLoginManagerAdapter();
		//LoginService loginService=new YandexLoginManagerAdapter();
		loginService.signUp(customer2);
		

	}

}
