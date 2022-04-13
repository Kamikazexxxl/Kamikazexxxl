package packaje;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamLearning {
    public static void main(String[] args) {
        List <String> stringList = new ArrayList<>();
        stringList.add("privet");
        stringList.add("kak");
        stringList.add("tvoi");
        stringList.add("dela");
        stringList.stream().sorted().collect(Collectors.toList());

    }
}