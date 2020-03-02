package ru.Klimov.Ilya;

import org.junit.jupiter.api.Test;
import ru.Klimov.Ilya.service.ParsingService;

public class ParsingServiceTest {
    @Test
    void testExpressionToRpn(){
        ParsingService parsingService = new ParsingService();

         org.junit.jupiter.api.Assertions
                 .assertEquals("78.2 67 + 90 0 190.9 - - -",parsingService.expressionToRpn("78.2+67-(90-(-190.9))"));
    }
}
