
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class FixedThreadPool {
    static public ReentrantLock mutex = new ReentrantLock();
    
    static public void menu(){       
        Scanner in = new Scanner(System.in);
        Menu.clearScreen();
        
        System.out.println("===Fixed Thread Pool===");
        System.out.println("Qual a aproximação desejada?");
        int aproximacao = in.nextInt();
        System.out.println("Qual a quantida de threads desejada?");
        int qtdThreads = in.nextInt();

        ExecutorService executor = Executors.newFixedThreadPool(qtdThreads);
        for (int i = 1; i <= aproximacao; i++) {  
            Runnable worker = new Task(i);  
            executor.execute(worker);  
        }  
        executor.shutdown();  
        while (!executor.isTerminated()) { }  
        
        System.out.println(Task.resultado);    
        in.close();
    }
}