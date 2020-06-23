import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Calculator {

    public static Map<String, Long> wordcount1 = Files.lines(Paths.get("plik"))
            .flatMap(line -> Stream.of(line.split(" ")))
            .map(String::toLowerCase)
            .collect(Collectors.groupingBy(
                    word -> word,
                    Collectors.counting()
            ));

    public static Map<Character, Long> wordcount2(String userInput) {
        return userInput.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }
    public static Map<Character, Long> wordcount3(String userInput) {
        return userInput.chars().mapToObj(d -> (char) d).map(s-> (char)s)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }
}
