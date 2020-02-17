package cc.xpbootcamp.warmup.fibonacci;

public class FibonacciGenerator {
    public long getFibonacci(int i) {
        if (i == 1 || i == 2)
            return 1;
        return getFibonacci(i - 1) + getFibonacci(i - 2);
    }
}
