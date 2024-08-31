package devsu.clients.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;

@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi apiV1() {
        return GroupedOpenApi.builder()
                .group("version-1")
                .pathsToMatch("/api/v1/**")
                .build();
    }

    @Bean
    public OpenAPI customOpenAPI(SwaggerProperties swaggerProperties) {
        Contact contact = new Contact();
        contact.setEmail(swaggerProperties.getContact().getEmail());
        contact.setName(swaggerProperties.getContact().getName());
        contact.setUrl(swaggerProperties.getContact().getUrl());

        License license = new License();
        license.name(swaggerProperties.getLicense().getName());
        license.url(swaggerProperties.getLicense().getUrl());

        Info info = new Info();
        info.setTitle(swaggerProperties.getInfo().getTitle());
        info.setDescription(swaggerProperties.getInfo().getDescription());
        info.setVersion(swaggerProperties.getInfo().getVersion());
        info.setContact(contact);
        info.setLicense(license);

        return new OpenAPI()
                .servers(Collections.singletonList(new Server().url(swaggerProperties.getGateway().getUrl())))
                .info(info);
    }
}
