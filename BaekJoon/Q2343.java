package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2343 {    // 기타 레슨
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int left = 0, right = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            left = Math.max(left, arr[i]);
            right += arr[i];
        }
        while (left <= right) {
            int mid = (left + right) / 2;
            int cnt = 0;    // 사용한 블루레이의 개수
            int sum = 0;    // 현재 블루레이에 저장된 용량
            for (int i = 0; i < n; i++) {
                if (sum + arr[i] > mid) {
                    sum = 0;
                    cnt++;
                }
                sum += arr[i];
            }
            if (sum > 0) cnt++;

            if (cnt > m) left = mid + 1;
            else right = mid - 1;
        }
        System.out.println(left);
    }
}
