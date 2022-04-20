package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1477 {    // 휴게소 세우기
    static int[] arr;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        arr = new int[n + 2];
        arr[0] = 0;
        arr[n + 1] = l;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);

        int left = 1, right = l;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (isOk(mid)) left = mid + 1;
            else right = mid - 1;
        }
        System.out.println(left);
    }

    static boolean isOk(int n) {
        int temp = 0;
        for (int i = 1; i < arr.length; i++)
            temp += (arr[i] - arr[i - 1] - 1) / n;
        return temp > m;
    }
}
