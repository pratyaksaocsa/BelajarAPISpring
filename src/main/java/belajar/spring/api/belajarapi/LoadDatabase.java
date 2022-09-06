package belajar.spring.api.belajarapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {
    private static final Logger log = 
        LoggerFactory.getLogger(LoadDatabase.class);
    
    @Bean
    CommandLineRunner initDatabase(PegawaiRepository repository) {
        return args -> {
            repository.save(
                new Pegawai("Budi", "Programmer Senior"));
            log.info("Preload data Budi berhasil");
            repository.save(
                new Pegawai("Cika","HRD"));
            log.info("Preload data Cika berhasil");
        };
    }
}
