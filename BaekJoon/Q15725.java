package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q15725 {   // 다항함수의 미분
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String string = br.readLine();
        if (!string.contains("x")) System.out.println(0);
        else if (string.charAt(0) == 'x') System.out.println(1);
        else if (string.substring(0, 2).equals("-x")) System.out.println(-1);
        else {
            int idx = string.indexOf('x');
            int left = 0;
            for (int i = idx - 1; i >= 0; i--) {
                if (string.charAt(i) == '-') {
                    left = i;
                    break;
                }
            }
            System.out.println(string.substring(left, idx));
        }
    }
}
