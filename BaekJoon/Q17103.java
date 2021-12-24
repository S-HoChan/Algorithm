package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q17103 {   // 골드바흐 파티션
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] visited = new boolean[1000000];   // !visited : primeNumber
        for (int i = 2; i < 1000000; i++) {
            if (!visited[i]) {
                for (int j = i + i; j < 1000000; j += i) {
                    visited[j] = true;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int now = Integer.parseInt(br.readLine());
            int cnt = 0;
            for (int i = 2; i <= now / 2; i++) {
                if (!visited[i] && !visited[now - i]) {
                    cnt++;
                }
            }
            sb.append(cnt).append('\n');
        }
        System.out.println(sb);
    }
}
