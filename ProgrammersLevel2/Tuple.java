package ProgrammersLevel2;

import java.util.HashMap;

public class Tuple {
    public int[] solution(String s) {
        int[] answer = {};
        String temp = "";
        HashMap<Integer, Integer> map = new HashMap<>();
        int cnt = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '{') continue;
            else if (s.charAt(i) == '}' || s.charAt(i) == ',') {
                if (s.charAt(i - 1) != '}') {
                    if(s.charAt(i) == '}') cnt++;
                    int num = Integer.parseInt(temp);
                    temp = "";
                    if (map.containsKey(num)) {
                        map.put(num, map.get(num) + 1);
                    } else {
                        map.put(num, 1);
                    }
                }
            } else {
                temp += s.charAt(i);
            }
        }

        answer = new int[cnt];
        for (int i = 0; i < answer.length; i++) {
            for (int key : map.keySet()) {
                if (cnt == map.get(key)) {
                    answer[i] = key;
                    cnt--;
                    break;
                }
            }
        }

        return answer;
    }
}
