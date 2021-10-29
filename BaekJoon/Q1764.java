package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1764 {    // 듣보잡
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Set<String> notListen = new HashSet<>();
        List<String> list = new ArrayList<>();

        while (n-- > 0) {
            notListen.add(br.readLine());
        }
        while (m-- > 0) {
            String now = br.readLine();
            if(notListen.contains(now)){
                list.add(now);
            }
        }

        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        sb.append(list.size()).append('\n');
        while(!list.isEmpty()){
            sb.append(list.remove(0)).append('\n');
        }
        System.out.println(sb);
    }
}
