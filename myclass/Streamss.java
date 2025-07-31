package myclass;

import java.util.Arrays;
import java.util.List;

public class Streamss {
    public static void main(String args[]) {
        // #Stream

        // #For Collection
        // List<String> name = Arrays.asList("Person1", "Person2");
        // Stream<String> nameStream = name.stream();

        // #Form Array
        // int[] number = { 1, 2, 3 };
        // IntStream numStream = Arrays.stream(number);

        // // #Form Directly Stream
        // Stream<Integer> intStream = Stream.of(1, 2, 3);

        // // # Stream Methods

        // Stream<Integer> infinity = Stream.iterate(0, n -> n + 2).limit(5);

        // #filter()
        // List<String> names = Arrays.asList("Person1", "Person2", "Jhon");
        // List<String> nameStartWithP = names.stream()
        // .filter(name -> name.startsWith("P"))
        // .collect(Collectors.toList());

        // System.out.println(nameStartWithP);

        // #map()
        // List<String> names = Arrays.asList("Nayak","Person1","Person2555");
        // List<Integer> length = names.stream()
        // .map( name -> name.length())
        // .collect(Collectors.toList());

        // System.out.println(length);

        // #reduce()
        // List<Integer> numberss = Arrays.asList(1,4,7,9,10);
        // int sum = numberss.stream()
        // .reduce(0,(a,b) -> a + b);
        // System.out.println(sum);

        // List<String> words = Arrays.asList("Hello", "World");
        // String msg = words.stream()
        // .reduce("=>",(a,b) -> a +"_"+ b);
        // System.out.println(msg);

        // List<Integer> number = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        // int evenSum = number.stream()
        // .filter( n -> n% 2 == 0 ) //* even Number */
        // .map( n -> n * 2)
        // .reduce(0 ,(a,b)-> a + b);
        // System.out.println(evenSum);

        // # sorted // #forEach()
        // List<Integer> number = Arrays.asList(10, 6, 9, 30, 50, 20, 55, 867);
        // number.stream().sorted((a, b) -> b - a).forEach(System.out::println);

        // #distinct

        // List<Integer> number = Arrays.asList(10, 6, 9, 30, 30, 20, 30, 867);
        // number.stream().distinct().sorted().forEach(System.out::println);
        // # limit(n) // # skip(n)
        // List<Integer> number = Arrays.asList(10, 6, 9, 30, 30, 20, 30, 867);
        // number.stream()
        // .skip(8)
        // .limit(5)
        // .forEach(System.out::println);

        // #collect
        // List<Integer> number = Arrays.asList(10, 6, 9, 15, 35, 20, 37, 867);
        // List<Integer> result = number.stream()
        // .sorted()
        // .distinct()
        // .collect(Collectors.toList());
        // System.out.println(result);
        // #anyMatch() ,allMatch(),nodeMatch()
        // List<Integer> number = Arrays.asList(10, 6, 9, 15, 35, 20, 37, 867);

        // boolean hasEven = number.stream().anyMatch(n -> n % 2 == 0);
        // boolean allEven = number.stream().allMatch(n -> n % 2 == 0);
        // boolean noneEven = number.stream().noneMatch(n -> n % 2 == 0);

        // System.out.println("Has Even " + hasEven);
        // System.out.println("AllEven" + allEven);
        // System.out.println("None Even " + noneEven);
        // #findFirst(), findAny ()

        // List<Integer> number = Arrays.asList(10, 6, 9, 15, 35, 20, 37, 867);
        // Optional<Integer> firstEven = number.stream()
        // .filter(n -> n % 2 == 0)
        // .findFirst();

        // firstEven.ifPresent(System.out::println);

        // #count()
        List<Integer> number = Arrays.asList(10, 6, 9, 15, 35, 20, 37, 867);
        long evenCount = number.stream()
                .filter(n -> n % 2 == 0)
                .count();
        System.out.println(evenCount);
    }

}