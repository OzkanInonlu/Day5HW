package business.concretes;

import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import business.abstracts.CustomerCheckService;
import entities.concretes.Customer;

public class CustomerCheckManager implements CustomerCheckService{
	
	ArrayList<String> listOfEmails=new ArrayList<String>();
	@Override
	public boolean checkFirstName(Customer customer) {
		
		if(customer.getFirstName().isEmpty()) {
			System.out.println("Ýsim alaný boþ býrakýlmamalý");
			return false;
		}
		else {
			if(customer.getFirstName().length()<2) {
				System.out.println("Ýsim en az iki karakterden oluþmalýdýr");
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean checkLastName(Customer customer) {
		if(customer.getLastName().isEmpty()) {
			System.out.println("Soyisim alaný boþ býrakýlmamalý");
			return false;
		}
		else {
			if(customer.getLastName().length()<2) {
				System.out.println("Soyisim en az iki karakterden oluþmalýdýr");
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean checkEmail(Customer customer) {
		
		boolean result=true;
		
		if(customer.getEmail().isEmpty()) {
			System.out.println("Email alaný boþ býrakýlmamalý");
			result=false;
		}
		else {
			//String regex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+.(com|org|net|edu|gov|mil|biz|info|mobi)(.[A-Z]{2})?$";
			String regex="^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";
			Pattern pattern=Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
			Matcher matcher = pattern.matcher(customer.getEmail());
			boolean resultForValidation = matcher.matches();
		
			if(resultForValidation) {
				System.out.println("Email formatý OK");
				result=true;
			}
			else {
				System.out.println("Girilen email formata uygun deðil, tekrar deneyin");
				result=false;
			}
		}
		return result;
	}

	@Override
	public boolean checkPassword(Customer customer) {
		
		boolean result=true;
		if(customer.getLastName().isEmpty()) {
			System.out.println("Parola alaný boþ býrakýlmamalý");
			result=false;
		}
		else {
			if(customer.getLastName().length()<6) {
				System.out.println("Soyisim en az altý karakterden oluþmalýdýr");
				result=false;
			}
		}
		return result;
	}

	@Override
	public boolean uniqueEmail(Customer customer) {
		
		boolean result=true;
		if(listOfEmails.contains(customer.getEmail())) {
			System.out.println("Bu email adresi alýnmýþ, tekrar deneyin");
			result=false;
		}
		else {
			result=true;
			listOfEmails.add(customer.getEmail());	
		}
		return result;
	}

	@Override
	public boolean isValid(Customer customer) {
		
		boolean result=false;
		
		if(checkFirstName(customer) && checkLastName(customer)
				&& checkEmail(customer) && checkPassword(customer) && uniqueEmail(customer)) {
			result=true;
		}
		return result;
	}

}
