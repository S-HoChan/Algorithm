package ProgrammersLevel3;

public class WordConversion {
    public int solution(String begin, String target, String[] words) {
        int answer = words.length + 1;

        for (int i = 0; i < words.length; i++) {
            boolean[] visited = new boolean[words.length];
            if (check(begin, words[i])) {
                answer = Math.min(answer, dfs(words[i], target, i, words, visited, 1));
            }
        }

        return answer == words.length + 1 ? 0 : answer;
    }

    public boolean check(String begin, String target) {
        int cnt = 0;
        for (int i = 0; i < begin.length(); i++) {
            if (begin.charAt(i) == target.charAt(i)) cnt++;
        }
        return cnt == begin.length() - 1;
    }

    public int dfs(String begin, String target, int idx, String[] words, boolean[] visited, int cnt) {
        if (begin.equals(target)) return cnt;
        if (visited[idx]) return cnt;

        visited[idx] = true;
        int ans = 0;
        for (int i = 0; i < words.length; i++) {
            if (idx == i) continue;
            if (check(begin, words[i]) && !visited[i]) {
                ans = dfs(words[i], target, i, words, visited, cnt + 1);
            }
        }
        return ans;
    }
}
