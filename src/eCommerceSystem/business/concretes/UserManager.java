package eCommerceSystem.business.concretes;

import eCommerceSystem.business.abstracts.UserCheckService;
import eCommerceSystem.business.abstracts.UserService;
import eCommerceSystem.business.abstracts.VerificationService;
import eCommerceSystem.core.abstracts.AuthService;
import eCommerceSystem.dataAccess.abstracts.UserDao;
import eCommerceSystem.entities.concretes.User;

public class UserManager implements UserService{
	
	
	private UserDao userDao;
	private UserCheckService userCheckService;
	private VerificationService verificationService;
	private AuthService authService;
	
	
	

	public UserManager(UserDao userDao, UserCheckService userCheckService, VerificationService verificationService,
			AuthService authService) {
		super();
		this.userDao = userDao;
		this.userCheckService = userCheckService;
		this.verificationService = verificationService;
		this.authService = authService;
	}

	@Override
	public void signUp(User user) {
		if(userCheckService.isValid(user)==true) {
			
			System.out.println(user.getFirstName() + "adlý kullanýcý sisteme eklendi");
			verificationService.sendMail(user.getEmail());
			userDao.add(user);
			this.authService.signInToSystem(user);
			
		}
		
	}

	@Override
	public void signIn(User user) {
		verificationService.sendMail(user.getEmail());
		if(userDao.getEmail(user.getEmail()) && userDao.getPassword(user.getPassword()) && 
				verificationService.verificated(user.getEmail())==true) {
			System.out.println("Kullanýcý giriþi baþarýlý");
			
		}else if(verificationService.verificated(user.getEmail())==false) {
			System.out.println("Mail adresi kullanýlmýyor.Lütfen mail adresinizi kontrol edin ");
		}else {
			System.out.println("Kullanýcý bilgileri hatalý lütfen kontrol edin");
		}
		
	}
	

}
