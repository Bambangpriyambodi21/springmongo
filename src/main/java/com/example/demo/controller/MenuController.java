package com.example.demo.controller;

import com.example.demo.model.Menu;
import com.example.demo.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class MenuController {
    private final MenuRepository menuRepository;

    @PostMapping("/menu")
    public ResponseEntity<?> create(@RequestBody Menu menu){

        UUID uuid = UUID.randomUUID();

        Menu build = Menu.builder()
                .id_menu(String.valueOf(uuid))
                .menu(menu.getMenu())
                .harga(menu.getHarga())
                .stok(menu.getStok())
                .build();

        Menu save = menuRepository.save(build);

        return ResponseEntity.status(HttpStatus.OK).body(save);

    }

    @GetMapping("/menu")
    public ResponseEntity<?> getAll(){
        List<Menu> all = menuRepository.findAll();

        return ResponseEntity.status(HttpStatus.OK).body(all);
    }

    @PutMapping("/menu")
    public ResponseEntity<?> update(@RequestBody Menu menu){
        Optional<Menu> byId = menuRepository.findById(menu.getId_menu());

        Menu build = Menu.builder()
                .id_menu(byId.get().getId_menu())
                .menu(menu.getMenu())
                .harga(menu.getHarga())
                .stok(menu.getStok())
                .build();

        Menu save = menuRepository.save(build);

        return ResponseEntity.status(HttpStatus.OK).body(save);
    }

    @DeleteMapping("/menu/{id}")
    public ResponseEntity<?> delete(@PathVariable String id){
        menuRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Data Deleted");
    }
}
