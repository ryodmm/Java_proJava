package projava;

public class InsutancsMethodSample {

        record Student(String name,  int englishScore, int mathScore){
            public int maxScore() {
        return Math.max(englishScore(), mathScore());
            }
        } // --1

        record Student2(String name,  int englishScore, int mathScore){ // --2
            int average(){
                return (this.englishScore() + this.mathScore()) / 2;
            }
        }

        // 練習問題
        record StudentA(String name,  int englishScore, int mathScore) {
            int average(){
                return (englishScore() + mathScore()) / 2;
            }
        }

        public static void main(String[] args) {

            //averageメゾッドに変数kisを渡す  --1
            var kis = new Student("kis", 60, 80);
            var a = average(kis);
            System.out.println("平均点%d点です".formatted(a));

            //kisの最高得点を出力
            int max = kis.maxScore();
            System.out.println("最高点は%d点です".formatted(max));

            //kisのaverageメゾッドを呼び出す　--2
            var kis2 = new Student2("kis2", 40, 80);
            var b = kis2.average();
            System.out.println("平均点%d点です".formatted(b));

            // 練習問題
            var hanako = new StudentA("hanako", 90, 80);
            var c = hanako.average();
            System.out.println(hanako.name() + "さんの平均点は%d点です".formatted(c));

        }
        static int average(Student s) {  //--1
            return (s.englishScore() + s.mathScore()) / 2;
        }
    }
