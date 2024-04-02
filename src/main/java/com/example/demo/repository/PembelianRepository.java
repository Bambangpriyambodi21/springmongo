package com.example.demo.repository;

import com.example.demo.model.Pembelian;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PembelianRepository extends MongoRepository<Pembelian, String> {
}
