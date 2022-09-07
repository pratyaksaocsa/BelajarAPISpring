package belajar.spring.api.belajarapi;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PegawaiRepository extends 
    JpaRepository<Pegawai, Long> {
    
    List<Pegawai> findByNama(String nama);
    List<Pegawai> findByNamaContaining(String nama);
    
    List<Pegawai> findByNamaAndJabatan(String nama, String jabatan);
    List<Pegawai> findByNamaOrJabatan(String nama, String jabatan);
}
