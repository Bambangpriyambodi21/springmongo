package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document("pembelian")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Pembelian {

    @Id
    private String id_pembelian;

    private Pelanggan id_pelanggan;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date tanggal_pembelian;
    private Integer total_pembelian;
}
