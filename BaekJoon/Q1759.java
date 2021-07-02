package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Q1759 {    // 암호 만들기
    static StringBuilder sb = new StringBuilder();
    static int l, c;
    static char[] arr;
    static List<Character> vowels = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new char[c];

        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < c; i++) {
            arr[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(arr);

        search(0, 0, "");

        System.out.println(sb);
    }

    private static void search(int idx, int cnt, String str) {
        if (cnt == l) {
            int ae = 0;
            for (int i = 0; i < l; i++) {
                if (vowels.contains(str.charAt(i))) ae++;
            }

            if (ae < 1 || l - ae < 2) return;

            sb.append(str).append('\n');
            return;
        }

        if (idx >= c) return;

        search(idx + 1, cnt + 1, str + arr[idx]);
        search(idx + 1, cnt, str);
    }
}
