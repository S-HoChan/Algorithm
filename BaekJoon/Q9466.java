package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q9466 {    // 텀 프로젝트
    static int n, cnt;
    static int[] arr;
    static boolean[] visited, finished;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n];
            visited = new boolean[n];
            finished = new boolean[n];  // 순환 여부
            cnt = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken()) - 1;
            }

            for (int i = 0; i < n; i++)
                dfs(i);

            sb.append(n - cnt).append('\n');
        }

        System.out.println(sb);
    }

    static void dfs(int now) {
        if (visited[now])
            return;

        visited[now] = true;
        int next = arr[now];

        if (!visited[next]) dfs(next);
        else {
            if (!finished[next]) {
                cnt++;
                for (int i = next; i != now; i = arr[i]) cnt++;
            }
        }

        finished[now] = true;
    }
}
