package devsu.gateway;

import devsu.gateway.config.AppProperties;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DevsuGatewayApplication {

    private final AppProperties appProperties;

    public DevsuGatewayApplication(final AppProperties appProperties) {
        this.appProperties = appProperties;
    }

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title(appProperties.getTitle())
                        .version(appProperties.getVersion())
                        .description(appProperties.getDescription()));
    }

    public static void main(String[] args) {
        SpringApplication.run(DevsuGatewayApplication.class, args);
    }

}
