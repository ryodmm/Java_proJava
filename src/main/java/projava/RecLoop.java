package projava;

public class RecLoop {
    public static void main(String[] args) {
        //loop(0);
        loop(3);
    }
    /*static void loop(int i){
        if(i >= 5){
            return;
        }
        System.out.println(i);
        loop(i + 1);
    }*/

    static void loop(int j){
        if(j <= 0){
            return;
        }
        System.out.println(j);
        loop(j - 1);
    }

}
