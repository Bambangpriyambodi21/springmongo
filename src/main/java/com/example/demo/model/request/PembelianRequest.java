package com.example.demo.model.request;

import com.example.demo.model.Pelanggan;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PembelianRequest {
    private String id_pelanggan;
    private Integer total_pembelian;
}
