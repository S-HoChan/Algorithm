package ProgrammersLevel2;

public class Friends4Blocks {
    static int[] dy = {0, 0, 1, 1};
    static int[] dx = {0, 1, 0, 1};

    public int solution(int m, int n, String[] board) {
        int answer = 0;
        char[][] map = new char[m][n];

        for (int i = 0; i < m; i++) {
            map[i] = board[i].toCharArray();
        }

        while (true) {
            int cnt = checkBlock(m, n, map);
            if (cnt == 0) break;
            answer += cnt;

            dropBlock(m, n, map);
        }

        return answer;
    }

    public void dropBlock(int m, int n, char[][] map) {
        for (int x = 0; x < n; x++) {
            for (int y = m - 1; y >= 0; y--) {
                if (map[y][x] == '.') {
                    for (int _y = y - 1; _y >= 0; _y--) {
                        if(map[_y][x] != '.'){
                            map[y][x] = map[_y][x];
                            map[_y][x] = '.';
                            break;
                        }
                    }
                }
            }
        }
    }

    public int checkBlock(int m, int n, char[][] map) {
        int cnt = 0;
        boolean[][] isChecked = new boolean[m][n];

        for (int y = 0; y < m - 1; y++) {
            for (int x = 0; x < n - 1; x++) {
                if (map[y][x] == '.') continue;
                checkFour(map, isChecked, y, x);
            }
        }

        for (int y = 0; y < m; y++) {
            for (int x = 0; x < n; x++) {
                if (isChecked[y][x]) {
                    cnt++;
                    map[y][x] = '.';
                }
            }
        }

        return cnt;
    }

    public void checkFour(char[][] map, boolean[][] isChecked, int y, int x) {
        char block = map[y][x];

        for (int i = 0; i < 4; i++) {
            int _y = y + dy[i];
            int _x = x + dx[i];
            if (map[_y][_x] != block) return;
        }

        for (int i = 0; i < 4; i++) {
            int _y = y + dy[i];
            int _x = x + dx[i];
            isChecked[_y][_x] = true;
        }
    }
}
