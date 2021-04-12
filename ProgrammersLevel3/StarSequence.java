package ProgrammersLevel3;

import java.util.HashMap;

public class StarSequence {
    public int solution(int[] a) {
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>(a.length);

        for (int i = 0; i < a.length; i++) {
            if (!map.containsKey(a[i])) map.put(a[i], 1);
            else map.put(a[i], map.get(a[i]) + 1);
        }

        for (int key : map.keySet()) {
            if (map.get(key) * 2 <= answer) continue;
            int star = 0;
            for (int j = 0; j < a.length - 1; j++) {
                if ((a[j] == key || a[j + 1] == key) && a[j] != a[j + 1]) {
                    star += 2;
                    j++;
                }
            }
            answer = Math.max(answer, star);
        }

        return answer;
    }
}
