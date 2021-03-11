package ProgrammersLevel3;

public class SharedTaxiFare {
    public static void main(String[] args) {

    }

    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        int[][] map = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                map[i][j] = 200 * 100000 + 1;   // max
            }
            map[i][i] = 0;
        }

        for (int[] fare : fares) {
            map[fare[0]][fare[1]] = fare[2];
            map[fare[1]][fare[0]] = fare[2];
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    if (map[j][k] > map[j][i] + map[i][k]) {
                        map[j][k] = map[j][i] + map[i][k];
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            answer = Math.min(answer, map[s][i] + map[i][a] + map[i][b]);
        }

        return answer;
    }
}
