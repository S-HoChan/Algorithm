package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q18870 {   // 좌표 압축
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i][0] = i;
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, Comparator.comparingInt(o -> o[1]));

        int[] ans = new int[n];
        int value = -1;
        for (int i = 0; i < n; i++) {
            if (i > 0 && arr[i][1] == arr[i - 1][1]) ans[arr[i][0]] = value;
            else ans[arr[i][0]] = ++value;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(ans[i]);
            if (i != n - 1) sb.append(" ");
        }

        System.out.println(sb);
    }
}
