package com.fortune.fortune.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fortune.fortune.Model.UserDate;
import com.fortune.fortune.Services.FortuneMessageService;
import com.fortune.fortune.Services.FortuneService;

@RestController
public class FortuneController {

    private final FortuneService fortuneService;
    private final FortuneMessageService fortuneMessageService;

    @Autowired
    public FortuneController(FortuneService fortuneService, FortuneMessageService fortuneMessageService) {
        this.fortuneService = fortuneService;
        this.fortuneMessageService = fortuneMessageService;
    }

    @PostMapping("/fortune")
    public ResponseEntity<?> getZodiacSignAndFortune(@RequestBody UserDate userDate) {
        int month = userDate.getMonth();
        int date = userDate.getDate();

        String zodiacSign = fortuneService.getZodiacSign(month, date);
        String fortuneMessage = fortuneMessageService.getFortuneMessage(zodiacSign);

        // Construct the JSON response using a Map
        Map<String, Object> responseData = new HashMap<>();
        responseData.put("zodiacSign", zodiacSign);
        responseData.put("fortuneMessage", fortuneMessage);

        // Return the JSON response
        return ResponseEntity.ok(responseData);
    }

    @GetMapping("/zodiac-message/{zodiacSign}")
    public ResponseEntity<String> getZodiacMessage(@PathVariable String zodiacSign) {
        // Get message for the given zodiac sign
        String message = fortuneMessageService.getFortuneMessage(zodiacSign);

        // Return the message
        return ResponseEntity.ok(message);
    }
}
