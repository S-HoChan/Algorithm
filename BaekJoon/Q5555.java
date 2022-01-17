package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q5555 {    // 반지
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String string = br.readLine();
        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        while (n-- > 0) {
            String now = br.readLine();
            now = now + now;
            for (int i = 0; i < 10; i++) {
                String temp = now.substring(i, i+string.length());
                if (string.equals(temp)) {
                    answer++;
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}
