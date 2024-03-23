package com.example.demo.repository;

import com.example.demo.model.Pelanggan;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PelangganRepository extends MongoRepository<Pelanggan, String> {
}
