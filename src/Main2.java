import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            int number = Integer.parseInt(scanner.nextLine());

            ThreadPoolExecutor threadPoolExecutor = new ScheduledThreadPoolExecutor(10);
            Callable<Integer> callable = () -> {
                return 0;
            };
            Future<Integer> result = threadPoolExecutor.submit(callable);

        } catch (NumberFormatException exc) {
            System.out.println("Illegal Input");
        }
    }
}
