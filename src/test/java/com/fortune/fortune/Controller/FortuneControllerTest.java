package com.fortune.fortune.Controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.fortune.fortune.Model.UserDate;
import com.fortune.fortune.Services.FortuneMessageService;
import com.fortune.fortune.Services.FortuneService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ZodiacFortuneControllerTest {

    @Mock
    private FortuneService zodiacSignService;

    @Mock
    private FortuneMessageService fortuneMessageService;

    @InjectMocks
    private FortuneController controller;

    @SuppressWarnings("deprecation")
    @Test
    void testGetZodiacSignAndFortune() {
        // Mocking behavior
        String zodiacSign = "Aries";
        when(zodiacSignService.getZodiacSign(3, 21)).thenReturn(zodiacSign);

        String fortuneMessage = "Today is your lucky day!";
        when(fortuneMessageService.getFortuneMessage(zodiacSign)).thenReturn(fortuneMessage);

        // Test
        UserDate zodiacDate = new UserDate();
        zodiacDate.setMonth(3);
        zodiacDate.setDate(21);

        ResponseEntity<?> responseEntity = controller.getZodiacSignAndFortune(zodiacDate);

        // Verify response
        assertEquals(200, responseEntity.getStatusCodeValue());

        String expectedJsonResponse = "{\"zodiacSign\": \"" + zodiacSign + "\", \"fortuneMessage\": \"" + fortuneMessage
                + "\"}";
        assertEquals(expectedJsonResponse, responseEntity.getBody());
    }
}
