package game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class hitandblow {
    public static void main(String[] args) throws IOException {
        // コンソールで入力した値を扱う
        /*
        BufferedReader i = new BufferedReader(new InputStreamReader(System.in));
        String a = i.readLine();
        System.out.println(a);

         */

        int[] num = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };

        // 配列の中身をシャッフル
        for (int j = num.length -1; j > 0; j--) {
            int r = (int) (Math.random() * (j + 1));
            int tmp = num[j];
            num[j] = num[r];
            num[r] = tmp;

            // シャッフル動作確認
            for (int check : num) {
                System.out.println(check);
            }
            System.out.println();
        }
    }
}
