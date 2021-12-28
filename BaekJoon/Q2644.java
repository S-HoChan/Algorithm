package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Q2644 {    // 촌수계산
    static int[] distance;
    static int n;
    static boolean[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new boolean[n][n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int person1 = Integer.parseInt(st.nextToken()) - 1;
        int person2 = Integer.parseInt(st.nextToken()) - 1;
        int m = Integer.parseInt(br.readLine());
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken()) - 1;
            int second = Integer.parseInt(st.nextToken()) - 1;
            map[first][second] = true;
            map[second][first] = true;
        }
        distance = new int[n];
        bfs(person1, person2);
        System.out.println(distance[person2] == 0 ? -1 : distance[person2]);
    }

    static void bfs(int start, int end) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            int now = queue.poll();
            if (now == end) break;

            for (int i = 0; i < n; i++) {
                if (map[now][i] && distance[i] == 0) {
                    distance[i] = distance[now] + 1;
                    queue.add(i);
                }
            }
        }
    }
}
