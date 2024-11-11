package calculator;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    private static Calculator classUnderTest;

    @BeforeAll
    public static void setUp() {
        classUnderTest = new Calculator();
    }

    @DisplayName("Tests the addition function")
    @Test
    void testTwoOpOperationsAdd() {
        classUnderTest.mode = Calculator.twoOperator.add;
        classUnderTest.num1 = 5.5;
        classUnderTest.num2 = 3.0;
        assertEquals(8.5, classUnderTest.twoOpOperations());
    }

}
