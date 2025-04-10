package calculator;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    private static Calculator classUnderTest;
    private static Double tempResult;

    @BeforeAll
    public static void setUp() {
        classUnderTest = new Calculator();
    }

    @BeforeEach
    public static void resetValues() {
        classUnderTest.mode = Calculator.twoOperator.normal;
        classUnderTest.num1 = 0.0;
        classUnderTest.num2 = 0.0;
        tempResult = 0.0;
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
    void testTwoOpOperationsAdd2() {
        classUnderTest.mode = Calculator.twoOperator.add;
        classUnderTest.num1 = 3.0;
        classUnderTest.num2 = 4.0;
        assertEquals(7.0, classUnderTest.twoOpOperations());
    }

    @Test
    @DisplayName("Tests the subtraction function")
    void testTwoOpOperationsSubtract() {
        classUnderTest.mode = Calculator.twoOperator.subtract;
        classUnderTest.num1 = 10.0;
        classUnderTest.num2 = 5.0;
        assertEquals(5.0, classUnderTest.twoOpOperations());
    }

    @Test
    @DisplayName("Tests subtraction followed by addition")
    void testTwoOpOperationsSubtractAdd() {
        classUnderTest.mode = Calculator.twoOperator.subtract;
        classUnderTest.num1 = 10.0;
        classUnderTest.num2 = 2.0;
        tempResult = classUnderTest.twoOpOperations(); // 10-2 = 8

        classUnderTest.mode = Calculator.twoOperator.add;
        classUnderTest.num1 = tempResult;
        classUnderTest.num2 = 1.0;
        assertEquals(9.0, classUnderTest.twoOpOperations()); // 8+1 = 9
    }

    @Test
    @DisplayName("Tests addition and multiplication")
    void testTwoOpOperationsAddMultiply() {
        classUnderTest.mode = Calculator.twoOperator.multiply;
        classUnderTest.num1 = 3.0;
        classUnderTest.num2 = 6.0;
        tempResult = classUnderTest.twoOpOperations(); // 3*6 = 18

        classUnderTest.mode = Calculator.twoOperator.add;
        classUnderTest.num1 = tempResult;
        classUnderTest.num2 = 2.0;
        assertEquals(20.0, classUnderTest.twoOpOperations()); // 18+2 = 20
    }

    @Test
    @DisplayName("Tests the division function")
    void testTwoOpOperationsDivide() {
        classUnderTest.mode = Calculator.twoOperator.divide;
        classUnderTest.num1 = 20.0;
        classUnderTest.num2 = 5.0;
        assertEquals(4.0, classUnderTest.twoOpOperations()); // 20/5 = 4
    }

    @Test
    @DisplayName("Tests multiplication followed by division")
    void testTwoOpOperationsMultiplyDivide() {
        classUnderTest.mode = Calculator.twoOperator.multiply;
        classUnderTest.num1 = 3.0;
        classUnderTest.num2 = 6.0;
        tempResult = classUnderTest.twoOpOperations(); // 3*2 = 6

        classUnderTest.mode = Calculator.twoOperator.divide;
        classUnderTest.num1 = tempResult;
        classUnderTest.num2 = 5.0;
        assertEquals(1.2, classUnderTest.twoOpOperations()); // 6/5 = 1.2
    }

}
