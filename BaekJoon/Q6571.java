package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q6571 {    // 피보나치 수의 개수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        ArrayList<String> list = new ArrayList<>();
        list.add("1");  // f0
        list.add("1");  // f1
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            String b = st.nextToken();
            if (a.equals("0") && b.equals("0")) break;

            while (isSmaller(list.get(list.size() - 1), b)) {
                list.add(addOper(list.get(list.size() - 2), list.get(list.size() - 1)));
            }

            int count = 0;
            for (int i = 1; i < list.size(); i++) {
                String now = list.get(i);
                if (isSmaller(a, now) && isSmaller(now, b)) count++;
            }

            sb.append(count).append('\n');
        }
        System.out.println(sb);
    }

    static boolean isSmaller(String s1, String s2) {
        if (s1.length() < s2.length()) return true;
        else if (s1.length() > s2.length()) return false;
        else {
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) < s2.charAt(i)) return true;
                else if (s1.charAt(i) > s2.charAt(i)) return false;
            }
        }
        return true;    // if same, return true;
    }

    static String addOper(String s1, String s2) {
        int idx1 = s1.length() - 1, idx2 = s2.length() - 1;
        int sum = 0;
        StringBuilder temp = new StringBuilder();
        while (idx1 >= 0 || idx2 >= 0 || sum > 0) {
            if (idx1 >= 0) {
                sum += s1.charAt(idx1--) - '0';
            }
            if (idx2 >= 0) {
                sum += s2.charAt(idx2--) - '0';
            }

            temp.insert(0, (sum % 10));
            sum /= 10;
        }
        return temp.toString();
    }
}
