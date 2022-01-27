package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q11497 {   // 통나무 건너뛰기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);
            int answer = arr[2] - arr[0];
            for (int i = 3; i < n - 1; i += 2) {
                answer = Math.max(answer, Math.max(arr[i] - arr[i - 2], arr[i + 1] - arr[i - 1]));
            }
            answer = Math.max(answer, arr[n - 1] - arr[n - 3]);
            sb.append(answer).append('\n');
        }
        System.out.println(sb);
    }
}
