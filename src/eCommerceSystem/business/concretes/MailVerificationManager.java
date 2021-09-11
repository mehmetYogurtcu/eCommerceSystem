package eCommerceSystem.business.concretes;

import java.util.ArrayList;
import java.util.List;

import eCommerceSystem.business.abstracts.VerificationService;

public class MailVerificationManager implements VerificationService{
	
	List<String> verificatedEmails = new ArrayList<String>();

	@Override
	public void sendMail(String email) {
		System.out.println(email + "kullanýcýya dogrulama maili gönderildi");
		
	}

	@Override
	public void verifyMail(String email) {
		verificatedEmails.add(email);
		
	}

	@Override
	public boolean verificated(String email) {
		if(verificatedEmails.contains(email)) {
			return true;
		}
		return false;
		
	}

}
