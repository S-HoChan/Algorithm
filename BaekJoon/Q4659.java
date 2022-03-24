package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q4659 {    // 비밀번호 발음하기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String string = br.readLine();
            if (string.equals("end")) break;

            boolean isOk = true;
            boolean preVowel = isVowel(string.charAt(0));
            boolean haveVowel = preVowel;
            int nowCount = 1;
            for (int i = 1; i < string.length(); i++) {
                char now = string.charAt(i);
                if (isVowel(now)) {
                    haveVowel = true;
                    if (preVowel) {
                        nowCount++;
                    } else {
                        preVowel = true;
                        nowCount = 1;
                    }
                } else {
                    if (preVowel) {
                        preVowel = false;
                        nowCount = 1;
                    } else {
                        nowCount++;
                    }
                }

                if (nowCount == 3) {
                    isOk = false;
                    break;
                }
                if (!(now == 'e' || now == 'o') && string.charAt(i - 1) == now) {
                    isOk = false;
                    break;
                }
            }

            sb.append("<").append(string).append("> is ");
            if (!isOk || !haveVowel) sb.append("not ");
            sb.append("acceptable.").append('\n');
        }
        System.out.println(sb);
    }

    static boolean isVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') return true;
        return false;
    }
}
