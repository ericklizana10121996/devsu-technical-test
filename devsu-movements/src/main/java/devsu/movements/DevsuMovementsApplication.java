package devsu.movements;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DevsuMovementsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DevsuMovementsApplication.class, args);
	}

}
