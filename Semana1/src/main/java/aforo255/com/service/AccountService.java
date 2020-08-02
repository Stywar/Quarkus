package aforo255.com.service;

import java.util.UUID;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import aforo255.com.config.AccountConfig;
import aforo255.com.config.Base64Value;
import org.jboss.logging.Logger;
@ApplicationScoped
public class AccountService {
  
	 // hacer esto despues de Kotlin
	 @Inject
	 AccountConfig accountConfig;
	 
	 @ConfigProperty(name="account.base64name")
	 Base64Value name;
	 //// despues de ConfigProperties
	 private static Logger LOGGER = Logger.getLogger(AccountService.class.getName());
	 
		
	 
	public String sayHello(String message) {
		return String.format("Hello %s  ,your account is %s", message, UUID.randomUUID().toString());

	}
	
	public String sayHello() {
		LOGGER.debug("Ingresando al servicio sayHello() ");
		//return "hello test";
		//hacer esto despues de Kotlin
		return "Hello " 
		+ accountConfig.getName()
        + accountConfig.getSuffix()
        + " your country is " + accountConfig.getCountry().getName()
        +"Base64 "+ name;

	}
}
