package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Q2002 {    // 추월
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        LinkedList<String> queue = new LinkedList<>();
        for (int i = 0; i < n; i++)
            queue.add(br.readLine());

        int answer = 0;
        for (int i = 0; i < n; i++) {
            String now = br.readLine();
            if (now.equals(queue.peek()))
                queue.pop();
            else {
                answer++;
                queue.remove(now);
            }
        }
        System.out.println(answer);
    }
}
