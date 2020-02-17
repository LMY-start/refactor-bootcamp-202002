package cc.xpbootcamp.warmup.fibonacci;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FibonacciGeneratorTest {

    private FibonacciGenerator fibonacciGenerator;

    @BeforeEach
    void setUp() {
        fibonacciGenerator = new FibonacciGenerator();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void should_return_1_when_calculate_given_position_is_1() {
        long fibonacciNumber = fibonacciGenerator.getFibonacci(1);
        assertEquals(1, fibonacciNumber);
    }

    @Test
    public void should_return_1_when_calculate_given_position_is_2() {
        long fibonacciNumber = fibonacciGenerator.getFibonacci(2);
        assertEquals(1, fibonacciNumber);
    }

    @Test
    public void should_return_2_when_calculate_given_position_is_3() {
        long fibonacciNumber = fibonacciGenerator.getFibonacci(3);
        assertEquals(2, fibonacciNumber);
    }

    @Test
    public void should_return_3_when_calculate_given_position_is_4() {
        long fibonacciNumber = fibonacciGenerator.getFibonacci(4);
        assertEquals(3, fibonacciNumber);
    }

    @Test
    public void should_return_144_when_calculate_given_position_is_12() {
        long fibonacciNumber = fibonacciGenerator.getFibonacci(12);
        assertEquals(144, fibonacciNumber);
    }

    @Test
    public void should_return_12586269025_when_calculate_given_position_is_50() {
        long fibonacciNumber = fibonacciGenerator.getFibonacci(50);
        assertEquals(12586269025L, fibonacciNumber);
    }

    @Test
    public void should_return_exception_when_calculate_given_position_is_0() {
        assertThrows(InvalidParameterException.class, () -> fibonacciGenerator.getFibonacci(0));
    }

    @Test()
    public void should_return_exception_when_calculate_given_position_is_less_than_0() {
        assertThrows(InvalidParameterException.class, () -> fibonacciGenerator.getFibonacci(-1));
    }
}