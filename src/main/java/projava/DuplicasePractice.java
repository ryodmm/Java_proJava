package projava;

import java.util.Arrays;
public class DuplicasePractice {
    public static void main(String[] args) {
        var data = new int[]{3, 6, 9, 4, 2, 1, 5};

        var result = new int[data.length];
        for (int i = 0; i < data.length; ++i) {
            if (i < data.length - 1) {
                result[i] = Math.max(data[i], data[i + 1]);
            } else {
                // 最後の要素
                result[i] = data[i];
            }
        }

        System.out.println(Arrays.toString(data));
        System.out.println(Arrays.toString(result));
    }
}
