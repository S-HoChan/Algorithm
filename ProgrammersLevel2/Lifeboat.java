package ProgrammersLevel2;

import java.util.Arrays;

public class Lifeboat {
    public static void main(String[] args) {

    }

    public int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);
        int start = 0, end = people.length - 1;
        if (start == end) return 1;

        while (start <= end) {
            answer++;
            if (people[start] + people[end] <= limit) {
                start++;
                end--;
            } else {
                end--;
            }
        }

        return answer;
    }
}
