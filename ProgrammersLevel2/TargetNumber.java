package ProgrammersLevel2;

public class TargetNumber {
    public int solution(int[] numbers, int target) {
        int answer = 0;

        answer = bfs(numbers, target, numbers[0], 1) + bfs(numbers, target, -numbers[0], 1);

        return answer;
    }

    public int bfs(int[] numbers, int target, int sum, int i) {
        int answer = 0;

        if (i == numbers.length) {
            if (target == sum) return 1;
            else return 0;
        }

        answer += bfs(numbers, target, sum + numbers[i], i + 1);
        answer += bfs(numbers, target, sum - numbers[i], i + 1);

        return answer;
    }
}
