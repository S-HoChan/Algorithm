package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1120 {    // 문자열
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String first = st.nextToken();
        String second = st.nextToken();
        int answer = 51;
        for (int i = 0; i + first.length() <= second.length(); i++) {
            int count = 0;
            for (int j = 0; j < first.length(); j++) {
                if (first.charAt(j) != second.charAt(i + j)) {
                    count++;
                }
            }
            answer = Math.min(answer, count);
        }
        System.out.println(answer);
    }
}
