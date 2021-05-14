package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Q1541 {    // 잃어버린 괄호
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        ArrayList<Integer> num = new ArrayList<>();
        ArrayList<Character> operator = new ArrayList<>();

        int idx = 0;
        for (int i = 0; i < str.length(); i++) {
            if (!(str.charAt(i) >= '0' && str.charAt(i) <= '9')) {
                num.add(Integer.parseInt(str.substring(idx, i)));
                operator.add(str.charAt(i));
                idx = i + 1;
            }
        }
        num.add(Integer.parseInt(str.substring(idx, str.length())));

        int ans = num.get(0);
        boolean plus = true;    // 이전 연산자가 '+'만 있는가?
        int temp = 0;
        for (int i = 0; i < operator.size(); i++) {
            if (operator.get(i) == '-') {
                if (plus) {
                    plus = false;
                } else {
                    ans -= temp;
                }
                temp = num.get(i + 1);
            } else {
                if (plus) {
                    ans += num.get(i + 1);
                } else {
                    temp += num.get(i + 1);
                }
            }
        }

        if (plus) ans += temp;
        else ans -= temp;

        System.out.println(ans);
    }
}
