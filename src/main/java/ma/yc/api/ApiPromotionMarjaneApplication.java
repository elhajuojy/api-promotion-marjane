package ma.yc.api;

//import ma.yc.api.entity.ResponsableRayon;
//import ma.yc.api.repository.ResponsableRayonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApiPromotionMarjaneApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiPromotionMarjaneApplication.class, args);
    }


    @Bean
    CommandLineRunner commandLineRunner(){
        return args -> {
//            MainEntity main = new MainEntity();
        };
    }
//    @Bean
//    CommandLineRunner commandLineRunner(ResponsableRayonRepository repository){
        // TODO: 13/11/2023 save random data to database !!
//        ResponsableRayon responsableRayon = new ResponsableRayon();
//        responsableRayon.setEmail("email@gmail.com ");
//        responsableRayon.setUsername("username");
//        responsableRayon.setPassword("password");
//        responsableRayon.setNom("elmahdi");
//        repository.save(responsableRayon);
//        return args -> {
//            System.out.println("Hello World");
//        };


//        return null;
//    }

}
