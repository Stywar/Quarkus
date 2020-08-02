package aforo255.com;
import javax.enterprise.context.ApplicationScoped;

import aforo255.com.service.AccountService;
import io.quarkus.test.Mock;

@Mock
@ApplicationScoped
public class MockAccountService extends AccountService {

	@Override
	public String sayHello(String message) {
		// TODO Auto-generated method stub
		return String.format("Hello %s, your account is %s", message, "123");
	}

	
}
