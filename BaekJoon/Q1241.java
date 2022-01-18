package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1241 {    // 머리 톡톡
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] cnt = new int[1000001];
        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            cnt[arr[i]]++;
        }

        for (int i = 0; i < n; i++) {
            int now = arr[i];
            for (int k = 1; k * k <= now; k++) {
                if (now % k == 0) {
                    answer[i] += cnt[k];
                    if (k * k < now) answer[i] += cnt[now / k]; // 약수 쌍
                }
            }
        }

        for (int i = 0; i < n; i++) {
            sb.append(answer[i] - 1).append('\n');
        }
        System.out.println(sb);
    }
}
