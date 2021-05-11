package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14888 {   // 연산자 끼워넣기
    private static int n;
    private static int max = Integer.MIN_VALUE;
    private static int min = Integer.MAX_VALUE;
    private static int[] arr;   // 숫자
    private static int[] operator = new int[4]; // 연산자 개수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) operator[i] = Integer.parseInt(st.nextToken());

        dfs(arr[0], 1);

        System.out.println(max);
        System.out.println(min);
    }

    private static void dfs(int num, int idx) {
        if (idx == n) {
            max = Math.max(max, num);
            min = Math.min(min, num);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operator[i] > 0) {
                operator[i]--;

                if (i == 0) dfs(num + arr[idx], idx + 1);
                else if (i == 1) dfs(num - arr[idx], idx + 1);
                else if (i == 2) dfs(num * arr[idx], idx + 1);
                else if (i == 3) dfs(num / arr[idx], idx + 1);

                operator[i]++;
            }
        }
    }
}
