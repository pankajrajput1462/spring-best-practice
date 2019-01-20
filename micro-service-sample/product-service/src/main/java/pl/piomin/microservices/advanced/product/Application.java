package pl.piomin.microservices.advanced.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import pl.piomin.microservices.advanced.product.contract.AccountClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(clients = {AccountClient.class})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
