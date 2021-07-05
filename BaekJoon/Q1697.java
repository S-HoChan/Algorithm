package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Q1697 {    // 숨바꼭질
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[100001];
        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(new int[]{n, 0});
        int ans = 0;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            if (now[0] < 0 || now[0] > 100000 || visited[now[0]]) continue;

            if (now[0] == k) {
                ans = now[1];
                break;
            } else {
                queue.add(new int[]{now[0] * 2, now[1] + 1});
                queue.add(new int[]{now[0] + 1, now[1] + 1});
                queue.add(new int[]{now[0] - 1, now[1] + 1});
            }
            visited[now[0]] = true;
        }

        System.out.println(ans);
    }
}
