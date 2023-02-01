package projava;

public class RunLengthCompression {
    public static void main(String[] args) {
        // −１を基準となる数値として扱う
        // finalを変数の宣言につけると変更のできない変数となる（定数）
        final var COUNTER_BASE = -1;
        var data = "abbcccbaaaabccccccccccccddd";

        var count = COUNTER_BASE;
        char prev = 0;
        var builder = new StringBuilder();
        // １文字づつ処理するループ
        for (var ch : data.toCharArray()) {
            // おなじ文字がつづくとき変数countの値を増やす
            if (prev == ch) {
                count++;
                //countが9まできたら、9を出力
                if (count == 9) {
                    builder.append('9');
                    // 9の後は改めて出力するので変数countをCOUNTER_BASEに、１つ前の文字を０にする
                    count = COUNTER_BASE;
                    prev = 0;
                }
                //違う文字がきた時の処理
            } else {
                // 変数countの値が０以上であれば、直前に同じ文字が続いてたことになり、数字を追加する
                // countの値はCOUNTER_BASEに戻す
                if (count >= 0) {
                    builder.append((char) ('0' + count));
                    count = COUNTER_BASE;
                }
                // 現在の文字をbuilderに追加して、１つ前の文字として
                // 現在の文字を変数prevに割り当てる
                builder.append(ch);
                prev = ch;
            }
        }
        // ループを抜けた時に最後の文字が連続していれば吸うぞ出力します。
        if (count >= 0){
            builder.append((char)('0' + count));
        }
        var result = builder.toString();
        System.out.println(data);
        System.out.println(result);
    }
}

