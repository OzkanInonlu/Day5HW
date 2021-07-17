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
			System.out.println("Kullan�c� bilgileri do�ruland�...\nSisteme giri� yap�l�yor ...");
		}
		else if(!verificationService.isVerificated(customer)) {
			System.out.println("Kullan�c� bilgileri do�ru fakat email adresi do�rulanmam��...");
		}
		else {
			System.out.println("Kullan�c� bilgileri yanl��\nL�tfen kontrol ediniz");
		}
	}

	@Override
	public void signUp(Customer customer) {
		
		if(customerCheckService.isValid(customer)) {
			
			verificationService.sendEmail(customer);
			
			System.out.println("Kullan�c� sisteme eklendi : " + customer.getFirstName());
			
			customerDao.add(customer);
			
			signIn(customer);
		}
		
	}
}
