package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q11656 {   // 접미사 배열
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            list.add(s.substring(i));
        }
        Collections.sort(list);
        while (!list.isEmpty()) {
            sb.append(list.remove(0)).append('\n');
        }
        System.out.println(sb);
    }
}
