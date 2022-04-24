package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11170 {   // 0의 개수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[1_000_001];
        for (int i = 0; i <= 1_000_000; i++) {
            int temp = 0;
            char[] num = String.valueOf(i).toCharArray();
            for (char isZero : num)
                if (isZero == '0') temp++;
            arr[i] = temp;
        }

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int answer = 0;
            for (int i = n; i <= m; i++) {
                answer += arr[i];
            }
            sb.append(answer).append('\n');
        }
        System.out.println(sb);
    }
}
