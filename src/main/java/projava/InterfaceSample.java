package projava;

import java.util.List;
public class InterfaceSample {
    interface Named {
        String name();
    }

    interface Figure {
        int width();
        int height();
    }

    record Box(int width, int height) implements Figure{}
    record Oval(int width, int height) implements Figure{}
    record Student(String name, int score) implements Named {}
    record Teacher(String name, String subject) implements Named {}

    record Staff(String name, String job) implements Named {}

    static class Passenger implements Named{

        @Override  //インターフェースで定義されたメゾッドを実装することをオーバーライドという
        public String name() {
            return "通りすがり";
        }
    }

    public static void main(String[] args) {

        var people = List.of(
                new Student("kis", 80),
                new Teacher("hosoya", "Math"),
                new Passenger());

        for (Named p : people){
            var n = p.name();
            /*
            var n = p instanceof Student s ? s.name() :
                    p instanceof Teacher t ? t.name() :
                            "---";
             */
            System.out.println("こんにちは%sさん".formatted(n));
        }
    }
}
