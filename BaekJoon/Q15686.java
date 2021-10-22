package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q15686 {   // 치킨 배달
    static int m;
    static int minDist = Integer.MAX_VALUE;
    static int[][] map;
    static ArrayList<int[]> chickens = new ArrayList<>();
    static ArrayList<int[]> houses = new ArrayList<>();
    static Stack<int[]> selectedChickens = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 1) {
                    houses.add(new int[]{i, j});
                } else if (map[i][j] == 2) {
                    chickens.add(new int[]{i, j});
                }
            }
        }

        solution(0, 0);
        System.out.println(minDist);
    }

    static void solution(int start, int cnt) {
        if (cnt == m) { // m개 선택 시 거리계산
            int sum = 0;
            for (int[] house : houses) {
                int min = Integer.MAX_VALUE;
                for (int[] chicken : selectedChickens) {
                    int dist = Math.abs(house[0] - chicken[0]) + Math.abs(house[1] - chicken[1]);
                    min = Math.min(min, dist);
                }
                sum += min;

                if (sum > minDist) break;
            }
            minDist = Math.min(minDist, sum);
            return;
        }

        for (int i = start; i < chickens.size(); i++) {
            selectedChickens.push(chickens.get(i));
            solution(i + 1, cnt + 1);
            selectedChickens.pop();
        }
    }
}
