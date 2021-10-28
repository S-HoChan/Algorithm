package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Q11724 {   // 연결 요소의 개수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        boolean[][] map = new boolean[n][n];

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken()) - 1;
            int second = Integer.parseInt(st.nextToken()) - 1;
            map[first][second] = true;
            map[second][first] = true;
        }

        boolean[] connected = new boolean[n];
        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (connected[i]) continue;

            answer++;
            connected[i] = true;
            LinkedList<Integer> list = new LinkedList<>();
            list.add(i);
            while (!list.isEmpty()) {
                int now = list.poll();
                for (int j = 0; j < n; j++) {
                    if (now != j && !connected[j] && map[now][j]) {
                        connected[j] = true;
                        list.add(j);
                    }
                }
            }
        }

        System.out.println(answer);
    }
}
