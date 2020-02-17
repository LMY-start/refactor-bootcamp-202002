package cc.xpbootcamp.warmup.fibonacci;

public class FibonacciGenerator {
    public long getFibonacci(int position) {
        if(position <=0 ){
            throw new InvalidParameterException();
        }
        if (position == 1 || position == 2)
            return 1;
        return getFibonacci(position - 1) + getFibonacci(position - 2);
    }
}
