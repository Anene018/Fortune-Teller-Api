package com.fortune.fortune.Services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fortune.fortune.Exceptions.InvalidZodiacSignException;
import com.fortune.fortune.utils.ZodiacSignValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FortuneMessageService {

    private final ZodiacSignValidator zodiacSignValidator;

    private final String FORTUNE_API_URL = "https://api.quotable.io/random";

    @Autowired
    public FortuneMessageService(ZodiacSignValidator zodiacSignValidator) {
        this.zodiacSignValidator = zodiacSignValidator;
    }

    public String getFortuneMessage(String zodiacSign) {
        // Validate the zodiac sign
        if (!ZodiacSignValidator.isValidZodiacSign(zodiacSign)) {
            throw new InvalidZodiacSignException("Please provide a valid zodiac sign.");
        }

        RestTemplate restTemplate = new RestTemplate();

        // Make GET request to the third-party API
        ResponseEntity<String> response = restTemplate.exchange(
                FORTUNE_API_URL,
                HttpMethod.GET,
                null,
                String.class);

        // Retrieve the fortune content from the response body
        String fortune = response.getBody();

        // Parse the JSON string to extract the "content" field
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(fortune);
            String content = jsonNode.get("content").asText();
            return content;
        } catch (Exception e) {
            // Handle any errors during parsing
            e.printStackTrace();
            return "Error fetching fortune.";
        }
    }
}
