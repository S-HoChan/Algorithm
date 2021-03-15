package ProgrammersLevel3;

public class PedestrianHeaven {
    public static void main(String[] args) {

    }

    int MOD = 20170805;
    public int solution(int m, int n, int[][] cityMap) {
        int[][] map = new int[m][n];
        map[0][0] = 1;

        for (int y = 0; y < m; y++) {
            for (int x = 0; x < n; x++) {
                if (x == 0 && y == 0) continue;
                if (cityMap[y][x] == 1) {   // 차가 못가는 지점
                    map[y][x] = 0;
                    continue;
                }

                if (y == 0) {   // 끄트머리 처리
                    map[y][x] = map[y][x - 1];
                    continue;
                } else if (x == 0) {
                    map[y][x] = map[y - 1][x];
                    continue;
                }

                // 여기서부터 시작
                if (cityMap[y - 1][x] == 2) {   // 위가 2일때
                    int dy = y - 1;
                    while (dy > 0) {    // 2가 끝나는 지점 탐색
                        if (cityMap[dy][x] == 2) dy--;
                        else break;
                    }
                    if (!(dy == 0 && cityMap[dy][x] == 2)) map[y][x] += map[dy][x] % MOD;   // 2가 끝나는 지점의 경우의 수 합해주기
                }
                if (cityMap[y][x - 1] == 2) {   // 왼쪽이 2일때 동일하게 동작
                    int dx = x - 1;
                    while (dx > 0) {
                        if (cityMap[y][dx] == 2) dx--;
                        else break;
                    }
                    if (!(dx == 0 && cityMap[y][dx] == 2)) map[y][x] += map[y][dx] % MOD;
                }

                // 평범한 상황
                if (cityMap[y - 1][x] == 0) map[y][x] += map[y - 1][x] % MOD;
                if (cityMap[y][x - 1] == 0) map[y][x] += map[y][x - 1] % MOD;
            }
        }

        return map[m - 1][n - 1] % MOD;
    }
}
