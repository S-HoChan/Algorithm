package ProgrammersLevel4;

import java.util.Arrays;

public class FIFOScheduling {
    public int solution(int n, int[] cores) {
        int min = 10001;
        if (n <= cores.length) return n;

        for (int core : cores) min = Math.min(min, core);
        int minTime = n / cores.length * min;
        int maxTime = n * min;
        int midTime = (minTime + maxTime) / 2;

        while (minTime < maxTime) {
            int count = 0;
            int availableCount = 0;

            for (int core : cores) {
                count += (midTime / core) + 1;
                if (midTime % core == 0) {
                    availableCount++;
                    count--;
                }
            }

            if (count >= n) maxTime = midTime;
            else if (count + availableCount < n) minTime = midTime + 1;
            else {
                for (int i = 0; i < cores.length; i++) {
                    if (midTime % cores[i] == 0) count++;
                    if (count == n) return i + 1;
                }
            }

            midTime = (minTime + maxTime) / 2;
        }

        return -1;
    }
}
