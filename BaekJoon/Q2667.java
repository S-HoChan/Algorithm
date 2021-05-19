package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Q2667 {    // 단지번호붙이기
    static int n;
    static int[][] map;
    static StringBuilder sb = new StringBuilder();
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        int town = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1) {
                    count = 1;
                    map[i][j] = 0;
                    sol(i, j);
                    pq.add(count);
                    town++;
                }
            }
        }

        System.out.println(town);
        while(!pq.isEmpty()){
            sb.append(pq.poll()).append('\n');
        }
        System.out.println(sb);
    }

    private static void sol(int i, int j) {
        for (int k = 0; k < 4; k++) {
            int y = i + dy[k];
            int x = j + dx[k];
            if (y >= 0 && y < n && x >= 0 && x < n && map[y][x] == 1) {
                map[y][x] = 0;
                count++;
                sol(y, x);
            }
        }
    }
}
