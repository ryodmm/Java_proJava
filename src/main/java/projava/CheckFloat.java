package projava;

public class CheckFloat {

    enum FloatState{
        START, INT, FRAC_START, FRAC, FRAC_END, MINUS, ZERO      //FRAC == 少数部を表すfractionの略
    }

    static boolean check(String data) {
        var state = FloatState.START;
        for (char ch : data.toCharArray()) {
            switch (state) {
                case START -> { //開始
                    if (ch == '0') {
                        state = FloatState.ZERO;
                    } else if (ch >= '1' && ch <= '9') {
                        state = FloatState.INT;
                    } else if (ch == '-'){
                        state = FloatState.MINUS;
                    } else {
                        return false;
                    }
                }
                case ZERO -> { //頭のゼロ
                    if (ch == '.'){
                        state = FloatState.FRAC_START;
                    } else {
                        return false;
                    }
                }
                case INT -> {//整数部
                    if (ch >= '0' && ch <= '9') {
                        state = FloatState.INT;
                    } else if (ch == '.') {
                        state = FloatState.FRAC_START;
                    } else {
                        return false;
                    }
                }
                case MINUS -> {// 負の整数部
                    if (ch != '-') {
                        state = FloatState.INT;
                    } else if (ch == '.') {
                        state = FloatState.FRAC_START;
                    } else {
                        return false;
                    }
                }
                case FRAC_START, FRAC, FRAC_END -> { // 少数部かつ最後が０だとfalse
                    if (ch >= '0' && ch <= '9' && ch != '0') {
                        state = FloatState.FRAC;
                    } else {
                        return false;
                    }
                }
            }
        }
        return switch (state) {
            case ZERO, INT, FRAC -> true;
            default -> false;
        };
    }

    public static void main(String[] args) {
        // default false
        System.out.println(check(""));          //false↓
        System.out.println(check("012"));
        System.out.println(check(".12"));
        System.out.println(check("12."));
        System.out.println(check("1.2.3"));
        System.out.println(check("1..3"));
        System.out.println("_____");
        // 少数部ラスト０ false
        System.out.println(check("12.30"));
        System.out.println(check("12.0"));
        System.out.println("_____");
        // マイナスのデフォルトfalse
        System.out.println(check("--123"));
        System.out.println(check("-12-3"));
        System.out.println("_____");

        System.out.println(check("0"));         //true↓
        System.out.println(check("-12"));
        System.out.println(check("-1"));
        System.out.println(check("12.3"));
        System.out.println(check("0.3"));

    }

}
