package business.abstracts;

import entities.concretes.Customer;

public interface VerificationService {
	
	public void sendEmail(Customer customer);
	public void verifyEmail(Customer customer);
	public boolean isVerificated(Customer customer);

}
