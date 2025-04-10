package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static Calculator classUnderTest;
    private static Double tempResult;

    @BeforeAll
    public static void setUp() {
        classUnderTest = new Calculator();
    }

    @BeforeEach
    public void resetValues() {
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
    void testThreeOpOperationsSubtractAdd() {
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
    @DisplayName("Tests the division function")
    void testTwoOpOperationsDivide() {
        classUnderTest.mode = Calculator.twoOperator.divide;
        classUnderTest.num1 = 20.0;
        classUnderTest.num2 = 5.0;
        assertEquals(4.0, classUnderTest.twoOpOperations()); // 20/5 = 4
    }

    @Test
    @DisplayName("Tests addition followed by multiplication")
    void testThreeOpOperationsAddMultiply() {
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
    @DisplayName("Tests multiplication followed by division")
    void testThreeOpOperationsMultiplyDivide() {
        classUnderTest.mode = Calculator.twoOperator.multiply;
        classUnderTest.num1 = 3.0;
        classUnderTest.num2 = 2.0;
        tempResult = classUnderTest.twoOpOperations(); // 3*2 = 6

        classUnderTest.mode = Calculator.twoOperator.divide;
        classUnderTest.num1 = tempResult;
        classUnderTest.num2 = 5.0;
        assertEquals(1.2, classUnderTest.twoOpOperations()); // 6/5 = 1.2
    }

    // public enum singleOperator { //custom added operators asin,acos,atan,eul,pi,log,logn,abs,fact
	// 	square, squareRoot, oneDevidedBy, cos, sin, tan,asin,acos,atan,eul,pi,log,logn,abs,fact
	// }

    @Test
    @DisplayName("Tests the square function")
    void testSquare() {
        assertEquals(16.0, classUnderTest.calcScience(Calculator.singleOperator.square, 4.0)); // 4^2 = 16
    }

    @Test
    @DisplayName("Tests the square root function")
    void testSquareRoot() {
        assertEquals(7.0, classUnderTest.calcScience(Calculator.singleOperator.squareRoot, 49.0)); // 49^0.5 = 7
    }

    @Test
    @DisplayName("Tests the 1/x function")
    void testOneDividedBy() {
        assertEquals(0.2, classUnderTest.calcScience(Calculator.singleOperator.oneDevidedBy, 5.0)); // 1/5 = 0.2
    }

    @Test
    @DisplayName("Tests the cosine function in degrees")
    void testCos() {
        assertEquals(-1.0, classUnderTest.calcScience(Calculator.singleOperator.cos, 180.0)); // cos(180) = -1
    }

    @Test
    @DisplayName("Tests the sine function in degrees")
    void testSin() {
        assertEquals(0.0, classUnderTest.calcScience(Calculator.singleOperator.sin, 180.0)); // sin(180) = 0
    }

    @Test
    @DisplayName("Tests the tan function in degrees")
    void testTan() {
        assertEquals(1.0, classUnderTest.calcScience(Calculator.singleOperator.tan, 45.0)); // tan(45) = 1
    }

    @Test
    @DisplayName("Tests whether an error is thrown if a null mode is passed")
    void testThrowError() {
        assertThrows(Error.class, () -> {
            classUnderTest.calcScience(null, 45.0);
        }); // null = error
    }

}
