package belajar.spring.api.belajarapi;

public class PegawaiNotFoundException extends RuntimeException {
    
    public PegawaiNotFoundException(Long id) {
        super("Tidak bisa menemukan pegawai id="+id);
    }
}
