package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q23629 {   // 이 얼마나 끔찍하고 무시무시한 수식이니
    static String input;
    static long answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < input.length()) {
            int n = getNum(i);
            if (n == -1) {
                char op = getOper(i);
                if (op == '_') {
                    System.out.println("Madness!");
                    return;
                } else {
                    sb.append(op);
                    i++;
                }
                continue;
            }

            if (n == 3 || n == 7 || n == 8) {
                i += 5;
            } else if (n == 0 || n == 4 || n == 5 || n == 9) {
                i += 4;
            } else {    // n == 1 || n == 2 || n == 6
                i += 3;
            }
            sb.append(n);
        }

        input = sb.toString();
        sb.append('\n');
        char oper = '+';
        i = 0;
        while (oper != '=') {
            for (int j = i; j < input.length(); j++) {
                char now = input.charAt(j);
                if (!(now >= '0' && now <= '9')) {
                    if (oper == '+')
                        answer += Long.parseLong(input.substring(i, j));
                    else if (oper == '-')
                        answer -= Long.parseLong(input.substring(i, j));
                    else if (oper == 'x')
                        answer *= Long.parseLong(input.substring(i, j));
                    else if (oper == '/')
                        answer /= Long.parseLong(input.substring(i, j));

                    i = j + 1;
                    oper = now;
                }
            }
        }

        char[] in = String.valueOf(answer).toCharArray();
        for (char c : in) {
            if (c == '0') sb.append("ZERO");
            else if (c == '1') sb.append("ONE");
            else if (c == '2') sb.append("TWO");
            else if (c == '3') sb.append("THREE");
            else if (c == '4') sb.append("FOUR");
            else if (c == '5') sb.append("FIVE");
            else if (c == '6') sb.append("SIX");
            else if (c == '7') sb.append("SEVEN");
            else if (c == '8') sb.append("EIGHT");
            else if (c == '9') sb.append("NINE");
            else sb.append('-');    // c == '-'
        }
        System.out.println(sb);
    }

    static int getNum(int i) {
        String temp;
        if (i + 4 < input.length()) {
            temp = input.substring(i, i + 5);
            if (temp.equals("THREE")) return 3;
            if (temp.equals("SEVEN")) return 7;
            if (temp.equals("EIGHT")) return 8;
        }
        if (i + 3 < input.length()) {
            temp = input.substring(i, i + 4);
            if (temp.equals("ZERO")) return 0;
            if (temp.equals("FOUR")) return 4;
            if (temp.equals("FIVE")) return 5;
            if (temp.equals("NINE")) return 9;
        }
        if (i + 2 < input.length()) {
            temp = input.substring(i, i + 3);
            if (temp.equals("ONE")) return 1;
            if (temp.equals("TWO")) return 2;
            if (temp.equals("SIX")) return 6;
        }
        return -1;
    }

    static char getOper(int i) {
        char oper = input.charAt(i);
        if (oper >= 'A' && oper <= 'Z') return '_';
        char pre = input.charAt(i - 1);
        if (!(pre >= 'A' && pre <= 'Z')) return '_';
        return oper;
    }
}
