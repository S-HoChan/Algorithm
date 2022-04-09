package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q3613 {    // Java vs C++
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input = br.readLine();
        if (input.charAt(0) < 'a' || input.charAt(0) > 'z') {
            System.out.println("Error!");
            return;
        }

        if (input.contains("_")) {  // C++
            for (int i = 0; i < input.length(); i++) {
                char now = input.charAt(i);
                if (now >= 'A' && now <= 'Z') {
                    System.out.println("Error!");
                    return;
                } else if (now == '_') {
                    if (i + 1 >= input.length()) {
                        System.out.println("Error!");
                        return;
                    }
                    char next = (char) (input.charAt(++i) - ('a' - 'A'));
                    if (next < 'A' || next > 'Z') {
                        System.out.println("Error!");
                        return;
                    }
                    sb.append(next);
                } else sb.append(now);
            }
        } else {    // Java
            for (int i = 0; i < input.length(); i++) {
                char now = input.charAt(i);
                if (now >= 'A' && now <= 'Z') {
                    sb.append('_').append((char) (now + ('a' - 'A')));
                } else sb.append(now);
            }
        }
        System.out.println(sb);
    }
}
