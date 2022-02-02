package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1515 {    // 수 이어 쓰기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String string = br.readLine();
        int num = 0, idx = 0;
        while (idx < string.length()) {
            num++;
            String number = Integer.toString(num);
            for (int i = 0; i < number.length() && idx < string.length(); i++) {
                if (number.charAt(i) == string.charAt(idx)) {
                    idx++;
                }
            }
        }
        System.out.println(num);
    }
}
