package aforo255.com.service;

import java.util.UUID;

import javax.enterprise.context.ApplicationScoped;
@ApplicationScoped
public class AccountService {

	public String sayHello(String message) {
		return String.format("Hello %s  ,your account is %s", message, UUID.randomUUID().toString());

	}
	
	public String sayHello() {
		return "hello test";

	}
}
