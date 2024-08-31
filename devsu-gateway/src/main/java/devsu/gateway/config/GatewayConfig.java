package devsu.gateway.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class GatewayConfig {
/*
    @Value("${spring.cloud.gateway.routes[1].id}")
    private String serviceClientsId;
    @Value("${spring.cloud.gateway.routes[1].uri}")
    private String serviceClientsURI;

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {

        return builder.routes()
                .route(serviceClientsId, r -> r.path("/api/v1/clientes/**")
                        .uri(serviceClientsURI))
                .build();

    }

    */
}
