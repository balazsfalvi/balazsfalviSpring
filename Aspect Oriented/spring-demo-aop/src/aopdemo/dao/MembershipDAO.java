package aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
	public void AddAccount() {
		System.out.println(getClass()+": DOUNG STUFF ADD A MEMBERSHIP ACC.");
	}
}
