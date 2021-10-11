import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<ArrayList<Integer>> list;
        List<Integer> numbers = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("numbers.csv"))) {

            list = br.lines()
                    .map(s -> s.split(":"))
                    .map(s -> {
                       ArrayList<Integer> tempList = new ArrayList<>();
                       for(int i = 0; i < s.length; i++) {
                           try {
                                tempList.add(Integer.parseInt(s[i]));
                           } catch (NumberFormatException exc) {
                           }
                       }
                        return tempList;
                    }).collect(Collectors.toList());

            for(int i = 0; i < list.size();i++)
            {
                for(int j = 0; j < list.get(i).size();j++)
                {
                    numbers.add(list.get(i).get(j));
                }
            }
            System.out.println();
            try {
                System.out.print("\n" + "chunks>");
                int chunks = Integer.parseInt(scanner.next());
                System.out.print("\n" + "divider>");
                int divider = Integer.parseInt(scanner.next());
                ThreadPoolExecutor threadPoolExecutor = new ScheduledThreadPoolExecutor(chunks);
                List<Integer> tempList;
                int startingInt = 0;
                int numbersInChunk = numbers.size()/chunks;
                MyThread myThread;
                for (int i = 0; i < chunks; i++)
                {
                    tempList = new ArrayList<>();

                    for(int j = startingInt; j < startingInt+numbersInChunk;j++)
                    {
                        tempList.add(numbers.get(j));
                    }
                    startingInt+=numbersInChunk;
                    myThread = new MyThread((ArrayList<Integer>) tempList, divider);
                    threadPoolExecutor.execute(myThread);
                }
                threadPoolExecutor.shutdown();
            }catch (NumberFormatException exc) {
                System.out.println("Illegal Input!");
            }



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
