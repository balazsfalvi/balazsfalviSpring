
package aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

	public void AddAccount() {
		System.out.println(getClass() + ": DOING MY DB WORK: ADDIG AN ACCOUNT");

	}

}
