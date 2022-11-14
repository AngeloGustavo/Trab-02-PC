
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WorkStealingThreadPool {
    
    static public void menu() {
        Scanner in = new Scanner(System.in);
        Menu.clearScreen();

        System.out.println("===Cached Thread Pool===");
        System.out.println("Qual a aproximação desejada?");
        int aproximacao = in.nextInt();
        
        ExecutorService executor = Executors.newWorkStealingPool();
        for (int i = 1; i <= aproximacao; i++) {  
            Runnable worker = new Task(i);  
            executor.execute(worker); 
        }  
        executor.shutdown();  
        while (!executor.isTerminated()) {   }  
        
        System.out.println(Task.resultado);    
        in.close();
    }
}     
