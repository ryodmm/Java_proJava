package projava;

import java.io.IOException;

public class Maze {
    public static void main(String[] args) throws IOException {
        record Position (int x, int y){}
        int[][] map = {
                {1, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 1, 0, 1, 0, 0, 1},
                {1, 0, 1, 0, 1, 1, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 1},
                {1, 1, 0, 1, 1, 0, 1, 1},
            {1, 0, 0, 0, 1, 0, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 1}
        };

        var current = new Position(1, 1);
        var upper = false;
        var goal = new Position(6, 5);

        for (;;) {
            // 迷路の表示
            // 現在位置と縦横２マスのみを表示させる
            for (int y = current.y() - 2; y <= current.y() + 2; ++y) {
                for (int x = current.x() - 2; x <= current.x() + 2; ++x) {
                    if (y < 0 || y >= map.length || x < 0 || x >= map[y].length) {
                        System.out.print("#");
                    }else if (x == current.x() && y == current.y()){
                        // upperがtrueであればO、falseであればoを表示する
                        System.out.print(upper ? "O" : "o");
                    } else if (map[y][x] == 1) {
                        System.out.print("*");
                    } else if (x == goal.x() && y == goal.y()) {
                        System.out.print("G");
                    } else {
                        System.out.print(".");
                    }
                }
                System.out.println();
            }
            //　ゴール判定
            if (current.equals(goal)){
                System.out.println("GOAL!!");
                break;
            }
            // キー入力処理
            int ch = System.in.read();
            // 入力なしにEnterを押したり２文字入力などをするとその後"o"が動かなくなるのを解消する
            if (ch == '\n') continue;
            // 押された方向の座標を得る
            var next = switch(ch) {
                case 'a' -> new Position(current.x()-1, current.y());
                case 'w' -> new Position(current.x(), current.y()-1);
                case 's' -> new Position(current.x()+1, current.y());
                case 'z' -> new Position(current.x(), current.y()+1);
                default -> current;
            };
            // 押された方向が通路なら進む
            if (map[next.y()][next.x()] == 0){
                // 移動するときにupperを反転する
                if (!current.equals(next)){
                    upper = !upper;
                }
                current = next;
            }
            // Enterキーの入力を捨てる
            System.in.read();
        }
    }
}
