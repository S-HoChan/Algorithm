package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1016 {    // 제곱 ㄴㄴ 수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());
        int sqrt = (int) Math.sqrt(max);

        int size = (int) (max - min + 1);
        boolean[] visited = new boolean[size]; // false : 제곱 ㄴㄴ 수
        for (long i = 2; i <= sqrt; i++) {
            long squared = i * i;
            long start = min % squared == 0 ? min / squared : min / squared + 1;
            for (long j = start; j * squared <= max; j++)
                visited[(int) (j * squared - min)] = true;
        }

        int answer = 0;
        for (boolean check : visited)
            if (!check) answer++;
        System.out.println(answer);
    }
}
