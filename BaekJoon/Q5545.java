package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q5545 {    // 최고의 피자
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());   // dough price
        int b = Integer.parseInt(st.nextToken());   // topping price
        int dough = Integer.parseInt(br.readLine());    // cal
        int[] topping = new int[n];
        for (int i = 0; i < n; i++) {
            topping[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(topping);
        int answer = dough / a;     // (dough + topping) / (a + b*k)
        for (int i = n - 1; i >= 0; i--) {
            a += b; // total price
            dough += topping[i];    // total calory
            int now = dough / a;
            if (answer > now) break;
            answer = now;
        }

        System.out.println(answer);
    }
}
