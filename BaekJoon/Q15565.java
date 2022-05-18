package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q15565 {   // 귀여운 라이언
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int answer = n + 1;
        st = new StringTokenizer(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++)
            if (Integer.parseInt(st.nextToken()) == 1)
                list.add(i);

        for (int i = 0; i + k - 1 < list.size(); i++)
            answer = Math.min(answer, list.get(i + k - 1) - list.get(i) + 1);
        System.out.println(answer == n + 1 ? -1 : answer);
    }
}
