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
        return strings.stream().filter(value -> value.length()!=0).collect(Collectors.toList());
    }

    private static String getMergedString(List<String> strings, String seperator)
    {
        return strings.stream().filter(value -> value.length()!=0).map(s -> {
            if(strings.get(0).equals(s))
            {
                return s;
            }
            return seperator+s;
        }).collect(Collectors.joining());
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
        return numbers.stream().min((o1, o2) -> o1 - o2).get();
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
        System.out.println("deleteEmptyStrings: " + (tempList.size()==3));
        System.out.println("getMergedString: " + (getMergedString(stringList,":").equals("Hallo:123:Hal")));

        List<Integer> intList = new ArrayList<>();
        intList.add(1);
        intList.add(2);
        intList.add(3);
        List<Integer> tempList2 = getSquares(intList);
        boolean getSquares = true;

        if(tempList2.get(0)!=1 || tempList2.get(1)!=4 || tempList2.get(2)!=9)
        {
            getSquares = false;
        }
        System.out.println("getSquares: " + getSquares);
        System.out.println("getMax: " + (getMax(intList)==3));
        System.out.println("getMin: " + (getMin(intList)==1));
        System.out.println("getSum: " + (getSum(intList)==6));
        System.out.println("getAverage: " + (getAverage(intList)==2));

    }
}
