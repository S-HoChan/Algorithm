package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q3273 {    // 두 수의 합
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int x = Integer.parseInt(br.readLine());

        Arrays.sort(arr);
        int answer = 0;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > x / 2) break;
            for (int j = n - 1; j > i; j--) {
                if (arr[i] + arr[j] == x) {
                    answer++;
                    break;
                }

                if (arr[i] + arr[j] < x) break;
            }
        }
        System.out.println(answer);
    }
}
