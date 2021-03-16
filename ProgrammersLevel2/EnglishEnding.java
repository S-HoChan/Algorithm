package ProgrammersLevel2;

import java.util.LinkedList;
import java.util.Queue;

public class EnglishEnding {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        Queue<String> queue = new LinkedList<>();

        int count = 1, idx = 0;

        for (String word : words) {
            idx++;
            if (idx > n) {
                idx -= n;
                count++;
            }

            if (queue.isEmpty()) {
                queue.add(word);
                continue;
            }

            String lastWord = ((LinkedList<String>) queue).peekLast();

            if (queue.contains(word) || lastWord.charAt(lastWord.length() - 1) != word.charAt(0)) {
                answer[0] = idx;
                answer[1] = count;
                break;
            }
            queue.add(word);
        }

        return answer;
    }
}
