package aforo255.com.service

import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
 class TestService {
	fun test(name: String ) = "Hello $name"
}