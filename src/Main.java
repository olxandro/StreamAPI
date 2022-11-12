import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        //выведем все элементы из списка, значение которых меньше 4

        ArrayList<Integer> arr = new ArrayList<>();
        Collections.addAll(arr, 1, 2, 3, 4, 5);
        Stream<Integer> stream = arr.stream();
        stream.filter((x) -> x < 4).forEachOrdered((x) -> System.out.print(x + " "));
        System.out.println();

        int[] arr3 = {1, 2, 3, 4, 5,};
        IntStream stream1 = Arrays.stream(arr3).parallel();
        int[] arr4 = stream1.unordered().map(x -> x * 2).toArray();
        System.out.println(Arrays.toString(arr3));
        System.out.println(Arrays.toString(arr4));

        // выводим только четные числа
        IntStream stream2 = IntStream.of(1, 2, 3, 4, 5).parallel();
        stream2.unordered()
                .filter(x -> (x % 2) == 0)
                .forEachOrdered(x -> System.out.print(x + " "));
        System.out.println();
    }
}