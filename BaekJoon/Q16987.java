package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q16987 {   // 계란으로 계란치기
    static int n, answer = 0;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());   // 내구도
            arr[i][1] = Integer.parseInt(st.nextToken());   // 무게
        }

        dfs(0, 0);
        System.out.println(answer);
    }

    static void dfs(int idx, int cnt) {
        if (idx == n) {
            answer = Math.max(answer, cnt);
            return;
        }
        if (arr[idx][0] <= 0 || cnt == n - 1) {
            dfs(idx + 1, cnt);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (i == idx) continue;
            if (arr[i][0] > 0) {
                arr[i][0] -= arr[idx][1];
                arr[idx][0] -= arr[i][1];   // crash
                int nextCnt = cnt;
                if (arr[i][0] <= 0) nextCnt++;
                if (arr[idx][0] <= 0) nextCnt++;
                dfs(idx + 1, nextCnt);
                arr[i][0] += arr[idx][1];
                arr[idx][0] += arr[i][1];   // restore
            }
        }
    }
}
