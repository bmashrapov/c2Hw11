import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        //ex 1
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        Stream<Integer> streamList = list.stream();
        findMinMax(streamList, Comparator.comparingInt(i -> i), (min, max) -> System.out.println("Min: " + min + ", Max: " + max));
        //ex.2
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        findEvenNumbers(list1);
    }

    //ex1
    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {
        List<T> list = stream.sorted(order).collect(Collectors.toList());
        if (list.isEmpty()) {
            minMaxConsumer.accept(null, null);
        } else {
            minMaxConsumer.accept(list.get(0), list.get(list.size() - 1));
        }
    }

    //ex.2
    public static void findEvenNumbers(List<Integer> list) {
        long evenCount = list.stream().filter(i -> i % 2 == 0).count();
        System.out.println("Number of even numbers: " + evenCount);
        list.stream().filter(i -> i % 2 == 0).forEach(i -> System.out.print(i + " "));
        System.out.println();
    }
}

