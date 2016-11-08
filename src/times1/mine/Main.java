package src.times1.mine;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Created by Administrator on 2016-11-07.
 */
public class Main {

    /**
     * Predicate<T> : T -> boolean
     * Consumer<T> : T -> void
     * Function<T, R> : T -> R
     * Supplier<T> : () -> T
     * UnaryOperator<T> : T -> T
     * BinaryOperator<T, T> : (T, T) -> T
     * BiPredicate<L, R> : (L, R) -> boolean
     * BiConsumer<T, U> -> void
     * BiFunction<T, U, R> -> (T, U) -> R
     * */

    @Test
    public void lambada() {
    }


    //메소드 타입 => 리턴 타입, 메소드 타입 파라미터(개수, 메소드 아규먼트 타입(타입), 예외
    @Test
    public void functional_interface() {
        Arrays.asList(processArithmetic((a , b) -> a + b, 1, 2),
                processArithmetic((a , b) -> a - b, 10, 5),
                processArithmetic((a , b) -> a * b, 2, 4),
                processArithmetic((a , b) -> a / b, 4, 2)
        ).stream().forEach(System.out::println);
    }

    public static int processArithmetic(Arithmetic adder, int a, int b) {
        return adder.arithmetic(a, b);
    }

    @Test
    public void method_ref() {
        //정적 메소드 호출방식의 메서드 레퍼런스
        Function<String, Integer> stringToInteger = (String s) -> Integer.parseInt(s);
        Function<String, Integer> stringToInteger2 = Integer::parseInt;

        //인스턴스 호출방식의 메서드 레퍼런스
        BiPredicate<List<String>, String> contains = (list, element) -> list.contains(element);
        BiPredicate<List<String>, String> contains2 = List::contains;

        System.out.println(stringToInteger.apply("1"));
        System.out.println(stringToInteger2.apply("1"));

        System.out.println(contains.test(Arrays.asList("1","2"), "1"));
        System.out.println(contains2.test(Arrays.asList("1","2"), "1"));

    }

    @Test
    public void box_unbox() {
        IntPredicate evenNumbers  = (int i) -> i % 2 == 0;

        Predicate<Integer> oddNumbers = (Integer i) -> i % 2 == 1;

        java.util.function.IntPredicate evenNumbers2 = (int i) -> i % 2 ==  0;

        //no boxing
        evenNumbers.test(1000);
        evenNumbers2.test(1000);

        //do boxing
        oddNumbers.test(1000);
    }
}
