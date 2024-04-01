package com.example.demo.controller;

import com.example.demo.model.Pelanggan;
import com.example.demo.repository.PelangganRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class PelangganController {

    private final PelangganRepository pelangganRepository;

    @GetMapping("/addPelanggan")
    public String addPelanggan(Model model){
        model.addAttribute("customer", new Pelanggan());
        return "pelanggan/post";
    }

    @GetMapping("/ubahPelanggan/{id}")
    public String ubahPelanggan(@PathVariable String id, Model model){
        Optional<Pelanggan> byId = pelangganRepository.findById(id);
        Pelanggan build = Pelanggan.builder()
                .id_pelanggan(byId.get().getId_pelanggan())
                .alamat_pelanggan(byId.get().getAlamat_pelanggan())
                .email_pelanggan(byId.get().getEmail_pelanggan())
                .nama_pelanggan(byId.get().getNama_pelanggan())
                .password_pelanggan(byId.get().getPassword_pelanggan())
                .build();
        model.addAttribute("customer", build);
//        String update = update(build);
        return "pelanggan/put";
    }

    @PostMapping("/pelanggan")
    public String create(@ModelAttribute Pelanggan pelanggan){

        UUID uuid = UUID.randomUUID();

        Pelanggan build = Pelanggan.builder()
                .id_pelanggan(String.valueOf(uuid))
                .alamat_pelanggan(pelanggan.getAlamat_pelanggan())
                .email_pelanggan(pelanggan.getEmail_pelanggan())
                .nama_pelanggan(pelanggan.getNama_pelanggan())
                .password_pelanggan(pelanggan.getPassword_pelanggan())
                .build();

        Pelanggan save = pelangganRepository.save(build);

//        return ResponseEntity.status(HttpStatus.OK).body(save);
        return "redirect:/pelanggan";
    }

    @GetMapping("/pelanggan")
    public String getAll(Model model){

        List<Pelanggan> all = pelangganRepository.findAll();
        model.addAttribute("customerList",all);

//        return ResponseEntity.status(HttpStatus.OK).body(all);
        return "pelanggan/getall";
    }

    @PostMapping("/ubahPelanggan")
    public String update(@ModelAttribute Pelanggan pelanggan){
        Optional<Pelanggan> byId = pelangganRepository.findById(pelanggan.getId_pelanggan());
        Pelanggan build = Pelanggan.builder()
                .id_pelanggan(byId.get().getId_pelanggan())
                .alamat_pelanggan(pelanggan.getAlamat_pelanggan())
                .email_pelanggan(pelanggan.getEmail_pelanggan())
                .nama_pelanggan(pelanggan.getNama_pelanggan())
                .password_pelanggan(pelanggan.getPassword_pelanggan())
                .build();
        Pelanggan save = pelangganRepository.save(build);
        return "redirect:/pelanggan";
    }

    @GetMapping("/pelanggan/{id}")
    public String delete(@PathVariable String id){
        pelangganRepository.deleteById(id);
        return "redirect:/pelanggan";
    }
}
