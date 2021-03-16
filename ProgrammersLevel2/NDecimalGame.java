package ProgrammersLevel2;

import java.util.LinkedList;

public class NDecimalGame {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        char[] num = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

        LinkedList<Character> list = new LinkedList<>();
        list.add('0');
        int c = t * m + p;

        int number = 1;
        int cnt = 1;
        while (cnt < c) {
            int value = number;
            String temp = "";
            while (value > 0) {
                temp = num[value % n] + temp;
                value /= n;
            }
            for (int i = 0; i < temp.length(); i++) {
                list.add(temp.charAt(i));
                cnt++;
            }
            number++;
        }

        cnt = 0;
        number = 0;
        while (cnt < t) {
            number++;
            char nn = list.poll();
            if (number % m == p || ((p == m) && number % m == 0)) {
                answer += nn;
                cnt++;
            }
        }

        return answer;
    }
}
