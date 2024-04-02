package com.example.demo.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PembelianProduk {

    @Id
    private String id_pembelian_produk;
    private Pembelian id_pembelian;
    private Menu id_produk;
    private Integer jumlah;
    private String nama;
    private Integer harga;
}
