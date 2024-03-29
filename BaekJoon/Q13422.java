package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q13422 {   // 도둑
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(st.nextToken());

            int sum = 0, answer = 0;
            for (int i = 0; i < m; i++)
                sum += arr[i];

            if (n == m) {
                if (sum < k) answer++;
            } else {
                for (int i = 0; i < n; i++) {
                    sum += arr[(m + i) % n] - arr[i];
                    if (sum < k) answer++;
                }
            }
            sb.append(answer).append('\n');
        }
        System.out.println(sb);
    }
}
