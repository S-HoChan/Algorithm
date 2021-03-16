package ProgrammersLevel3;

public class WayToSchool {
    public int solution(int m, int n, int[][] puddles) {
        int[][] map = new int[n][m];
        map[0][0] = 1;

        for (int[] puddle : puddles) {
            map[puddle[1] - 1][puddle[0] - 1] = -1;    // '*' : 물
        }

        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                if (map[y][x] == -1) {
                    continue;
                }
                if (y != 0 && map[y - 1][x] >= 0) map[y][x] += map[y - 1][x] % 1000000007;
                if (x != 0 && map[y][x - 1] >= 0) map[y][x] += map[y][x - 1] % 1000000007;
            }
        }

        return map[n - 1][m - 1] % 1000000007;
    }
}
