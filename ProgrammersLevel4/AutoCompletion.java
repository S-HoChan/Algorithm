package ProgrammersLevel4;

import java.util.*;

public class AutoCompletion {
    public int solution(String[] words) {
        int answer = 0;
        Arrays.sort(words);

        int value = len(words[0], words[1]);
        if (value < words[0].length()) answer += value + 1;
        else answer += value;

        for (int i = 1; i < words.length - 1; i++) {
            value = Math.max(len(words[i], words[i + 1]), len(words[i - 1], words[i]));
            if (value < words[i].length()) answer += value + 1;
            else answer += value;
        }

        value = len(words[words.length - 2], words[words.length - 1]);
        if (value < words[words.length - 1].length()) answer += value + 1;
        else answer += value;

        return answer;
    }

    private int len(String s1, String s2) {
        int len = 0;
        for (int i = 0; i < s1.length() && i < s2.length(); i++) {
            if (s1.charAt(i) == s2.charAt(i)) len++;
            else break;
        }
        return len;
    }

    // Trie로 풀기
    class Trie {
        Map<Character, Trie> children;
        int cnt;

        public Trie() {
            children = new HashMap<>();
        }
    }

    public int solution2(String[] words) {
        int answer = 0;
        Trie root = new Trie();
        for (String word : words) { // Trie에 단어 삽입
            for (char c : word.toCharArray()) {
                root = root.children.computeIfAbsent(c, l -> new Trie());
                root.cnt++;
            }
        }
        for (String word : words) { // 필요한 글자 수 계산
            for (char c : word.toCharArray()) {
                root = root.children.get(c);
                answer++;
                if (root.cnt == 1) break;
            }
        }

        return answer;
    }
}
