package projava;
public class SwichSample {
    public static void main(String[] args) {
        var a = 5;
        //判定に指定できるのは整数か文字列、もしくはenum
        //default句は全てのcase句の後に書く
        switch (a) {
            case 1:
            case 2:
                System.out.println("one-two");
                break;
            case 3:
                System.out.println("three");
                break;
            case 4:
                System.out.println("four");
                break;
            case 5:
                System.out.println("five");
                break;
            default:
                System.out.println("other");
                break;
        }
    }
}
