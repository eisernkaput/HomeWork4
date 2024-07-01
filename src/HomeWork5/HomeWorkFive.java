package HomeWork5;

import Entities.Author;
import Entities.Book;
import Entities.Client;
import Entities.Product;
import Util.Gender;
import Util.MyDate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class HomeWorkFive {

    public static void firstTask() {
        int sumOfRange = IntStream.range(1, 201).filter(value -> value % 2 == 0).sum();
        System.out.println(sumOfRange);
    }

    public static void secondTask() {
        List<String> stringList = new ArrayList<>();
        stringList.add("1324");
        stringList.add("542");
        stringList.add("1324");
        stringList.add("48nxgfh");
        stringList.add("bob");
        stringList.add("542");
        System.out.println(uniqueValues(stringList));

        List<Integer> intList = new ArrayList<>();
        intList.add(1);
        intList.add(4641894);
        intList.add(547);
        intList.add(12);
        intList.add(47);
        intList.add(12);
        intList.add(1);
        intList.add(547);
        System.out.println(uniqueValues(intList));

        List<Client> clientList = new ArrayList<>();
        clientList.add(new Client("1", "Vova", "Vovanovich", "Vovanski", Gender.MALE, new MyDate(1990, 12, 16)));
        clientList.add(new Client("2", "Masha", "Vovanovna", "Vovanski", Gender.FEMALE, new MyDate(1992, 7, 25)));
        clientList.add(new Client("2", "Masha", "Vovanovna", "Vovanski", Gender.FEMALE, new MyDate(1992, 7, 25)));
        clientList.add(new Client("3", "Barsik", null, "Vovanski", Gender.MALE, new MyDate(2015, 1, 1)));

        System.out.println(uniqueValues(clientList));
    }

    private static <T> List<T> uniqueValues(List<T> inputList) {
        return inputList.stream().sorted().distinct().toList();
    }

    public static void thirdTask() {
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book("1", "Codex chesti", new Author("1", "M.Kulchitskiy"), 150));
        bookList.add(new Book("2", "War and peace", new Author("2", "Tolstoy"), 10000));
        bookList.add(new Book("3", "End and Death pt.1", new Author("3", "D.Abnett"), 2500));
        bookList.add(new Book("4", "End and Death pt.2", new Author("3", "D.Abnett"), 2648));
        bookList.add(new Book("5", "End and Death pt.3", new Author("3", "D.Abnett"), 3125));


        organizeBooks(bookList).forEach((k, v) -> System.out.println("key: " + k + ", value: " + v));
    }

    private static Map<String, Book> organizeBooks(List<Book> books) {
        return books.stream().collect(Collectors.toMap(Book::getId, Function.identity()));
    }

    public static void forthTask() {
        List<String> stringList = List.of("one", "два", "собака", "жаба", "какие-то стримы");

        System.out.println(stringList.stream().map(String::toUpperCase).collect(Collectors.joining(",")));
    }

    public static void fifthTask() {
        List<Product> productList = List.of(
                new Product("Bread", 32.5, 50),
                new Product("Butter", 125.1, 40),
                new Product("Salt", 26.8, 70),
                new Product("HD XL1200 Roadster", 1_200_000.999, 1)
        );

        double sumOfProducts = productList.stream().mapToDouble(value -> value.getPrice() * value.getQuantity()).sum();
        System.out.println(sumOfProducts);
    }

    public static void sixthTask() {
        List<Book> bookList = new ArrayList<>();
        Author abnett = new Author("3", "D.Abnett");
        Author tolstoy = new Author("2", "Tolstoy");

        bookList.add(new Book("1", "Codex chesti", new Author("1", "M.Kulchitskiy"), 150));

        bookList.add(new Book("2", "War and peace pt.1", tolstoy, 10000));
        bookList.add(new Book("2", "War and peace pt.2", tolstoy, 10000));

        bookList.add(new Book("3", "End and Death pt.1", abnett, 2500));
        bookList.add(new Book("4", "End and Death pt.2", abnett, 2648));
        bookList.add(new Book("5", "End and Death pt.3", abnett, 3125));

        Author mostProlificAuthor = findAuthorOfTheLargestNumOfBooks(bookList);
        System.out.println(mostProlificAuthor);
    }

    private static Author findAuthorOfTheLargestNumOfBooks(List<Book> books) {
        return books.stream().collect(Collectors.groupingBy(Book::getAuthor, Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue()).orElseThrow().getKey();
    }

    public static void seventhTask() {
        List<String> inputText = Arrays.asList(
                "No one would have believed in the last years of the nineteenth century that this world was being watched keenly and closely by intelligences greater than man’s and yet as mortal as his own;",
                "that as men busied themselves about their various concerns they were scrutinised and studied, perhaps almost as narrowly as a man with a microscope might scrutinise the transient creatures that swarm and multiply in a drop of water.",
                "With infinite complacency men went to and fro over this globe about their little affairs, serene in their assurance of their empire over matter.",
                "It is possible that the infusoria under the microscope do the same.",
                "No one gave a thought to the older worlds of space as sources of human danger, or thought of them only to dismiss the idea of life upon them as impossible or improbable.",
                "It is curious to recall some of the mental habits of those departed days.",
                "At most terrestrial men fancied there might be other men upon Mars, perhaps inferior to themselves and ready to welcome a missionary enterprise.",
                "Yet across the gulf of space, minds that are to our minds as ours are to those of the beasts that perish, intellects vast and cool and unsympathetic, regarded this earth with envious eyes, and slowly and surely drew their plans against us.",
                "And early in the twentieth century came the great disillusionment."
        );

        System.out.println(frequencyTextAnalyze(inputText));

    }

    private static List<String> frequencyTextAnalyze(List<String> inputText) {
        return inputText.stream().map(String::toLowerCase).map(s -> s.split(" ")).map(Arrays::asList)
                .flatMap(strings -> strings.stream().map(s -> s.replaceAll("[^a-zA-Z]+", "")))
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()))
                .entrySet().stream().sorted(Map.Entry.comparingByValue()).map(Map.Entry::getKey).toList().reversed();
    }
}
