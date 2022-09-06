package belajar.spring.api.belajarapi;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Pegawai {
    private @Id @GeneratedValue Long id;
    private String nama;
    private String jabatan;

    public Pegawai() { }
    public Pegawai(String nama, String jabatan) {
        this.nama = nama;
        this.jabatan = jabatan;
    }

    public Long getId() {
        return this.id;
    }

    public String getNama() {
        return this.nama;
    }

    public String getJabatan() {
        return this.jabatan;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) {
            return true;
        }
        if(!(o instanceof Pegawai)) {
            return false;
        }
        Pegawai pegawai = (Pegawai) o;
        return Objects.equals(this.id, pegawai.id) && 
            Objects.equals(this.nama, pegawai.nama) &&
            Objects.equals(this.jabatan, pegawai.jabatan);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.nama, this.jabatan);
    }

    @Override
    public String toString() {
        return "Pegawai {" + "id=" + this.id + ", nama='" + 
            this.nama + "', jabatan='" + this.jabatan + "'}";
    }
}
