package com.fortune.fortune.Services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class FortuneServiceTest {
    @Mock
    private FortuneService fortuneService;

    @InjectMocks
    private FortuneService service;

    @Test
    void test_result() {
        assertEquals("Capricorn", service.getZodiacSign(12, 25));
    }

    @Test
    void testGetZodiacSign() {
        when(fortuneService.getZodiacSign(4, 10)).thenReturn("Aries");

        String expectedZodiacSign = "Aries";
        String actualZodiacSign = fortuneService.getZodiacSign(4, 10);
        assertEquals(expectedZodiacSign, actualZodiacSign);
    }

}
