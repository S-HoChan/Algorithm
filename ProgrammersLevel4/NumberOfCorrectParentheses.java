package ProgrammersLevel4;

public class NumberOfCorrectParentheses {
    public int solution(int n) {
        return cp(n, n);
    }

    public int cp(int left, int right) {
        if (left == 0 && right == 0) return 1;
        else if (left > right || left < 0 || right < 0) return 0;

        return cp(left - 1, right) + cp(left, right - 1);
    }
}
