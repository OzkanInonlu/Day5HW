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
			System.out.println("�sim alan� bo� b�rak�lmamal�");
			return false;
		}
		else {
			if(customer.getFirstName().length()<2) {
				System.out.println("�sim en az iki karakterden olu�mal�d�r");
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean checkLastName(Customer customer) {
		if(customer.getLastName().isEmpty()) {
			System.out.println("Soyisim alan� bo� b�rak�lmamal�");
			return false;
		}
		else {
			if(customer.getLastName().length()<2) {
				System.out.println("Soyisim en az iki karakterden olu�mal�d�r");
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean checkEmail(Customer customer) {
		
		boolean result=true;
		
		if(customer.getEmail().isEmpty()) {
			System.out.println("Email alan� bo� b�rak�lmamal�");
			result=false;
		}
		else {
			//String regex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+.(com|org|net|edu|gov|mil|biz|info|mobi)(.[A-Z]{2})?$";
			String regex="^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";
			Pattern pattern=Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
			Matcher matcher = pattern.matcher(customer.getEmail());
			boolean resultForValidation = matcher.matches();
		
			if(resultForValidation) {
				System.out.println("Email format� OK");
				result=true;
			}
			else {
				System.out.println("Girilen email formata uygun de�il, tekrar deneyin");
				result=false;
			}
		}
		return result;
	}

	@Override
	public boolean checkPassword(Customer customer) {
		
		boolean result=true;
		if(customer.getLastName().isEmpty()) {
			System.out.println("Parola alan� bo� b�rak�lmamal�");
			result=false;
		}
		else {
			if(customer.getLastName().length()<6) {
				System.out.println("Soyisim en az alt� karakterden olu�mal�d�r");
				result=false;
			}
		}
		return result;
	}

	@Override
	public boolean uniqueEmail(Customer customer) {
		
		boolean result=true;
		if(listOfEmails.contains(customer.getEmail())) {
			System.out.println("Bu email adresi al�nm��, tekrar deneyin");
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
