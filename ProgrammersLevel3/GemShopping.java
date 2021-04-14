package ProgrammersLevel3;

import java.util.*;

public class GemShopping {
    public int[] solution(String[] gems) {
        HashSet<String> set = new HashSet<>(Arrays.asList(gems));
        HashMap<String, Integer> map = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        int start = 0, length = gems.length;
        int idx = 0;

        for (int i = 0; i < gems.length; i++) {
            if (map.containsKey(gems[i])) map.put(gems[i], map.get(gems[i]) + 1);
            else map.put(gems[i], 1);

            queue.add(gems[i]);
            while (true) {    // 시작점 옮기기
                String temp = queue.peek(); // 첫 보석
                if (map.get(temp) > 1) {
                    queue.poll();
                    idx++;
                    map.put(temp, map.get(temp) - 1);
                } else break;
            }

            if (set.size() == map.size() && length > queue.size()) {
                start = idx;
                length = queue.size();
            }
        }

        return new int[]{start + 1, start + length};
    }
}
