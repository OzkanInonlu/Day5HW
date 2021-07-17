package business.concretes;

import business.abstracts.VerificationService;
import core.LoginService;
import entities.concretes.Customer;
import java.util.ArrayList;

public class MailVerificationManager implements VerificationService{
	
	ArrayList<String> verificatedEmails=new ArrayList<String>();

	@Override
	public void sendEmail(Customer customer) {
		System.out.println(customer.getEmail() + " hesabýna doðrulama gönderildi");
		verifyEmail(customer);
	}

	@Override
	public void verifyEmail(Customer customer) {
		verificatedEmails.add(customer.getEmail());
	}

	@Override
	public boolean isVerificated(Customer customer) {

		if(verificatedEmails.contains(customer.getEmail())) {
			return true;
		}
		return false;
		
	}
}
