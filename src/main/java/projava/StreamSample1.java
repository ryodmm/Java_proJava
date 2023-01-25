package projava;

import java.util.ArrayList;
import java.util.List;

public class StreamSample1 {
    public static void main(String[] args) {
        var data = List.of("yamamoto", "kis", "sugiyama");

        var result = new ArrayList<String>();
        for (var s : data){
            if (s.length() >= 5){
                result.add(s);
            }
        }
        System.out.println(result);
    }
}
