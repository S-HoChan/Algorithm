package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q14465 {   // 소가 길을 건너간 이유 5
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        boolean[] isBroken = new boolean[n + 1];
        while (b-- > 0) {
            isBroken[Integer.parseInt(br.readLine())] = true;
        }

        int temp = 0;   // 망가진 갯수
        int answer = n + 1;
        for (int i = 1; i < k; i++) {
            if (isBroken[i]) temp++;
        }
        for (int i = k; i <= n; i++) {
            if (isBroken[i]) temp++;
            if (isBroken[i - k]) temp--;
            answer = Math.min(answer, temp);
        }
        System.out.println(answer);
    }
}
