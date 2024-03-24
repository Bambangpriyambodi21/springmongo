package com.example.demo.controller;

import com.example.demo.model.Pelanggan;
import com.example.demo.repository.PelangganRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class PelangganController {

    private final PelangganRepository pelangganRepository;

    @PostMapping("/pelanggan")
    public ResponseEntity<?> create(@RequestBody Pelanggan pelanggan){

        UUID uuid = UUID.randomUUID();

        Pelanggan build = Pelanggan.builder()
                .id_pelanggan(String.valueOf(uuid))
                .alamat_pelanggan(pelanggan.getAlamat_pelanggan())
                .email_pelanggan(pelanggan.getEmail_pelanggan())
                .nama_pelanggan(pelanggan.getNama_pelanggan())
                .password_pelanggan(pelanggan.getPassword_pelanggan())
                .build();

        Pelanggan save = pelangganRepository.save(build);

        return ResponseEntity.status(HttpStatus.OK).body(save);
    }

    @GetMapping("/pelanggan")
    public ResponseEntity<?> getAll(){

        List<Pelanggan> all = pelangganRepository.findAll();

        return ResponseEntity.status(HttpStatus.OK).body(all);
    }

    @PutMapping("/pelanggan")
    public ResponseEntity<?> update(@RequestBody Pelanggan pelanggan){
        Optional<Pelanggan> byId = pelangganRepository.findById(pelanggan.getId_pelanggan());
        Pelanggan build = Pelanggan.builder()
                .id_pelanggan(byId.get().getId_pelanggan())
                .alamat_pelanggan(pelanggan.getAlamat_pelanggan())
                .email_pelanggan(pelanggan.getEmail_pelanggan())
                .nama_pelanggan(pelanggan.getNama_pelanggan())
                .password_pelanggan(pelanggan.getPassword_pelanggan())
                .build();
        Pelanggan save = pelangganRepository.save(build);
        return ResponseEntity.status(HttpStatus.OK).body(save);
    }

    @DeleteMapping("/pelanggan/{id}")
    public ResponseEntity<?> delete(@PathVariable String id){
        pelangganRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("data deleted");
    }
}
