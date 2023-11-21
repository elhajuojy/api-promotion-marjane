package ma.yc.api.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.servers.Server;

import java.util.Arrays;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI(@Value("${contact-email}") String email, @Value("${local-server.url}") String localServerUrl, @Value("${prod-server.url}") String prodServerUrl, @Value("${project.version}") String appVersion, @Value("${project.title}") String title, @Value("${project.description}") String description) {
        return new OpenAPI().info(new Info()
                .title(title)
                .version(appVersion)
                .description(description)
                .contact(new Contact()
                        .name("Squad DIGITAL YOUCODE API")
                        .email(email))
        ).servers(Arrays.asList(new Server().description("Serveur de dev").url(localServerUrl),
                new Server().description("Serveur de recette").url(prodServerUrl)));

    }
}
