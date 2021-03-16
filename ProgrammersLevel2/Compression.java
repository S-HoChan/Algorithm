package ProgrammersLevel2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Compression {
    public int[] solution(String msg) {
        HashMap<String, Integer> library = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();

        int idx = 1;
        for (int i = 0; i < 26; i++) {
            char temp = (char) ('A' + i);
            library.put(Character.toString(temp), idx++);
        }   // init

        int i = 0;
        int j;
        while (i < msg.length()) {
            String w = Character.toString(msg.charAt(i));
            j = i;
            while (++j < msg.length()) {  // 출력할 w 찾기
                String wp = w;
                wp += Character.toString(msg.charAt(j));
                if (library.containsKey(wp)) {
                    w = wp;
                } else break;
            }
            if (j >= msg.length()) {
                String wc = msg.substring(i);
                queue.add(library.get(wc));
                break;
            } else {
                queue.add(library.get(w));  // 출력
                String wc = w + Character.toString(msg.charAt(j));
                library.put(wc, idx++);
                i = j;
            }
        }

        int[] answer = new int[queue.size()];
        i = 0;
        while (!queue.isEmpty()) {
            answer[i++] = queue.poll();
        }
        return answer;
    }
}
