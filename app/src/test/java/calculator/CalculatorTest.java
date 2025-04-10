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

    @Test
    @DisplayName("Tests the addition function")
    void testSimpleAddition() {
        assertEquals(7, calc.evaluate("3+4"), 0.0001);
    }

    @Test
    @DisplayName("Tests the subtraction function")
    void testSimpleSubtraction() {
        assertEquals(5, calc.evaluate("10-5"), 0.0001);
    }

    @Test
    @DisplayName("Tests subtraction followed by addition")
    void testTwoOpOperationsSubtractAdd() {
        assertEquals(9, calc.evaluate("10-2+1"), 0.0001); // 10-2 = 8, 8+1 = 9
    }

    @Test
    @DisplayName("Tests addition and multiplication order of operations")
    void testTwoOpOperationsAddMultiply() {
        assertEquals(20, calc.evaluate("2+3*6"), 0.0001); // 3*6 = 18, 18+2 = 20
    }

    @Test
    @DisplayName("Tests the division function")
    void testSimpleDivision() {
        assertEquals(4, calc.evaluate("20/5"), 0.0001);
    }

    @Test
    @DisplayName("Tests multiplication followed by division")
    void testTwoOpOperationsMultiplyDivide() {
        assertEquals(1.2, calc.evaluate("3*2/5"), 0.0001); // 3*2 = 6, 6/5 = 1.2
    }

}
