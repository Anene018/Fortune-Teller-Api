package com.fortune.fortune.Services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

//Note most of the test failed because the message is random

@ExtendWith(MockitoExtension.class)
class FortuneMessageServiceTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private FortuneMessageService fortuneMessageService;

    @Test
    void testGetFortuneMessage() {
        // Mocking behavior
        String expectedFortune = "Today is your lucky day!";
        ResponseEntity<String> responseEntity = new ResponseEntity<>(expectedFortune, HttpStatus.OK);

        when(restTemplate.exchange(
                anyString(),
                eq(HttpMethod.GET),
                any(),
                eq(String.class)))
                .thenReturn(responseEntity);

        // Test
        String actualFortune = fortuneMessageService.getFortuneMessage(expectedFortune);
        assertEquals(expectedFortune, actualFortune);

        // Verify that restTemplate.exchange was called once with the correct parameters
        verify(restTemplate, times(1)).exchange(
                anyString(),
                eq(HttpMethod.GET),
                any(),
                eq(String.class));
    }

    @Test
    public void testGetFortuneMessage_successfulResponse() {
        // Mock RestTemplate response
        ResponseEntity<String> mockResponse = ResponseEntity.ok("Your lucky number is 7.");
        when(restTemplate.exchange(anyString(), eq(HttpMethod.GET), any(), eq(String.class)))
                .thenReturn(mockResponse);

        String zodiacSign = "Aries";
        // Call method to test
        String fortune = fortuneMessageService.getFortuneMessage(zodiacSign);

        // Verify behavior
        assertEquals("Your lucky number is 7.", fortune);
    }

    @Test
    public void testGetFortuneMessage_errorResponse() {
        // Mock RestTemplate response to return an error
        ResponseEntity<String> mockErrorResponse = ResponseEntity.badRequest().body("Error fetching fortune.");
        when(restTemplate.exchange(anyString(), eq(HttpMethod.GET), any(), eq(String.class)))
                .thenReturn(mockErrorResponse);

        String zodiacSign = "Aries";

        // Call method to test
        String fortune = fortuneMessageService.getFortuneMessage(zodiacSign);

        // Assert behavior (handle error gracefully or throw an exception)
        assertEquals("Error fetching fortune.", fortune); // Example of graceful handling
    }
}
