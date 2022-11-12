import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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

        // выводим только четные числа, метод of()
        IntStream stream2 = IntStream.of(1, 2, 3, 4, 5).parallel();
        stream2.unordered()
                .filter(x -> (x % 2) == 0)
                .forEachOrdered(x -> System.out.print(x + " "));
        System.out.println();

        // метод build(), add()
        IntStream stream3 = IntStream.builder().add(1).add(2).build();
        stream3.forEachOrdered(x -> System.out.print(x + " "));
        System.out.println();
        Stream.builder().add("1").add("2").build()
                .forEachOrdered(x -> System.out.print(x + " "));
        System.out.println();

        // Статический метод ofNullable() создает поток из заданного значения
        Stream<Integer> stream4 = Stream.ofNullable(5);
        stream4.forEachOrdered(x -> System.out.println(x + " "));
        stream4 = Stream.ofNullable(null);
        System.out.println(stream4.count());

        // Создать поток символов из строки или из объекта, класс которого реализует интерфейс CharSequence, 
        //  позволяют методы chars () И codePoints ()
        IntStream stream5 = "строка".chars();
        stream5.forEachOrdered(x -> System.out.print((char) x));
        System.out.println();
        StringBuilder sb = new StringBuilder();
        sb.append("строка");
        IntStream stream6 = sb.chars();
        stream6.forEachOrdered(x -> System.out.print((char) x));
        System.out.println();
        //Метод splitAsstreamO из класса Pattern разбивает строку на подстроки по указанному разделителю,
        // представленному в виде регулярного выражения, и возвращает поток
        Pattern p = Pattern.compile("\\s+");
        Stream<String> stringStream = p.splitAsStream("1 2 3");
        stringStream.forEachOrdered(s -> System.out.println(s));

        // в классе Matcher доступен метод results (), который позволяет
        //получить поток данных с результатами поиска по шаблону регулярного выражения.
        Pattern pattern = Pattern.compile("[0-9]+");
        Matcher m = pattern.matcher("10 20 30");
        m.results().forEachOrdered(mr -> System.out.println(mr.group()));
        System.out.println();
    }
}