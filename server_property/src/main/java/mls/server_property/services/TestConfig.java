package mls.server_property.services;

import mls.server_property.domain.Land;
import mls.server_property.repositories.PropertyRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class TestConfig {

    @Bean
    CommandLineRunner runner(PropertyRepo<Land> repo) {
        return arges -> {
            Land l1 = Land.builder()
                    .address("test land 1 addr")
                    .price(111).build();
            Land l2 = Land.builder()
                    .address("test land 2 addr")
                    .price(222).build();
            Land l3 = Land.builder()
                    .address("test land 3 addr")
                    .price(333).build();
            repo.saveAll(List.of(l1, l2, l3));
        };
    }
}
