import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class JavaStreamsTester {
    private static int getCountEmptyString(List<String> strings)
    {
        return strings.stream().filter(s -> s.equals("")).toArray().length;
    }
    private static int getCountLength3(List<String> strings)
    {
        return strings.stream().mapToInt(String::length).filter(value -> value==3).toArray().length;
    }
    private static List<String> deleteEmptyStrings(List<String> strings)
    {
        return strings.stream().filter(value -> value.length()==0).collect(Collectors.toList());
    }

    private static String getMergedString(List<String> strings, String seperator)
    {
        return strings.stream().skip(0).map(s -> seperator+s).toString();
    }

    private static List<Integer> getSquares(List<Integer> numbers)
    {
        return numbers.stream().map(integer -> integer*integer).collect(Collectors.toList());
    }

    private static int getMax(List<Integer> numbers)
    {
        return numbers.stream().max((o1, o2) -> o1 - o2).get();
    }

    private static int getMin(List<Integer> numbers)
    {
        return numbers.stream().mapToInt(value -> value).sum();
    }

    private static int getSum(List<Integer> numbers)
    {
        return numbers.stream().mapToInt(value -> value).sum();
    }

    private static int getAverage(List<Integer> numbers)
    {
        OptionalDouble average = numbers.stream().mapToInt(value -> value).average();
        return (int) average.orElse(-1);
    }

    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("Hallo");
        stringList.add("");
        stringList.add("123");
        stringList.add("Hal");
        stringList.add("");


        System.out.println("getCountEmtpyString: " + (getCountEmptyString(stringList)==2));
        System.out.println("getCountLength3: " + (getCountLength3(stringList)==2));
        List<String> tempList = deleteEmptyStrings(stringList);



    }
}
