package ProgrammersLevel3;

public class CrossingStone {
    public int solution(int[] stones, int k) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int stone : stones) {
            max = Math.max(max, stone);
            min = Math.min(min, stone);
        }

        return binarySearch(stones, k, min, max);
    }

    public int binarySearch(int[] stones, int k, int low, int high) {
        if (low == high) return low;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (canCross(stones, k, mid)) low = mid + 1;
            else high = mid;
        }

        return low - 1;
    }

    public boolean canCross(int[] stones, int k, int friends) {
        int cnt = 0;

        for (int stone : stones) {
            if (stone - friends < 0) cnt++;
            else cnt = 0;

            if (cnt == k) return false;
        }
        return true;
    }
}
