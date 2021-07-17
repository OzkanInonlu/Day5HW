package yandex;

public class YandexLoginManager{
	
	public void signUp(String email, String password) {
		
		System.out.println("Sisteme Yandex ile kayýt olundu : " + email);
		
		singIn(email,password);
	}
	
	public void singIn(String email, String password) {
		
		System.out.println(email + " Yandex hesabý ile giriþ yapýldý");
	}
}
