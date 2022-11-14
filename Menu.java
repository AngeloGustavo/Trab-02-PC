import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Menu.clearScreen();
        System.out.println("=== Trabalho de Threads Pool ===");
        System.out.println("1 - FixedThreadPool");
        System.out.println("2 - CachedThreadPool");
        System.out.println("3 - WorkStealingThreadPool");
        System.out.println("0 - Sair");
        int opcao = in.nextInt();
        
        switch (opcao) {
            case 1:
                FixedThreadPool.menu();
                break;
            case 2:                    
                CachedThreadPool.menu();
                break;

            case 3:                    
                WorkStealingThreadPool.menu();
                break;
        }

        in.close();
    }
    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    } 
}
