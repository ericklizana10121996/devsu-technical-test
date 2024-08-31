package devsu.clients.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "swagger")
@Data
public class SwaggerProperties {

    private Info info;
    private Contact contact;
    private Gateway gateway;
    private License license;

    @Data
    public static class Info {
        private String title;
        private String version;
        private String description;
    }

    @Data
    public static class Contact {
        private String name;
        private String email;
        private String url;
    }

    @Data
    public static class Gateway{
        private String url;
    }

    @Data
    public static class License{
        private String name;
        private String url;
    }
}
