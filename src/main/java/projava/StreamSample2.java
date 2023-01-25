package projava;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamSample2 {
    public static void main(String[] args) {
        var data = List.of("yamamoto", "kis", "sugiyama");

        var result = (int) data.stream()        //Streamソース
                .filter(s -> s.length() >= 5)   //中間処理
                .count();                       //最終処理
        System.out.println(result);


        var strs = List.of("apple", "banana", "orange", "pineapple");
        var result2 = strs.stream().
                noneMatch(s -> s.contains("c"));

        System.out.println(result2);
    }
}
