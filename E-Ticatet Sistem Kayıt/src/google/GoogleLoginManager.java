package google;

public class GoogleLoginManager {
	//google'a ait kodlar....
	
	public void signUp(String email, String password) {
		
		System.out.println("Sisteme Google ile kay�t olundu : " + email);
		
		singIn(email,password);
	}
	
	public void singIn(String email, String password) {
		
		System.out.println(email + " Google hesab� ile giri� yap�ld�");
	}
}
