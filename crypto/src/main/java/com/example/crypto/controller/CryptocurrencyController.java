package com.example.crypto.controller;

import com.example.crypto.entity.Cryptocurrency;
import com.example.crypto.service.CryptocurrencyService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cryptocurrencies")
public class CryptocurrencyController {

    @Autowired
    private CryptocurrencyService cryptocurrencyService;

    @PostMapping("/save")
    public ResponseEntity<Cryptocurrency> saveCryptocurrency(@RequestBody Cryptocurrency cryptocurrency) {
        Cryptocurrency savedCrypto = cryptocurrencyService.saveCryptocurrency(cryptocurrency);
        return ResponseEntity.ok(savedCrypto);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Cryptocurrency>> getCryptocurrenciesByUserId(@PathVariable int userId) {
        List<Cryptocurrency> cryptocurrencies = cryptocurrencyService.getCryptocurrenciesByUserId(userId);
        return ResponseEntity.ok(cryptocurrencies);
    }

    // Endpoint to fetch and save cryptocurrency details from the API
    @GetMapping("/fetch-and-save")
    public ResponseEntity<String> fetchAndSaveCryptoDetails() {
        cryptocurrencyService.fetchAndSaveCryptoData();
        return ResponseEntity.ok("Cryptocurrency details fetched and stored successfully.");
    }
}
