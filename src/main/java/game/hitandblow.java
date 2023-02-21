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

        //数値の桁数を取得
        int num2 = 1234;
        int len = Integer.toString(num2).length();
        System.out.println(len);

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

        //　取得した数値が０か確認する
        String str = "0123";
        String str2 = str.substring(0, 1);
        if (str2.equals("0")) {
            System.out.println("start0");
        } else {
            System.out.println("not0");
        }
    }
}
