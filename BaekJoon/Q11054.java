package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11054 {   // 가장 긴 바이토닉 부분 수열
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;
        int[] dpLeft = new int[n];
        for (int i = 0; i < n; i++) {
            dpLeft[i] = 1;

            for (int left = 0; left < i; left++) {
                if (arr[left] < arr[i] && dpLeft[i] < dpLeft[left] + 1) {
                    dpLeft[i] = dpLeft[left] + 1;
                }
            }
        }

        int[] dpRight = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            dpRight[i] = 1;

            for (int right = n - 1; right > i; right--) {
                if (arr[right] < arr[i] && dpRight[i] < dpRight[right] + 1) {
                    dpRight[i] = dpRight[right] + 1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dpLeft[i] + dpRight[i] - 1);
        }

        System.out.println(ans);
    }
}
