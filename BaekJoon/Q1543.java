package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1543 {    // 문서 검색
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String string = br.readLine();
        String word = br.readLine();

        int answer = 0;
        for (int i = 0; i < string.length() - word.length() + 1; i++) {
            String temp = string.substring(i, i + word.length());
            if (temp.equals(word)) {
                i += word.length() - 1;
                answer++;
            }
        }
        System.out.println(answer);
    }
}
