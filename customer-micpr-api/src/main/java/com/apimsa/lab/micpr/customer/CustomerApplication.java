package com.apimsa.lab.micpr.customer;

import java.util.List;

import javax.annotation.security.DeclareRoles;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.eclipse.microprofile.auth.LoginConfig;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.servers.Server;


//base web app path for the REST application
//you end up with the path / web app path / rest controller path).

//@ApplicationPath("/customerapi")
@ApplicationPath("/") 

// For Microprofile JWT security
//@LoginConfig(authMethod = "MP-JWT", realmName = "my-domain")
// with realm name error on start :"WFLYCTL0412: Required services that are not installed:" => ["jboss.security.security-domain.my-domain"
@LoginConfig(authMethod = "MP-JWT")


// Available roles
@DeclareRoles({"user", "admin"})

@OpenAPIDefinition(info = @Info(
        title = "Customer API", 
        version = "1.0.0", 
        contact = @Contact(
                name = "Amol", 
                email = "amol.naik@tcs.com",
                url = "http://www.apimsa.com")
        ),
        servers = {
            @Server(url = "/",description = "localhost")
        			}
        )

// Must extend javax.ws.rs.core.Application
public class CustomerApplication extends Application {

	public static void main(String[] args) {
	
	}

		
	}
