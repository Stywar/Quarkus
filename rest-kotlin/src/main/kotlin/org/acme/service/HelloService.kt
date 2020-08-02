package org.acme.service

import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class HelloService {
	fun test(name: String ) = "Hello $name"
}