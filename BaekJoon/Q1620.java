package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Q1620 {    // 나는야 포켓몬 마스터 이다솜
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Map<Integer, String> numToName = new HashMap<>();
        Map<String, Integer> nameToNum = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            String name = br.readLine();
            nameToNum.put(name, i);
            numToName.put(i, name);
        }

        StringBuilder sb = new StringBuilder();
        while (m-- > 0) {
            String nameOrNum = br.readLine();
            if (nameOrNum.charAt(0) >= '0' && nameOrNum.charAt(0) <= '9') { // isNum
                sb.append(numToName.get(Integer.valueOf(nameOrNum))).append('\n');
            } else sb.append(nameToNum.get(nameOrNum)).append('\n');
        }
        System.out.println(sb);
    }
}
