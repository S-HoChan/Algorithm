package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1027 {    // 고층 건물
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] visible = new int[n];
        for (int i = 0; i < n - 1; i++) { // >> 방향만 탐색
            visible[i]++;
            visible[i + 1]++;   // 옆 건물은 보인다

            double ang = arr[i + 1] - arr[i]; // 각도
            for (int j = i + 2; j < n; j++) {
                double nextAng = (double) (arr[j] - arr[i]) / (j - i);
                if (nextAng <= ang) continue;

                ang = nextAng;
                visible[i]++;
                visible[j]++;
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, visible[i]);
        }
        System.out.println(ans);
    }
}
