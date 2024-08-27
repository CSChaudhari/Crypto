package com.example.crypto.service;

import com.example.crypto.entity.Cryptocurrency;
import com.example.crypto.repository.CryptocurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.json.JSONObject;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CryptocurrencyService {

    @Autowired
    private CryptocurrencyRepository cryptocurrencyRepository;

    @Autowired
    private RestTemplate restTemplate;

    public Cryptocurrency saveCryptocurrency(Cryptocurrency cryptocurrency) {
        return cryptocurrencyRepository.save(cryptocurrency);
    }

    public List<Cryptocurrency> getCryptocurrenciesByUserId(int userId) {
        return cryptocurrencyRepository.findByUserId(userId);
    }

    // New method to fetch data from the external API and save it
    public void fetchAndSaveCryptoData() {
        String apiUrl = "https://cashrichapp.com/java/api"; // Replace with the actual API URL
        ResponseEntity<String> response = restTemplate.getForEntity(apiUrl, String.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            JSONObject jsonResponse = new JSONObject(response.getBody());
            JSONObject btcData = jsonResponse.getJSONObject("data").getJSONObject("BTC");
            
            Cryptocurrency bitcoin = new Cryptocurrency();
            bitcoin.setCoinName(btcData.getString("name"));
            bitcoin.setCoinSymbol(btcData.getString("symbol"));
            bitcoin.setPrice(btcData.getJSONObject("quote").getJSONObject("USD").getDouble("price"));
            bitcoin.setLastUpdated(LocalDateTime.parse(btcData.getString("last_updated")));
            
            cryptocurrencyRepository.save(bitcoin);
        }
    }
}
