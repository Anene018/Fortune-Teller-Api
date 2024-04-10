package com.fortune.fortune.utils;

import java.util.Arrays;
import java.util.List;

import com.fortune.fortune.Exceptions.InvalidZodiacSignException;

public class ZodiacSignValidator {

    private static final List<String> VALID_ZODIAC_SIGNS = Arrays.asList(
            "Aries", "Taurus", "Gemini", "Cancer", "Leo", "Virgo",
            "Libra", "Scorpio", "Sagittarius", "Capricorn", "Aquarius", "Pisces");

    public static void validate(String zodiacSign) {
        if (zodiacSign == null) {
            throw new NullPointerException("Please provide a zodiac sign.");
        }

        if (!VALID_ZODIAC_SIGNS.contains(zodiacSign)) {
            throw new InvalidZodiacSignException("Please provide a valid zodiac sign.");
        }
    }

    public static boolean isValidZodiacSign(String zodiacSign) {
        return VALID_ZODIAC_SIGNS.contains(zodiacSign);
    }
}
