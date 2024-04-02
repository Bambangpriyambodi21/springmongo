package com.example.demo.repository;

import com.example.demo.model.PembelianProduk;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PembelianProdukRepository extends MongoRepository<PembelianProduk, String> {
}
