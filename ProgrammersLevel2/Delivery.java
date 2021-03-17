package ProgrammersLevel2;

public class Delivery {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        int[][] map = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) continue;
                map[i][j] = 500001;
            }
        }

        for (int[] r : road) {
            int a = r[0] - 1;
            int b = r[1] - 1;
            int c = r[2];
            if (map[a][b] > c) {
                map[a][b] = c;
                map[b][a] = c;
            }
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (i == j) continue;
                    if (map[i][j] > map[i][k] + map[k][j]) {
                        map[i][j] = map[i][k] + map[k][j];
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            if (map[0][i] <= K) answer++;
        }

        return answer;
    }
}
