package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1920 {    // 수 찾기
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (m-- > 0) {
            if (div(0, n - 1, Integer.parseInt(st.nextToken()))) {
                sb.append('1').append('\n');
            } else sb.append('0').append('\n');
        }

        System.out.println(sb);
    }

    private static boolean div(int left, int right, int now) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] > now) right = mid - 1;
            else if (arr[mid] < now) left = mid + 1;
            else return true;
        }
        return false;
    }
}
