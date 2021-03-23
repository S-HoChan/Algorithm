package ProgrammersLevel3;

public class LongJump {
    public long solution(int n) {
        long answer = 0;
        long[] arr = new long[n + 1];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i-1] + arr[i-2];
            arr[i] %= 1234567;
        }

        return arr[n];
    }
}
