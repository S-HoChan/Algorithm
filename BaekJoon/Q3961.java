package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q3961 {    // 터치스크린 키보드
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        String[] keyboard = new String[3];
        keyboard[0] = "qwertyuiop";
        keyboard[1] = "asdfghjkl-";
        keyboard[2] = "zxcvbnm---";

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String input = st.nextToken();
            int[][] arr = new int[input.length()][2];
            for (int i = 0; i < input.length(); i++) {
                int[] temp = calc(keyboard, input.charAt(i));
                arr[i][0] = temp[0];
                arr[i][1] = temp[1];
            }
            Map<String, Integer> map = new HashMap<>();
            int l = Integer.parseInt(st.nextToken());
            while (l-- > 0) {
                String word = br.readLine();
                int length = 0;
                for (int i = 0; i < word.length(); i++) {
                    int[] temp = calc(keyboard, word.charAt(i));
                    length += Math.abs(arr[i][0] - temp[0]) + Math.abs(arr[i][1] - temp[1]);
                }
                map.put(word, length);
            }
            List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
            Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    if (o1.getValue() > o2.getValue()) return 1;
                    else if (o1.getValue().equals(o2.getValue())) {
                        return o1.getKey().compareTo(o2.getKey());
                    } else return -1;
                }
            });
            for (Map.Entry<String, Integer> entry : list) {
                sb.append(entry.getKey()).append(' ').append(entry.getValue()).append('\n');
            }
        }
        System.out.println(sb);
    }

    static int[] calc(String[] keyboard, char c) {
        int[] temp = new int[2];
        for (int y = 0; y < 3; y++) {
            if (keyboard[y].indexOf(c) > 0) {
                temp[0] = y;
                temp[1] = keyboard[y].indexOf(c);
                break;
            }
        }
        return temp;
    }
}
