package projava;

import java.util.stream.IntStream;

public class MethodRefSample {
    public static void main(String[] args) {
        IntStream.range(0, 3)
                .map(MethodRefSample::twice)
                .forEach(System.out::println);
    }
    static int twice(int x){
        return x * 2;
    }
}
/*ラムダ式をメゾッドに参照
    引数　-> なにか.メゾッド（引数）
　　　　　　↓
    なにか::メゾッド
 */
/*インスタンスメゾッド呼び出しをメゾッド参照に変換
    引数　-> 引数.メゾッド（）
              ↓
    メゾッドの属するクラス名::メゾッド
 */