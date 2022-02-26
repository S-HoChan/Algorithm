package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1755 {    // 숫자놀이
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        for (int num = m; num <= n; num++) {
            list.add(num);
        }
        list.sort((o1, o2) -> {
            String s1 = String.valueOf(o1);
            String s2 = String.valueOf(o2);
            String string1 = numToString(s1.charAt(0));
            if (s1.length() == 2) string1 += numToString(s1.charAt(1));
            String string2 = numToString(s2.charAt(0));
            if (s2.length() == 2) string2 += numToString(s2.charAt(1));

            return string1.compareTo(string2);
        });

        int cnt = 0;
        while(!list.isEmpty()){
            cnt++;
            sb.append(list.remove(0)).append(' ');
            if(cnt == 10){
                cnt = 0;
                sb.append('\n');
            }
        }
        System.out.println(sb);
    }

    static String numToString(char c) {
        if (c == '1') return "one";
        else if (c == '2') return "two";
        else if (c == '3') return "three";
        else if (c == '4') return "four";
        else if (c == '5') return "five";
        else if (c == '6') return "six";
        else if (c == '7') return "seven";
        else if (c == '8') return "eight";
        else if (c == '9') return "nine";
        else return "zero";
    }
}
