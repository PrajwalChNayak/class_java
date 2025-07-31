package myclass;

import java.time.LocalDate;

public class Prd {

    // # Predicat boolean test()
    // #Function apply()
    // #Consumer void accept()
    // #Supplie get()

    public static void main(String args[]) {
        // # Predicat
        // Predicate<Integer> isEven = n -> n % 2 == 0;
        // Predicate<Integer> isOdd = n -> n % 2 != 0;

        // List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // nums.stream()
        // .filter(isEven)
        // .forEach(System.out::println);

        // #Function
        // List<String> name = Arrays.asList("Person1", "Person123");

        // Function<String, Integer> lengthFinder = s -> s.length();

        // name.stream()
        // .map(lengthFinder)
        // .forEach(System.out::println);

        // #Consumer
        // List<String> name = Arrays.asList("Person1", "Person123", "Person3");
        // Consumer<String> printer = s -> System.out.println("Value => " + s);

        // name.stream()
        // .forEach(printer);

        // Supplier<Double> randomNSupplier = () -> Math.random();

        // System.out.println("Random => " + randomNSupplier.get());

        // # Optional
        // if(obj !=null ){

        // }
        // #isPresent() -> boolean
        // #get()
        // #orElse(defaultValue)
        // #orElseGet(supplier)
        // #isPresent(consumer)
        // #filter(predicate)
        // #map(function)

        // Optional<String> name = Optional.of("Person");

        // Optional<String> nameWithNull = Optional.ofNullable(null);

        // if (name.isPresent()) {
        // System.out.println("Name" + name.get());
        // }

        // System.out.println("MayBeName" + nameWithNull.orElse("Unknown"));

        // Optional<Integer> age = Optional.ofNullable(null);

        // Optional<Integer> adultAge = age.filter(a -> a > 18);

        // System.out.println("Adult Age => " + adultAge.orElse(0));

        // Optional<String> ageString = age.map(a -> "Age => " + a);

        // System.out.println(ageString.orElse("No age "));

        // #Data time

        // java.util.Date

        // # LocalData ,LocalDateTime,
      //#  Period 2 yesr ,3 month ,4 day  , Duration -> 5 hr 

        // # LocalData -> year - month -day
        // # now(), of(year,month,day),plusDays(days)/minusDays(days)
        // #getYear(),getMonthValue(),getDayOdMonth() ,isBefore(other),isAfter(other),
        // format(formatter)

        LocalDate today = LocalDate.now();
        System.out.println("TodayDate=> " + today);

        LocalDate birthDate = LocalDate.of(2000, 1, 1);
        System.out.println("BirthDate => " + birthDate);

        LocalDate nextWeekDate = today.plusDays(7);
        System.out.println("Next Week => " + nextWeekDate);

        System.out.println(birthDate.isBefore(today));

    }

}