package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q10816 {   // 숫자 카드 2
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        while (m-- > 0) {
            int now = Integer.parseInt(st.nextToken());

            int idx1 = div1(now);
            int idx2 = div2(now);
            sb.append(idx2 - idx1).append(' ');
        }

        System.out.println(sb);
    }

    private static int div1(int k) {
        int left = 0, right = arr.length - 1, mid;
        while (left < right) {
            mid = (left + right) / 2;
            if (arr[mid] >= k) right = mid;
            else left = mid + 1;
        }
        return right;
    }

    private static int div2(int k) {
        int left = 0, right = arr.length - 1, mid;
        while (left < right) {
            mid = (left + right) / 2;
            if (arr[mid] > k) right = mid;
            else left = mid + 1;
        }

        if (arr[right] == k) right++;
        return right;
    }
}
