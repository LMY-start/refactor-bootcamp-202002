package cc.xpbootcamp.warmup.fibonacci;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        int fibonacciNumber = fibonacciGenerator.getFibonacci(1);
        assertEquals(1, fibonacciNumber);
    }

    @Test
    public void should_return_1_when_calculate_given_position_is_2() {
        int fibonacciNumber = fibonacciGenerator.getFibonacci(2);
        assertEquals(1, fibonacciNumber);
    }

}