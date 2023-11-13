package ma.yc.api;

import ma.yc.api.dev.entity.ResponsableRayon;
import ma.yc.api.dev.repostiory.ResponsableRayonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

@SpringBootApplication
public class ApiPromotionMarjaneApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiPromotionMarjaneApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ResponsableRayonRepository repository){
        // TODO: 13/11/2023 save random data to database !!
        ResponsableRayon responsableRayon = new ResponsableRayon();
        responsableRayon.setEmail("email@gmail.com ");
        responsableRayon.setUsername("username");
        responsableRayon.setPassword("password");
        responsableRayon.setNom("elmahdi");
//        repository.save(responsableRayon);
//        return args -> {
            System.out.println("Hello World");
//        };


        return null;
    }

}
