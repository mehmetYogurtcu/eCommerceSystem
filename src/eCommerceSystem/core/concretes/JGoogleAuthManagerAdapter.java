package eCommerceSystem.core.concretes;



import eCommerceSystem.JGoogleAuthManager.JGoogleAuthManager;
import eCommerceSystem.core.abstracts.AuthService;
import eCommerceSystem.entities.concretes.User;

public class JGoogleAuthManagerAdapter implements AuthService{

		JGoogleAuthManager jGoogleAuthManager = new JGoogleAuthManager();
	
	@Override
	public void signInToSystem(User user) {
		jGoogleAuthManager.signIn(user);
		
	}

	@Override
	public void signUpToSystem(User user) {
		jGoogleAuthManager.signUp(user);
		
	}

	

}
