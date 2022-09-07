package belajar.spring.api.belajarapi;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping("/pegawai")
    public Pegawai newPegawai(@RequestBody Pegawai peg) {
        return pegawaiRepository.save(peg);
    }

    @DeleteMapping("/pegawai/{id}")
    public void deletePegawai(@PathVariable Long id) {
        pegawaiRepository.deleteById(id);
    }

    @PutMapping("/pegawai/{id}")
    public Pegawai replacePegawai(@RequestBody Pegawai newPegawai,
        @PathVariable Long id) {
        
        return pegawaiRepository.findById(id).map(
            pegawai -> {
                pegawai.setNama(newPegawai.getNama());
                pegawai.setJabatan(newPegawai.getJabatan());
                return pegawaiRepository.save(pegawai);
            }
        ).orElseGet(() -> {
            newPegawai.setId(id);
            return pegawaiRepository.save(newPegawai);
        });
    }
}
