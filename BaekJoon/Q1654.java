package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1654 {    // 랜선 자르기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        long left = 1, right = arr[n - 1];
        while (left <= right) {
            long middle = (left + right) / 2;
            long cnt = 0;

            for (int i = 0; i < n; i++) {
                cnt += arr[i] / middle;
            }

            if (cnt >= k) left = middle + 1;
            else right = middle - 1;
        }

        System.out.println(right);
    }
}
