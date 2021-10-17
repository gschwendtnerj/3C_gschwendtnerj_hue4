import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("n>");
            int number = Integer.parseInt(scanner.next());
            int result = 0;
            int splittedNumber;
            int addingNumber = 0;
            if(number%100 == 0)
            {
                splittedNumber = number/100;
            }else{
                splittedNumber = (number/100)+1;
            }

            ThreadPoolExecutor threadPoolExecutor = new ScheduledThreadPoolExecutor(4);


            List<Future<Integer>> futureList = new ArrayList<>();
            for(int i = 0; i< splittedNumber; i++)
            {
                if(i==splittedNumber-1 && number%100!=0)
                {
                    int tempNumber = addingNumber;
                    Callable<Integer> callable2 = () -> {
                        int numberSum = 0;
                        for(int j = tempNumber+1; j <= tempNumber+number%100;j++)
                        {
                            numberSum += j;
                        }
                        return numberSum;
                    };
                    futureList.add(threadPoolExecutor.submit(callable2));
                }else{
                    int tempNumber = addingNumber;
                    Callable<Integer> callable1 = () -> {
                        int numberSum = 0;
                        for(int j = tempNumber+1; j <= tempNumber+100;j++)
                        {
                            numberSum += j;
                        }
                        return numberSum;
                    };
                    futureList.add(threadPoolExecutor.submit(callable1));
                    addingNumber+=100;
                }

            }


            for (Future<Integer> integerFuture : futureList) {
                result+= integerFuture.get();
                integerFuture.cancel(true);
            }
            System.out.println("Sum: " + result);
            threadPoolExecutor.shutdown();

        } catch (NumberFormatException exc) {
            System.out.println("Illegal Input");
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
