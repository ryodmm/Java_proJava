package projava;

import java.util.List;

public class ForEachListSample {
    public static void main(String[] args) {
        //拡張for文
        var strs = List.of("apple", "banana", "grape");
        for (var str : strs) {
            System.out.println(str);
        }

        var names = List.of("yusuke", "kis", "sugiyama");
        for (var name : names) {
            System.out.println(name);
        }
    }
}
