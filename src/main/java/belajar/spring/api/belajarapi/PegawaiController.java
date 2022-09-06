package belajar.spring.api.belajarapi;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PegawaiController {
    private final PegawaiRepository pegawaiRepository;

    PegawaiController(PegawaiRepository repo) {
        this.pegawaiRepository = repo;
    }

    @GetMapping("/")
    public String homepage() {
        return "Hello Spring Framework API";
    }

    @GetMapping("/pegawai")
    public List<Pegawai> getAllPegawai() {
        return pegawaiRepository.findAll();
    }

    @GetMapping("/pegawai/{id}")
    public Pegawai searchById(@PathVariable Long id) {
        return pegawaiRepository.findById(id).orElseThrow(
            () -> new PegawaiNotFoundException(id)
        );
    }
}
