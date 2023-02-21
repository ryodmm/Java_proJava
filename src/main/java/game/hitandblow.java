package game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class hitandblow {
    public static void main(String[] args) {

        //配列を作成
        int[] number = {1, 2, 3, 4, 5, 6};
        //最大チャレンジ回数
        int maxPlay = 8;

        System.out.println("使う数字は" + Arrays.toString(number) + "の" + number.length + "種類です。");
        System.out.println("同じ数字は使えません（例:1212, 1223など）");
        System.out.println(maxPlay + "回以内に正解してください。");
        System.out.println("(* * * *)");
        // 配列の中身をシャッフル
        for (int i = number.length - 1; i > 0; i--) {
            int r = (int) (Math.random() * (i + 1));
            int tmp = number[i];
            number[i] = number[r];
            number[r] = tmp;
        }

        int playNumber = 4;     //桁数決め
        int[] answer = new int[playNumber];
        if (number[0] == 0) {
            for (int i = 0; i < answer.length; i++) {
                answer[i] = number[i + 1];
            }
        } else {
            for (int i = 0; i < answer.length; i++) {
                answer[i] = number[i];
            }
        }

        System.out.println();

        // hit blow countの初期化
        int hit = 0;
        int blow = 0;
        int count = 0;

        boolean gameFlag = false;

        //数字が一致（hit=playNumber）またはcountが任意の数値になるまで繰り返す
        while (!gameFlag) {
            hit = 0;
            blow = 0;
            int[] userNumArray = new int[playNumber];

            //　入力チェック用変数　validCheck
            boolean validCheck = false;
            while (!validCheck) {   //入力チェック開始
                try {
                    //任意の数字をコンソールより取得
                    BufferedReader a = new BufferedReader(new InputStreamReader(System.in));
                    int[] inNum = new int[playNumber];

                    //　受け取った値をbへ代入
                    String b = a.readLine();
                    //  受け取った値をnへ代入
                    int n = Integer.parseInt(b);
                    //受け取った値の最初の1文字をstrへ代入
                    String zeroCheck = b.substring(0, 1);
                    //桁数をdigitsへ代入
                    int digits = Integer.toString(n).length();

                    //取得した整数を配列化するBeArrayメソッドを実行
                    beArray(inNum, n);

                    //受け取った値の桁数をdigitsへ代入
                    digits = Integer.toString(n).length();

                    if (zeroCheck.equals("0")) {
                        System.out.println(digits + ":" + playNumber);
                        System.out.println("先頭の数字に0は入力できません");
                    } else if (digits != playNumber) {
                        if (digits < playNumber || n < Math.pow(10, playNumber - 1)) {   //桁チェック
                            System.out.println(digits);
                            System.out.println("桁数が小さいです、" + playNumber + "桁の数字を入力し直してください");
                        } else if (digits > playNumber) {
                            System.out.println("桁が多すぎます、" + playNumber + "桁の数字を入力してください");
                        }
                    } else if (duplicateCheck(inNum)) { //同じ数字が使われていた場合
                        System.out.println("同じ数字が使われています");
                    } else {
                        validCheck = true;
                        userNumArray = inNum;
                    }
                } catch (IOException e) {
                    System.out.println(e);
                } catch (NumberFormatException o) {
                    System.out.println("数字以外のものが入力されています");
                } catch (ArrayIndexOutOfBoundsException f) {
                    System.out.println(f);
                }
            }   //入力チェック終了

            //hit, blowの数算出開始
            for (int i = 0; i < playNumber; i++) {
                if (answer[i] == userNumArray[i]) {
                    hit++;
                }
            }

            for (int i = 0; i < playNumber; i++) {
                for (int k = 0; k < playNumber; k++) {
                    if (answer[i] == userNumArray[k]) {
                        blow++;
                    }
                }
            }

            //hit and blow 算出終了
            if (hit == playNumber) {
                System.out.println("4HIT! 正解です!");
                System.out.println("入力回数は" + count + "回でした");
                gameFlag = true;
            } else {    //hit4でない場合hit&blowの数値を返す処理
                System.out.println(hit + "Hit " + (blow - hit) + "Blow");
                count++;    //入力回数カウントする
            }

            if (count == maxPlay) {
                System.out.println("入力回数が" + maxPlay + "になりました。ゲームオーバーです");
                gameFlag = true;
            }

        }//数字が一致（hit=playNumber）まで繰り返すの終了地点
    }

    //文字重複チェックメソッド
    public static boolean duplicateCheck(int[] inNum) {
        int duplicate = 0;
        for (int i = 0; i < inNum.length; i++) {
            for (int k = 0; k < inNum.length; k++) {
                if (k != i && inNum[k] == inNum[i]) {
                    duplicate++;
                }
            }
        }
        return duplicate >= 2;
    }

    // beArrayメソッド
    //配列inNumへ入力された値を１つずつ配列へ格納する
    //parameter
    // inNum 入力をいれる配列
    // n 入力された値
    public static void beArray(int[] inNum, int n) {
        for (int j = inNum.length - 1; j >= 0; j--) {
            int d = n / 10;
            int k = n - d * 10;
            n = d;
            inNum[j] = k;
        }
    }
}
