package ProgrammersLevel4;

public class BlockGame {
    int[][] map;
    int n;

    public int solution(int[][] board) {    // todo. 정확성
        // todo. 반례
        // 1 0 0 2
        // 1 2 2 2
        // 1 1 0 0
        int answer = 0;
        map = board;
        n = map.length;

        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                if (map[y][x] == 0) continue;

                if (isA(y, x)) {
                    if (canRemove(y, x + 1, map[y][x]) && canRemove(y, x + 2, map[y][x])) {
                        map[y][x] = 0;
                        map[y + 1][x] = 0;
                        map[y + 1][x + 1] = 0;
                        map[y + 1][x + 2] = 0;
                        answer++;
                    }
                } else if (isB(y, x)) {
                    if (canRemove(y + 1, x - 1, map[y][x])) {
                        map[y][x] = 0;
                        map[y + 1][x] = 0;
                        map[y + 2][x - 1] = 0;
                        map[y + 2][x] = 0;
                        answer++;
                    }
                } else if (isC(y, x)) {
                    if (canRemove(y + 1, x + 1, map[y][x])) {
                        map[y][x] = 0;
                        map[y + 1][x] = 0;
                        map[y + 2][x] = 0;
                        map[y + 2][x + 1] = 0;
                        answer++;
                    }
                } else if (isD(y, x)) {
                    if (canRemove(y, x - 2, map[y][x]) && canRemove(y, x - 1, map[y][x])) {
                        map[y][x] = 0;
                        map[y + 1][x - 2] = 0;
                        map[y + 1][x - 1] = 0;
                        map[y + 1][x] = 0;
                        answer++;
                    }
                } else if (isE(y, x)) {
                    if (canRemove(y, x - 1, map[y][x]) && canRemove(y, x + 1, map[y][x])) {
                        map[y][x] = 0;
                        map[y + 1][x - 1] = 0;
                        map[y + 1][x] = 0;
                        map[y + 1][x + 1] = 0;
                        answer++;
                    }
                }
            }
        }

        return answer;
    }

    // A    B   C   D   E
    // oxx  xo  ox  xxo xox
    // ooo  xo  ox  ooo ooo
    //      oo  oo
    private boolean isA(int y, int x) {
        int block = map[y][x];
        if (y + 1 >= n || x + 2 >= n) return false;
        return map[y + 1][x] == block && map[y + 1][x + 1] == block && map[y + 1][x + 2] == block;
    }

    private boolean isB(int y, int x) {
        int block = map[y][x];
        if (y + 2 >= n || x - 1 < 0) return false;
        return map[y + 2][x - 1] == block && map[y + 2][x] == block && map[y + 1][x] == block;
    }

    private boolean isC(int y, int x) {
        int block = map[y][x];
        if (y + 2 >= n || x + 1 >= n) return false;
        return map[y + 2][x + 1] == block && map[y + 2][x] == block && map[y + 1][x] == block;
    }

    private boolean isD(int y, int x) {
        int block = map[y][x];
        if (y + 1 >= n || x - 2 < 0) return false;
        return map[y + 1][x] == block && map[y + 1][x - 1] == block && map[y + 1][x - 2] == block;
    }

    private boolean isE(int y, int x) {
        int block = map[y][x];
        if (y + 1 >= n || x - 1 < 0 || x + 1 >= n) return false;
        return map[y + 1][x] == block && map[y + 1][x + 1] == block && map[y + 1][x - 1] == block;
    }

    private boolean canRemove(int y, int x, int block) {
        for (int yy = 0; yy < y; yy++) {
            if (map[yy][x] == 0) continue;
            if (map[yy][x] != block) return false;
        }
        return true;
    }
}
