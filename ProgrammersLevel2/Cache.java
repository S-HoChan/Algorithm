package ProgrammersLevel2;

import java.util.LinkedList;
import java.util.Queue;

public class Cache {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < cities.length; i++) {
            cities[i] = cities[i].toLowerCase();
        }

        int cnt = 0;
        for (String city : cities) {
            if (cacheSize == 0) {
                answer += 5;
                continue;
            }

            if (queue.contains(city)) {
                Queue<String> temp = new LinkedList<>();
                while(!queue.isEmpty()) {
                    String t = queue.poll();
                    if (!t.equals(city)) {
                        temp.add(t);
                    }
                }
                while (!temp.isEmpty()) {
                    queue.add(temp.poll());
                }
                queue.add(city);
                answer += 1;
            } else {
                if (cnt < cacheSize) {
                    queue.add(city);
                    cnt++;
                } else {
                    queue.poll();
                    queue.add(city);
                }
                answer += 5;
            }
        }
        return answer;
    }
}
