package projava;

import java.util.ArrayDeque;

public class TraverseDeep3 {
    public static void main(String[] args) {
        int[][] map = {
                {1, 1, 1, 1, 1, 1, 1},
                {1, 0, 1, 0, 0, 0, 1},
                {1, 0, 0, 0, 1, 0, 1},
                {1, 0, 1, 0, 0, 2, 1},
                {1, 1, 1, 1, 1, 1, 1}
        };

        traverse(map, 1, 1);
        char[] ch = {'.', '*', 'G', 'o'};
        for (int[] row : map) {
            for (int cell : row) {
                System.out.print(ch[cell]);
            }
            System.out.println();
        }
    }

    // キューを使った処理

    static boolean traverse(int[][] map, int curX, int curY) {
        record Position(int x, int y){}

        var stack = new ArrayDeque<Position>();
        stack.push(new Position(curX, curY));
        for (Position p; (p = stack.pollLast()) != null ;) {
            switch (map[p.x][p.y]) {
                case 0: break;
                case 2: return true;
                default: continue;
            }
            map[p.x][p.y] = 3;
            stack.push(new Position(p.x() + 1, p.y()));
            stack.push(new Position(p.x() - 1, p.y()));
            stack.push(new Position(p.x(), p.y() + 1));
            stack.push(new Position(p.x(), p.y() + 1));
        }
        return true;
    }
}
