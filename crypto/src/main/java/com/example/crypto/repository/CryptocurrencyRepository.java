package com.example.crypto.repository;

import com.example.crypto.entity.Cryptocurrency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CryptocurrencyRepository extends JpaRepository<Cryptocurrency, Integer> {
    List<Cryptocurrency> findByUserId(int userId);
}
