package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2312 {    // 수 복원하기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[100000];
            for (int i = 2; i * i <= n; i++) {
                if (n % i == 0) {
                    n /= i;
                    arr[i]++;
                    i--;
                }
            }
            if (n > 1) arr[n]++;

            for (int i = 2; i < 100000; i++) {
                if (arr[i] != 0) {
                    sb.append(i).append(' ').append(arr[i]).append('\n');
                }
            }
        }
        System.out.println(sb);
    }
}
