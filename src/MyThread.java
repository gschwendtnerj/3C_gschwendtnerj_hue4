import java.util.ArrayList;
import java.util.List;

public class MyThread implements Runnable{
    private int divider;
    private ArrayList<Integer> list;
    public MyThread(ArrayList<Integer> list, int divider) {
        this.list = list;
        this.divider = divider;
    }

    @Override
    public void run() {
        for (Integer integer : list) {
            if (integer % divider == 0) {
                System.out.println(integer / divider);
            }
        }
    }

}
