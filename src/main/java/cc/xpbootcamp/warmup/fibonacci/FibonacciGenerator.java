package cc.xpbootcamp.warmup.fibonacci;

public class FibonacciGenerator {
    public long getFibonacci(int position) {
        if (position <= 0) {
            throw new InvalidParameterException();
        }
        long preFibonacciNumber = 1;
        long prePreFibonacciNumber = 0;
        long fibonacciNumber = 0;
        if (position == 1) {
            return 1;
        }
        int count = 1;
        while (count < position) {
            fibonacciNumber = preFibonacciNumber + prePreFibonacciNumber;
            prePreFibonacciNumber = preFibonacciNumber;
            preFibonacciNumber = fibonacciNumber;
            count++;
        }
        return fibonacciNumber;
    }
}
