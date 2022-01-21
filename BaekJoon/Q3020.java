package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q3020 {    // 개똥벌레
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int[] bottomUp = new int[n / 2];  // 석순
        int[] topDown = new int[n / 2];   // 종유석
        for (int i = 0; i < n; i++) {
            int now = Integer.parseInt(br.readLine());
            if (i % 2 == 0) bottomUp[i / 2] = now;
            else topDown[i / 2] = now;
        }
        Arrays.sort(bottomUp);
        Arrays.sort(topDown);

        int cnt = 1;
        int answer = n + 1; // 최소충돌횟수
        for (int i = 1; i <= h; i++) {
            int cnt1 = getCnt(i, bottomUp);
            int cnt2 = getCnt(h - i + 1, topDown);
            if (cnt1 + cnt2 < answer) {
                answer = cnt1 + cnt2;
                cnt = 1;
            } else if (cnt1 + cnt2 == answer) cnt++;
        }
        System.out.println(answer + " " + cnt);
    }

    static int getCnt(int height, int[] arr) {
        int left = 0, right = n / 2 - 1;
        int temp = n + 1; //
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] >= height) {
                temp = Math.min(temp, mid);
                right = mid - 1;
            } else left = mid + 1;
        }
        return temp == n + 1 ? 0 : n / 2 - temp;
    }
}
