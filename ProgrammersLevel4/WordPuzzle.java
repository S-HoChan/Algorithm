package ProgrammersLevel4;

public class WordPuzzle {
    public int solution(String[] strs, String t) {
        int[] dp = new int[t.length()];

        for (int i = 1; i < t.length() + 1; i++) {
            for (int j = 0; j < strs.length; j++) {
                String puzzle = strs[j];
                if (i - puzzle.length() < 0) continue;
                if (puzzle.equals(t.substring(i - puzzle.length(), i))) {   // i까지 동일한 puzzle이 있는지 확인
                    if (i - puzzle.length() == 0) {
                        dp[i - 1] = 1;  // 길이와 맞는 puzzle이 있는 경우 해당 퍼즐을 사용한다
                        continue;
                    }
                    if (dp[i - puzzle.length() - 1] > 0) {
                        dp[i - 1] = dp[i - 1] == 0 ? dp[i - puzzle.length() - 1] + 1 :
                                Math.min(dp[i - 1], dp[i - puzzle.length() - 1] + 1);
                    }
                }
            }
        }

        int answer = dp[dp.length - 1];
        return answer == 0 ? -1 : answer;
    }
}
