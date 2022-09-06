package belajar.spring.api.belajarapi;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PegawaiRepository extends 
    JpaRepository<Pegawai, Long> {
    
}
