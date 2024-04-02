package com.example.demo.model.response;

import com.example.demo.model.Pelanggan;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PembelianResponse {
    private String id_pembelian;
    private String id_pelanggan;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date tanggal_pembelian;
    private Integer total_pembelian;
}
