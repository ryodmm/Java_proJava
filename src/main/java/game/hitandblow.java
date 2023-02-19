package game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class hitandblow {
    public static void main(String[] args) throws IOException {
        // コンソールで入力した値を扱う
        BufferedReader i = new BufferedReader(new InputStreamReader(System.in));
        String a = i.readLine();
        System.out.println(a);
    }
}
