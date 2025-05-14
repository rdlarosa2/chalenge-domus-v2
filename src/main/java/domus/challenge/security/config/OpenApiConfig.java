package domus.challenge.security.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

// import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "Ricardo De la Rosa",
                        email = "rdlarosa2@gmail.com",
                        url = "https://aliboucoding.com/course"
                ),

                description = "OpenApi documentation for Domus Challenge",
                title = "OpenApi specification - Domus Challenge",
                version = "1.0",
                termsOfService = "Terms of service"
        ),
        servers = {
                @Server(
                        description = "Local ENV",
                        url = "http://localhost:8080"
                )
        }
)
public class OpenApiConfig {


}
