package com.example.demo.model;

//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Pelanggan {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id_pelanggan;

    private String email_pelanggan;
    private String password_pelanggan;
    private String nama_pelanggan;
    private String alamat_pelanggan;
}
