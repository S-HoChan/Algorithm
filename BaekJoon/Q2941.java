package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2941 {    // 크로아티아 알파벳
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word = br.readLine();
        int answer = 0;

        for (int i = 0; i < word.length(); i++) {
            char now = word.charAt(i);

            if (now == 'c') {
                if (i < word.length() - 1 && (word.charAt(i + 1) == '=' || word.charAt(i + 1) == '-')) {
                    i += 1;
                }
            } else if (now == 'd'){
                if(i < word.length() - 2 && word.charAt(i+1) == 'z' && word.charAt(i + 2) == '='){
                    i += 2;
                } else if (i < word.length() - 1 && word.charAt(i + 1) == '-'){
                    i += 1;
                }
            } else if (now == 'l'){
                if(i < word.length() - 1 && word.charAt(i+1) == 'j'){
                    i += 1;
                }
            } else if (now == 'n'){
                if(i < word.length() - 1 && word.charAt(i+1) == 'j'){
                    i += 1;
                }
            } else if (now == 's'){
                if(i < word.length() - 1 && word.charAt(i+1) == '='){
                    i += 1;
                }
            }else if (now == 'z'){
                if(i < word.length() - 1 && word.charAt(i+1) == '='){
                    i += 1;
                }
            }

            answer++;
        }

        System.out.println(answer);
    }
}
