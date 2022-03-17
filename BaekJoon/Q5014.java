package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Q5014 {    // 스타트링크
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int f = Integer.parseInt(st.nextToken());   // floor
        int s = Integer.parseInt(st.nextToken());   // start
        int g = Integer.parseInt(st.nextToken());   // goal
        int u = Integer.parseInt(st.nextToken());   // up
        int d = Integer.parseInt(st.nextToken());   // down
        boolean[] visited = new boolean[f + 1];
        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(new int[]{s, 0});
        visited[s] = true;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            if (now[0] == g) {
                System.out.println(now[1]);
                return;
            }

            int up = now[0] + u, down = now[0] - d;
            if (up >= 1 && up <= f && !visited[up]) {
                queue.add(new int[]{up, now[1] + 1});
                visited[up] = true;
            }
            if (down >= 1 && down <= f && !visited[down]) {
                queue.add(new int[]{down, now[1] + 1});
                visited[down] = true;
            }
        }
        System.out.println("use the stairs");
    }
}
