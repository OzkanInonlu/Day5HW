package business.concretes;

import business.abstracts.CustomerCheckService;
import business.abstracts.CustomerService;
import business.abstracts.VerificationService;
import core.LoginService;
import dataAccess.abstracts.CustomerDao;
import entities.concretes.Customer;

public class CustomerManager implements CustomerService{
	
	private CustomerCheckService customerCheckService;
	private VerificationService verificationService;
	private CustomerDao customerDao;

	public CustomerManager(CustomerCheckService customerCheckService, VerificationService verificationService,
			CustomerDao customerDao) {
		this.customerCheckService = customerCheckService;
		this.verificationService = verificationService;
		this.customerDao = customerDao;
	}

	@Override
	public void signIn(Customer customer) {
		
		if(verificationService.isVerificated(customer)) {
			System.out.println("Kullanýcý bilgileri doðrulandý...\nSisteme giriþ yapýlýyor ...");
		}
		else if(!verificationService.isVerificated(customer)) {
			System.out.println("Kullanýcý bilgileri doðru fakat email adresi doðrulanmamýþ...");
		}
		else {
			System.out.println("Kullanýcý bilgileri yanlýþ\nLütfen kontrol ediniz");
		}
	}

	@Override
	public void signUp(Customer customer) {
		
		if(customerCheckService.isValid(customer)) {
			
			verificationService.sendEmail(customer);
			
			System.out.println("Kullanýcý sisteme eklendi : " + customer.getFirstName());
			
			customerDao.add(customer);
			
			signIn(customer);
		}
		
	}
}
