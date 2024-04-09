package com.fortune.fortune.Services;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FortuneMessageService {

    private String FORTUNE_API_URL = "http://yerkee.com/api/fortune";

    public String getFortuneMessage(String zodiacSign) {
        RestTemplate restTemplate = new RestTemplate();

        // Make GET request to the third-party API
        ResponseEntity<String> response = restTemplate.exchange(
                FORTUNE_API_URL,
                HttpMethod.GET,
                null,
                String.class);

        // Retrieve the fortune from the response body
        String fortune = response.getBody();

        return fortune;
    }
}
