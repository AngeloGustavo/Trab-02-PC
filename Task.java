import java.math.BigDecimal;

public class Task implements Runnable{
    static BigDecimal resultado = BigDecimal.valueOf(1);
    private int i;

    public Task(int i) {
        this.i = i;
    }
    private long factorial(int number) {
        if (number <= 1) {
            return 1;
        } else {
            return number * factorial(number-1);
        }
    }
    @Override
    public void run() {        
        long fat = factorial(i);
        try {
            FixedThreadPool.mutex.lock();
            resultado = resultado.add(BigDecimal.valueOf(1.0/fat));
        } finally {
            FixedThreadPool.mutex.unlock();
        }
    }
}
