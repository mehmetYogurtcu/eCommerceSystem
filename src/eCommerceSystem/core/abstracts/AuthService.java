package eCommerceSystem.core.abstracts;

import eCommerceSystem.entities.concretes.User;

public interface AuthService {
	
	void signInToSystem(User user);
	void signUpToSystem(User user);


}
