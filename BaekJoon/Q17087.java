package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q17087 {   // 숨바꼭질 6
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Math.abs(s - Integer.parseInt(st.nextToken()));
        }
        int answer = arr[0];
        for (int i = 1; i < n; i++) {
            answer = gcd(answer, arr[i]);
        }
        System.out.println(answer);
    }

    static int gcd(int a, int b) {
        int m = Math.max(a, b);
        int n = Math.min(a, b);
        while (n > 0) {
            int temp = n;
            n = m % n;
            m = temp;
        }
        return m;
    }
}
