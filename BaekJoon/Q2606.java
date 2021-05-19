package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2606 {    // 바이러스
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int t = Integer.parseInt(br.readLine());

        boolean[][] map = new boolean[n][n];
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            map[first - 1][second - 1] = true;
            map[second - 1][first - 1] = true;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        boolean[] visited = new boolean[n];
        visited[0] = true;
        int cnt = -1;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            cnt++;
            for(int i = 0; i < n; i++){
                if(visited[i]) continue;

                if(map[now][i]){
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }

        System.out.println(cnt);
    }
}
