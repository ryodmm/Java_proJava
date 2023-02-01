package projava;

public class Duplicase2 {
    public static void main(String[] args) {
        var data = "abcccbaabcc";

        char prev = 0;
        var builder = new StringBuilder();

        //　拡張for文
        for (char ch : data.toCharArray()) {
            if(ch == prev){
                continue;
            }
            builder.append(ch);
            prev = ch;
        }
        var result = builder.toString();
        System.out.println(data);
        System.out.println(result);
    }
}
