package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Q2251 {    // 물통
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[3];
        for (int i = 0; i < 3; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        boolean[] answer = new boolean[201];
        int[] from = {0, 0, 1, 1, 2, 2};
        int[] to = {1, 2, 2, 0, 0, 1};
        boolean[][] visited = new boolean[201][201];
        LinkedList<int[]> queue = new LinkedList<>();   // a, b
        queue.add(new int[]{0, 0});
        visited[0][0] = true;
        answer[arr[2]] = true;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int a = now[0];
            int b = now[1];
            int c = arr[2] - a - b;
            for (int i = 0; i < 6; i++) {
                int[] next = {a, b, c};
                next[to[i]] += next[from[i]];
                next[from[i]] = 0;  // move
                if (next[to[i]] > arr[to[i]]) {   // overflow
                    next[from[i]] = next[to[i]] - arr[to[i]];
                    next[to[i]] = arr[to[i]];
                }

                if (!visited[next[0]][next[1]]) {
                    visited[next[0]][next[1]] = true;
                    queue.add(new int[]{next[0], next[1]});
                    if (next[0] == 0) answer[next[2]] = true;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= arr[2]; i++)
            if (answer[i]) sb.append(i).append(' ');
        System.out.println(sb);
    }
}
