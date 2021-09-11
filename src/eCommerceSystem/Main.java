package eCommerceSystem;


import eCommerceSystem.business.abstracts.UserService;
import eCommerceSystem.business.concretes.MailVerificationManager;
import eCommerceSystem.business.concretes.UserCheckManager;
import eCommerceSystem.business.concretes.UserManager;
import eCommerceSystem.core.concretes.JGoogleAuthManagerAdapter;
import eCommerceSystem.dataAccess.concretes.HibernateUserDao;
import eCommerceSystem.entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		
		
		UserService userService = new UserManager(new HibernateUserDao(),new UserCheckManager(),new MailVerificationManager(),new JGoogleAuthManagerAdapter());
		userService.signUp(new User(1, "mehmet", "yoðurtcu", "deneme@gmail.com", "1234656"));
		
			
	}
}
