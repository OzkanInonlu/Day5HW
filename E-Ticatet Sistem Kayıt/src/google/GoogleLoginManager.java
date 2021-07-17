package google;

public class GoogleLoginManager {
	//google'a ait kodlar....
	
	public void signUp(String email, String password) {
		
		System.out.println("Sisteme Google ile kayýt olundu : " + email);
		
		singIn(email,password);
	}
	
	public void singIn(String email, String password) {
		
		System.out.println(email + " Google hesabý ile giriþ yapýldý");
	}
}
