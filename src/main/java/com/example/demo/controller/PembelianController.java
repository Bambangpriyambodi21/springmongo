package com.example.demo.controller;

import com.example.demo.model.Pelanggan;
import com.example.demo.model.Pembelian;
import com.example.demo.model.request.PembelianRequest;
import com.example.demo.model.response.PembelianResponse;
import com.example.demo.repository.PelangganRepository;
import com.example.demo.repository.PembelianRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequiredArgsConstructor
@Slf4j
public class PembelianController {
    private final PembelianRepository pembelianRepository;
    private final PelangganRepository pelangganRepository;

    @GetMapping("/addPembelian")
    public String addPembelian(Model model){
        model.addAttribute("pembelianrequest",new PembelianRequest());
        return "pembelian/post";
    }

    @GetMapping("/ubahPembelian/{id}")
    public String ubahPembelian(@PathVariable String id, Model model){
        Optional<Pembelian> byId = pembelianRepository.findById(id);
        Pembelian pembelian = Pembelian.builder()
                .id_pembelian(byId.get().getId_pembelian())
                .id_pelanggan(byId.get().getId_pelanggan())
                .tanggal_pembelian(byId.get().getTanggal_pembelian())
                .total_pembelian(byId.get().getTotal_pembelian())
                .build();
        model.addAttribute("ubahPembelian",pembelian);
        return "pembelian/put";
    }

    @PostMapping("/pembelian")
    public String create(@ModelAttribute PembelianRequest pembelian){
        UUID uuid = UUID.randomUUID();
        Date date = new Date();
        Optional<Pelanggan> byId = pelangganRepository.findById(pembelian.getId_pelanggan());
        log.info(pembelian.getId_pelanggan());
        log.info(String.valueOf(uuid));
        Pembelian build = Pembelian.builder()
                .id_pembelian(String.valueOf(uuid))
                .id_pelanggan(byId.get())
                .total_pembelian(pembelian.getTotal_pembelian())
                .tanggal_pembelian(date)
                .build();
        log.info(String.valueOf(build.getId_pelanggan()));
        Pembelian save = pembelianRepository.save(build);
        return "redirect:/pembelian";
//        return ResponseEntity.status(HttpStatus.OK).body(save);
    }

    @PostMapping("/ubahPembelian")
    public String update(@ModelAttribute PembelianRequest pembelian){
        UUID uuid = UUID.randomUUID();
        Date date = new Date();
        Optional<Pelanggan> byId = pelangganRepository.findById(pembelian.getId_pelanggan());
        log.info(pembelian.getId_pelanggan());
        log.info(String.valueOf(uuid));
        Pembelian build = Pembelian.builder()
                .id_pembelian(pembelian.getId_pelanggan())
                .id_pelanggan(byId.get())
                .total_pembelian(pembelian.getTotal_pembelian())
                .tanggal_pembelian(date)
                .build();
        log.info(String.valueOf(build.getId_pelanggan()));
        Pembelian save = pembelianRepository.save(build);
        return "redirect:/pembelian";
//        return ResponseEntity.status(HttpStatus.OK).body(save);
    }

    @GetMapping("/pembelian")
    public String getAll(Model model){
        List<Pembelian> all = pembelianRepository.findAll();
        ArrayList<PembelianResponse> pembelianResponses = new ArrayList<>();
        for (int i=0;i< all.size();i++){
            PembelianResponse build = PembelianResponse.builder()
                    .id_pembelian(all.get(i).getId_pembelian())
                    .id_pelanggan(all.get(i).getId_pelanggan().getId_pelanggan())
                    .tanggal_pembelian(all.get(i).getTanggal_pembelian())
                    .total_pembelian(all.get(i).getTotal_pembelian())
                    .build();
            pembelianResponses.add(build);
        }

        model.addAttribute("datapembelian",pembelianResponses);
//        return ResponseEntity.status(HttpStatus.OK).body(pembelianResponses);
        return "pembelian/getAll";
    }

    @GetMapping("/pembelian/{id}")
    public String delete(@PathVariable String id){
        pembelianRepository.deleteById(id);
        return "redirect:/pembelian";
    }
}
