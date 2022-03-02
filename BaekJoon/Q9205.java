package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Q9205 {    // 맥주 마시면서 걸어가기
    static int[][] convenience;
    static int[] festival = new int[2];
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] home = new int[2];    // y, x : 0, 0
            home[0] = Integer.parseInt(st.nextToken());
            home[1] = Integer.parseInt(st.nextToken());

            convenience = new int[n][2];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                convenience[i][0] = Integer.parseInt(st.nextToken()) - home[0];
                convenience[i][1] = Integer.parseInt(st.nextToken()) - home[1];
            }

            st = new StringTokenizer(br.readLine());
            festival[0] = Integer.parseInt(st.nextToken()) - home[0];
            festival[1] = Integer.parseInt(st.nextToken()) - home[1];

            sb.append(bfs(convenience) ? "happy" : "sad");
            sb.append('\n');
        }

        System.out.println(sb);
    }

    static boolean bfs(int[][] convenience) {
        LinkedList<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        queue.add(new int[]{0, 0});  // home
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            if (distance(now, festival) <= 1000) return true;

            for (int i = 0; i < n; i++) {
                if (!visited[i] && distance(now, convenience[i]) <= 1000) {
                    visited[i] = true;
                    queue.add(convenience[i]);
                }
            }
        }
        return false;
    }

    static int distance(int[] o1, int[] o2) {
        return Math.abs(o1[0] - o2[0]) + Math.abs(o1[1] - o2[1]);
    }
}
